package com.kaishengit.controller;

import com.kaishengit.controller.resoult.ResponseBean;
import com.kaishengit.entity.Account;
import com.kaishengit.service.AccountService;
import com.kaishengit.utiil.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
public class AccountController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public ResponseBean login(@RequestBody Account account){

        try {
            Account dbAccount = accountService.login(account.getUserName(), account.getPassword());
            String token = jwtUtil.createToken(dbAccount.getId(), dbAccount.getPassword());
            return ResponseBean.success(token);
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseBean.error(e.getMessage());
        }

    }

}
