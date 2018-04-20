package com.kaishengit.tms.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.StroeAccount;
import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketStoreService;
import com.sun.javafx.binding.StringFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;


/** 售票点
 *
 * @Author Reich
 * @Date: 2018/4/19 16:35
 */
@Controller
@RequestMapping("/ticketstore")
public class TicketStroeController {

    @Autowired
    private TicketStoreService ticketStoreService;

    //home
    @GetMapping
    public String home(Model model,
                       @RequestParam(required = false, defaultValue = "1") Integer pageNo,
                       @RequestParam(required = false, defaultValue = "") String stroeName,
                       @RequestParam(required = false, defaultValue = "") String stroeMobile,
                       @RequestParam(required = false, defaultValue = "") String stroeManager
                       ){

        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("stroeName", stroeName);
        queryParam.put("stroeMobile",stroeMobile);
        queryParam.put("stroeManager", stroeManager);

        PageInfo<TicketStroe> pageInfo = ticketStoreService.findAllTicketStropByPageNo(pageNo, queryParam);
        model.addAttribute("pageInfo", pageInfo);
        return "/store/home";
    }

    @GetMapping("/{id:\\d+}")
    public String showTicketStroe(@PathVariable Integer id, Model model){
        //通过ticketStroe id查找该对象
        TicketStroe ticketStroe = ticketStoreService.findTicketStroeById(id);

         if (ticketStroe == null){
             throw new ServiceException("参数异常");
         }
        //stroeAccount和ticketStroe是一对一的关系
        StroeAccount stroeAccount = ticketStoreService.findStroeAccountById(id);
        model.addAttribute("ticketStroe", ticketStroe);
        model.addAttribute("stroeAccount", stroeAccount);
        return "/store/details";
    }

    /**新增
     *
     * @Author Reich
     * @Date: 2018/4/19 22:14
     */
    @GetMapping("/new")
    public String newSale(){
        return "/store/new";
    }

    /**根据id修改ticketStroe
     *
     * @Author Reich
     * @Date: 2018/4/19 22:15
     */
    @GetMapping("/{id:\\d+}/edit")
    public String editTicletStroe(@PathVariable Integer id,Model model){
        TicketStroe ticketStroe = ticketStoreService.findTicketStroeById(id);
        model.addAttribute("ticketStroe",ticketStroe);
        return "/store/edit";
    }

    @PostMapping("/{id:\\d+}/edit")
    public String editTicletStroe(@PathVariable Integer id, TicketStroe ticketStroe){
        ticketStoreService.updateTicketStroe(id, ticketStroe);
        return "redirect:/ticketstore";
    }

    /**根据id删除ticketStroe
     *
     * @Author Reich
     * @Date: 2018/4/19 22:13
     */
    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delTicketStroe(@PathVariable Integer id){
        try {
            ticketStoreService.delTicketStroe(id);
            return ResponseBean.success("删除成功");
        }catch (ServiceException e){
            return ResponseBean.error(e.getMessage());
        }
    }

    /**禁用代理
     *
     * @Author Reich
     * @Date: 2018/4/20 14:24
     */
    @GetMapping("/{id:\\d+}/prohibited")
    @ResponseBody
    public ResponseBean prohibitedTicketStroe(@PathVariable Integer id){

        try {

            ticketStoreService.prohibitedTicketStroeById(id);
            return ResponseBean.success();
        }catch (ServiceException e){
            return ResponseBean.error("系统繁忙");
        }

    }


}
