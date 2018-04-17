package com.kaishengit.tms.controller;

import com.google.common.collect.Maps;
import com.kaishengit.tms.Exception.NotFoundException;
import com.kaishengit.tms.dto.ResponseBean;
import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.service.RolesPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/manage/roles")
public class RolesController {

    @Autowired
    private RolesPermissionService rolesPermissionService;

    /**
     * 查找所有的角色
     * @Author Reich
     * @Date: 2018/4/15 19:22
     */
    @GetMapping
    public String home(Model model){
        List<Roles> rolesList = rolesPermissionService.findRolesAndPermission();
        model.addAttribute("rolesList",rolesList);
        return "manage/roles/home";
    }

    /**
     * 新增角色
     * @Author Reich
     * @Date: 2018/4/16 10:40
     */
    @GetMapping("/new")
    public String add(Model model){
        model.addAttribute("permissionList", rolesPermissionService.findAllPermission());
        return "manage/roles/new";
    }

    /**
     * 新增角色
     * @Author Reich
     * @Date: 2018/4/16 10:40
     */
    @PostMapping("/new")
    public String add(Roles roles, Integer[] permissionId, RedirectAttributes redirectAttributes){

        rolesPermissionService.saveRoles(roles, permissionId);
        redirectAttributes.addFlashAttribute("message", "新增角色成功");

        return "redirect:/manage/roles";
    }

    /**
     * 修改角色及其权限
     * @Author Reich
     * @Date: 2018/4/16 10:41
     */
    @GetMapping("/{id:\\d+}/edit")
    public String edit(@PathVariable Integer id, Model model){
        //查找该角色受否存在以及角色权限
        Roles roles = rolesPermissionService.findByIdRolesAndPermission(id);
        if (roles == null){
            throw new NotFoundException();
        }

        //查找该角色拥有的权限列表
        List<Permission> permissionList = rolesPermissionService.findAllPermission();

        //调用checkenPermissionList把当前角色拥有的权限设置为true
        Map<Permission, Boolean> permissionMap = checkenPermissionList(roles.getPermissionList(), permissionList);


        model.addAttribute("roles", roles);
        model.addAttribute("permissionMap",permissionMap);
        return "manage/roles/edit";
    }

    /**
     * @param nowPermissionList 该角色当前拥有的权限
     * @param allPermissionList 所有的权限列表
     * @return 有序的map集合，若当前员工有该权限则被选中(true)
     * @Author Reich
     * @Date: 2018/4/16 10:59
     */
    private Map<Permission, Boolean> checkenPermissionList(List<Permission> nowPermissionList, List<Permission> allPermissionList) {

        Map<Permission,Boolean> resultMap = Maps.newLinkedHashMap();
        //迭代所有权限
        for(Permission permission : allPermissionList) {
            boolean flag = false;
            //迭代当前角色拥有的权限
            for(Permission rolesPermission : nowPermissionList) {
                if(permission.getId().equals(rolesPermission.getId())) {
                    flag = true;
                    break;
                }
            }
            resultMap.put(permission,flag);
        }
        return resultMap;
    }

    /**
     * 修改角色及其权限
     * @Author Reich
     * @Date: 2018/4/16 10:41
     */
    @PostMapping("/{id:\\d+}/edit")
    public String edit(Roles roles, Integer[] permissionId,RedirectAttributes redirectAttributes){

        rolesPermissionService.updateRolesAndPermission(roles,permissionId);
        redirectAttributes.addFlashAttribute("message","修改角色成功");
        return "redirect:/manage/roles";
    }

    /**
     * 删除角色
     * @Author Reich
     * @Date: 2018/4/16 17:07
     */
    @GetMapping("/{id:\\d+}/del")
    @ResponseBody
    public ResponseBean delRoles(@PathVariable Integer id){
        try {
            rolesPermissionService.delRoles(id);
            return ResponseBean.success();
        }catch (ServiceException e){
            return ResponseBean.error(e.getMessage());
        }
    }

}
