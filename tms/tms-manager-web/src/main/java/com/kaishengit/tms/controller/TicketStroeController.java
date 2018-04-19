package com.kaishengit.tms.controller;

import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


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
    public String home(Model model){
        List<TicketStroe> ticketStroeList = ticketStoreService.findAllTicketStrop();
        model.addAttribute("ticketStroeList", ticketStroeList);
        return "/store/home";
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


}
