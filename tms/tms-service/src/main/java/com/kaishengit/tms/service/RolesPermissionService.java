package com.kaishengit.tms.service;


import com.kaishengit.tms.entity.Permission;
import com.kaishengit.tms.entity.Roles;
import com.kaishengit.tms.entity.RolesPrimissionExample;
import com.kaishengit.tms.entity.RolesPrimissionKey;
import com.kaishengit.tms.exception.ServiceException;

import javax.management.relation.Role;
import java.util.List;

public interface RolesPermissionService {

    /**
     * 保存权限
     * @Author Reich
     * @Date: 2018/4/13 14:09
     */
    void savePermission(Permission permission);
    /**
     * 查询菜单类型的权限列表
     * @Author Reich
     * @Date: 2018/4/13 14:21
     */
    List<Permission> findPermissionByPermissionType(String menuType);

    /**
     * 查找所有权限
     * @Author Reich
     * @Date: 2018/4/13 14:33
     */
    List<Permission> findAllPermission();

    /**
     * 新增角色
     * @Author Reich
     * @Date: 2018/4/15 10:08
     */
    void saveRoles(Roles roles, Integer[] permissionId);

    /**
     * 根据id删除权限
     * @throws ServiceException 删除失败则抛出异常，例如权限已被占用时
     * @Author Reich
     * @Date: 2018/4/15 14:37
     */
    void delPermissionById(Integer id) throws ServiceException;

    /**
     * 根据id查找权限
     * @Author Reich
     * @Date: 2018/4/15 16:10
     */
    Permission findAllPermissionById(Integer id);

    /**
     * 修改权限
     * @throws ServiceException 若该权限已被角色使用则抛出异常
     * @Author Reich
     * @Date: 2018/4/15 16:42
     */
    void updatePermission(Permission permission, Integer permissionID) throws ServiceException;

    /**
     * 查找所有的角色
     * @Author Reich
     * @Date: 2018/4/15 19:19
     */
    List<Roles> findAllRoles();

    /**
     * 查找角色并加载对应的权限列表
     * @Author Reich
     * @Date: 2018/4/16 10:05
     */
    List<Roles> findRolesAndPermission();

    /**
     * 根据id查找该角色
     * @Author Reich
     * @Date: 2018/4/16 10:54
     */
    Roles findByIdRolesAndPermission(Integer id);

    /**
     * 根据id删除角色
     * @Author Reich
     * @Date: 2018/4/16 17:08
     */
    void delRoles(Integer id);

    /**
     * 更新角色
     * @Author Reich
     * @Date: 2018/4/16 18:35
     */
    void updateRolesAndPermission(Roles roles, Integer[] permissionId);

    /**
     * 根据账户id查找当前账户拥有的角色
     * @Author Reich
     * @Date: 2018/4/16 22:27
     */
    List<Roles> findRolesByAccountId(Integer id);
}
