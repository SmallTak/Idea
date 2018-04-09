package com.kaishengit.controller;


import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

@Controller
public class FileUploadController {

    @GetMapping("/upload")
    public String upload(@RequestHeader(name = "User-Agent") String userAgent, HttpServletRequest req, HttpServletResponse resp){
        //通过注解@RequestHeader来获得响应头User-Agent的内容
        System.out.println(userAgent);

        Cookie cookie = new Cookie("user", "Vip");
        //只能通过后端获得cookie
        cookie.setHttpOnly(true);
        cookie.setDomain("60 * 60 * 24");
        cookie.setDomain("localhost");

        resp.addCookie(cookie);

        return "/upload";
    }

    @PostMapping("/upload")
    public String upload(@CookieValue  String user, @RequestParam(name="file") MultipartFile photo, RedirectAttributes redirectAttributes) throws IOException {
        System.out.println(user);
        //表单的元素名
        System.out.println("原始文件名" + photo.getName());
        //原始文件名称
        System.out.println(photo.getOriginalFilename());
        //把文件大小转换成可阅读大小
        System.out.println(FileUtils.byteCountToDisplaySize(photo.getSize()));

        if (!photo.isEmpty()){

            InputStream inputStream = photo.getInputStream();
            OutputStream outputStream = new FileOutputStream(new File("a:/temp/" + photo.getOriginalFilename()));
            IOUtils.copy(inputStream,outputStream);

            outputStream.flush();
            outputStream.close();
            inputStream.close();

            //简单粗暴的文件上传
            //photo.transferTo(new File("d:/temp/" +photo.getOriginalFilename()));

        }else{
            System.out.println("请选择需上传的文件");
            //在参数中添加RedirectAttributes对象调用addFlashAttribute方法即可向视图页面发送message
            redirectAttributes.addFlashAttribute("message","请选择需上传的文件");
        }
         return "redirect:/upload";
    }

    @ExceptionHandler(IOException.class)
    public String ioException(){
        return "error/500";
    }

}
