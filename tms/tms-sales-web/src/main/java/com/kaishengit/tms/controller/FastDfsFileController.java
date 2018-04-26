package com.kaishengit.tms.controller;


import com.kaishengit.tms.fileStore.FastDfsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.OutputStream;

@Controller
@RequestMapping("/file")
public class FastDfsFileController {

    @Autowired
    private FastDfsUtil fastDfsUtil;

    public void downLoadFile(String fileId, HttpServletResponse response) throws IOException{

        byte[] bytes = fastDfsUtil.downloadFile(fileId);
        if (bytes != null){
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(bytes);
            outputStream.flush();
            outputStream.close();
        }

    }

}
