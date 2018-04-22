package com.kaishengit.tms.controller;

import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.TicketInRecord;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.TicketService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;
import org.joda.time.DateTime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;


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

     /**修改年票入库信息
      *
      * @Author Reich
      * @Date: 2018/4/21 10:27
      */
     @GetMapping("/{id:\\d+}/edit")
     public String editTicket(@PathVariable Integer id, Model model){
         //入库时间
         String dayTime = DateTime.now().toString("YYYY-MM-dd");
         //回显年票入库信息
         TicketInRecord ticketInRecord = ticketService.findTicketInRecord(id);
         model.addAttribute("dayTime",dayTime);
         model.addAttribute("ticketInRecord",ticketInRecord);
         return "/ticket/storage/edit";
     }

    /**修改年票入库信息
     *
     * @Author Reich
     * @Date: 2018/4/21 10:27
     */
     @PostMapping("/{id:\\d+}/edit")
     public String editTicketInRecord(@PathVariable Integer id, TicketInRecord ticketInRecord, RedirectAttributes redirectAttributes){
         ticketService.updateTicketInRecord(id,ticketInRecord);
         return "";
     }


     /**删除年票入库记录
      *
      * @Author Reich
      * @Date: 2018/4/20 23:12
      */
     @GetMapping("/{id:\\d+}/del")
     @ResponseBody
     public ResponseBean delTicket(@PathVariable Integer id){
        try {
            ticketService.delTicketInRecordById(id);
            return ResponseBean.success();
        }catch (ServiceException e){
            return ResponseBean.error(e.getMessage());
        }
     }

}
