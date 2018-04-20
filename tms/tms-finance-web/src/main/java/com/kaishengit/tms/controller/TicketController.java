package com.kaishengit.tms.controller;

import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.TicketInRecord;
import com.kaishengit.tms.mapper.TicketInRecordMapper;
import com.kaishengit.tms.service.TicketService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**年票入库
 *
 * @Author Reich
 * @Date: 2018/4/20 16:52
 */
@Controller
@RequestMapping("/ticket/storage")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @GetMapping
     public String home(Model model){
        List<TicketInRecord> ticketInRecordList = ticketService.findTicketAndTicketInRecord();
        model.addAttribute("ticketInRecordList",ticketInRecordList);

        return "/ticket/storage/home";
     }

     /**新增年票入库
      *
      * @Author Reich
      * @Date: 2018/4/20 23:09
      */
     @GetMapping("/new")
     public String newTicket(Model model){

        String todayTime = DateTime.now().toString("YYYY-MM-dd");
        model.addAttribute("todayTime", todayTime);
        return "/ticket/storage/new";
     }

    /**新增年票入库
     *
     * @Author Reich
     * @Date: 2018/4/20 23:09
     */
     @PostMapping("/new")
     public String newTicket(TicketInRecord ticketInRecord, RedirectAttributes redirectAttributes){

        Subject subject = SecurityUtils.getSubject();
        Account account = (Account) subject.getPrincipal();
        ticketService.saveTicketInWarehouse(ticketInRecord, account);
         redirectAttributes.addFlashAttribute("message","新增成功");
        return "redirect:/ticket/storage";
     }

     /**删除年票入库记录
      *
      * @Author Reich
      * @Date: 2018/4/20 23:12
      */
     @GetMapping("/{id:\\d+}/del")
     @ResponseBody
     public String delTicket(@PathVariable Integer id){

         ticketService.delTicketInRecordById(id);
            return "";
     }

}
