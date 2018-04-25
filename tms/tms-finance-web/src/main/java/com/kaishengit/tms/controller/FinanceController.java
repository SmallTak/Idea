package com.kaishengit.tms.controller;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.TicketOutRecord;
import com.kaishengit.tms.service.TicketService;
import com.kaishengit.tms.service.TicketStoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**财务结算
 *
 * @Author Reich
 * @Date: 2018/4/24 12:24
 */
@Controller
@RequestMapping("/finance/ticket")
public class FinanceController {

    @Autowired
    private TicketService ticketService;

    @Autowired
    private TicketStoreService ticketStoreService;

    /**缴费首页
     *
     * @Author Reich
     * @Date: 2018/4/24 14:07
     */
    @GetMapping
    public String home(Model model,@RequestParam(name = "p", required = false, defaultValue = "1") Integer pageNo ,
                       @RequestParam(required = false, defaultValue = "未支付") String state){

        Map<String, Object> queryParam = new HashMap<>();
        queryParam.put("state", state);

        PageInfo<TicketOutRecord> pageInfo = ticketService.findAllTicketOutAndPage(pageNo,queryParam);
        model.addAttribute("pageInfo", pageInfo);
        return "/finance/ticket/home";
    }

    /**缴费
     *
     * @Author Reich
     * @Date: 2018/4/24 14:08
     */
    @GetMapping("/{id:\\d+}/pay")
    public String payMent(@PathVariable Integer id, Model model){
        TicketOutRecord ticketOutRecord = ticketService.findTicketOutRecordPay(id);
        model.addAttribute("ticketOutRecord", ticketOutRecord);
        return "/finance/ticket/pay";
    }

    /**缴费
     *
     * @Author Reich
     * @Date: 2018/4/24 14:18
     */
    @PostMapping("/{id:\\d+}/pay")
    public String payMent(@PathVariable Integer id, String paymentMethod, Model model){
        ticketService.savePayRecord(id, paymentMethod);
        model.addAttribute("message", "缴费成功");
        return "/finance/ticket/home";
    }

}
