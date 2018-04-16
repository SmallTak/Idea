package com.kaishengit.tms.controller;

import com.google.common.collect.Maps;
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolesPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.management.relation.Role;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 账号管理控制器
 * @author fankay
 */
@Controller
@RequestMapping("/manage/account")
public class AccountController {

    @Autowired
    private RolesPermissionService rolesPermissionService;
    @Autowired
    private AccountService accountService;

    @GetMapping
    public String home(Model model,
                       @RequestParam(required = false) String mobile,
                       @RequestParam(required = false) Integer rolesId
                       ) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("mobile",mobile);

        List<Account> accountList = accountService.findAllAccountWithRolesByQueryParam(objectMap);

        model.addAttribute("accountList", accountList);
        model.addAttribute("rolesList",rolesPermissionService.findAllRoles());
        return "manage/account/home";
    }

    /**
     * 新增角色
     * @param model
     * @return
     */
    @GetMapping("/new")
    public String newAccount(Model model) {
        //角色列表
        List<Roles> roleList = rolesPermissionService.findAllRoles();
        model.addAttribute("roleList",roleList);
        return "manage/account/new";
    }

    /**
     * 新增角色
     * @param
     * @return
     */
    @PostMapping("/new")
    public String newAccount(Account account, Integer[] rolesIds) {
        accountService.saveAccount(account,rolesIds);
        return "redirect:/manage/account";
    }
}