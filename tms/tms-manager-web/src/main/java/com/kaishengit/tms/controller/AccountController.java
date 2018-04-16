package com.kaishengit.tms.controller;

import com.google.common.collect.Maps;
import com.kaishengit.tms.controller.Exception.NotFoundException;
import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.service.AccountService;
import com.kaishengit.tms.service.RolesPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
                       @RequestParam(required = false) String nameMobile,
                       @RequestParam(required = false) Integer rolesId
                       ) {
        Map<String, Object> objectMap = new HashMap<>();
        objectMap.put("nameMobile",nameMobile);
        objectMap.put("rolesId",rolesId);
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

    /**
     * 修改账户信息及账户角色
     * @Author Reich
     * @Date: 2018/4/16 22:20
     */
    @GetMapping("/{id:\\d+}/edit")
    public String updateAccount(@PathVariable Integer id, Model model){

        Account account = accountService.findByAccountId(id);
        if(account == null){
            throw new NotFoundException();
        }
        //查询所有的角色
        List<Roles> rolesList = rolesPermissionService.findAllRoles();
        //查找当前账户拥有的角色
        List<Roles> accountRolesList = rolesPermissionService.findRolesByAccountId(id);
        model.addAttribute("accountRolesList",accountRolesList);
        model.addAttribute("rolesList",rolesList);
        model.addAttribute("account",account);
        return "manage/account/edit";

    }
    /**
     * 更新账户
     * @Author Reich
     * @Date: 2018/4/16 22:53
     */
    @PostMapping("/{id:\\d+}/edit")
    public String updateAccount(Account account, Integer[] rolesIds, RedirectAttributes redirectAttributes){
        accountService.updateAccount(account,rolesIds);
        redirectAttributes.addFlashAttribute("message","修改账号成功");
        return "redirect:/manage/account";
    }


}