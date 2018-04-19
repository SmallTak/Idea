package com.kaishengit.tms.controller;

import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.RolesPermissionService;
import com.kaishengit.tms.shiro.CustomerFilterChainDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.nio.file.Path;
import java.util.List;

@Controller
@RequestMapping("/manage/permission")
public class PermissionController {

    @Autowired
    private RolesPermissionService rolesPermissionService;

    @Autowired
    private CustomerFilterChainDefinition customerFilterChainDefinition;

    /**
     * 请求转发到权限管理首页
     * @Author Reich
     * @Date: 2018/4/13 14:02
     */
    @GetMapping
    public String home(Model model){

        List<Permission> permissionList = rolesPermissionService.findAllPermission();
        model.addAttribute("permissionList", permissionList);
        return "manage/permission/home";
    }
    /**
     * 新增权限页面
     * @Author Reich
     * @Date: 2018/4/13 14:02
     */
    @GetMapping("/new")
    public String newPermission(Model model){
        //查询菜单类型的权限列表
        List<Permission> permissionList =  rolesPermissionService.findPermissionByPermissionType(Permission.MENU_TYPE);
        model.addAttribute("permissionList", permissionList);
        return "manage/permission/new";
    }

    /**
     * 新增权限
     * @Author Reich
     * @Date: 2018/4/13 14:10
     */
    @PostMapping("/new")
    public String newPermission(Permission permission, RedirectAttributes redirectAttributes){

        rolesPermissionService.savePermission(permission);
        //刷新shiro的权限
        customerFilterChainDefinition.updateUrlPermission();
        redirectAttributes.addFlashAttribute("message","添加权限成功");
        return "redirect:/manage/permission";
    }

    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delPermission(@PathVariable Integer id){
        try {
            rolesPermissionService.delPermissionById(id);
            return ResponseBean.success();
        }catch (ServiceException e){
            return ResponseBean.error(e.getMessage());
        }

    }

    @GetMapping("/{id:\\d+}/edit")
    public String editPermission(@PathVariable Integer id, Model model){
        //查询菜单类型权限列表
        List<Permission> permissionList =  rolesPermissionService.findPermissionByPermissionType(Permission.MENU_TYPE);
        Permission permission = rolesPermissionService.findAllPermissionById(id);

        model.addAttribute("permission",permission);
        model.addAttribute("permissionList", permissionList);
        return "manage/permission/edit";
    }
    ///{id:\d+}
    @PostMapping("/edit")
    public String editPermission(Integer permissionID, Permission permission,RedirectAttributes redirectAttributes, Model model , Integer[] permissionIds){

        try {
            rolesPermissionService.updatePermission(permission, permissionID);
            //刷新shiro的权限
            customerFilterChainDefinition.updateUrlPermission();
            model.addAttribute("message","修改权限成功");
            return "redirect:/manage/permission";
        }catch (ServiceException e){
            model.addAttribute("message", e.getMessage());
            System.out.println(e.getMessage());
            return "/manage/permission/edit";
        }
    }


}
