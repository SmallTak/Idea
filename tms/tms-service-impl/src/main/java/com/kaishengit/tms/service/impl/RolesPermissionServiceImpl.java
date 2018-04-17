package com.kaishengit.tms.service.impl;

import com.google.common.base.Predicate;
import com.google.common.collect.Collections2;
import com.google.common.collect.Lists;
import com.kaishengit.tms.entity.*;
import com.kaishengit.tms.exception.ServiceException;
import com.kaishengit.tms.mapper.AccountRolesMapper;
import com.kaishengit.tms.mapper.PermissionMapper;
import com.kaishengit.tms.mapper.RolesMapper;
import com.kaishengit.tms.mapper.RolesPrimissionMapper;
import com.kaishengit.tms.service.RolesPermissionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Nullable;
import javax.management.relation.Role;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class RolesPermissionServiceImpl implements RolesPermissionService{

    public static final Logger logger = LoggerFactory.getLogger(RolesPermissionServiceImpl.class);

   @Autowired
   private PermissionMapper permissionMapper;

   @Autowired
   private RolesMapper rolesMapper;

   @Autowired
   private RolesPrimissionMapper rolesPrimissionMapper;

   @Autowired
   private AccountRolesMapper accountRolesMapper;

    /**
     * 查找所有权限
     *
     * @Author Reich
     * @Date: 2018/4/13 14:33
     */
    @Override
    public List<Permission> findAllPermission() {
        PermissionExample permissionExample = new PermissionExample();
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);

        List<Permission> resList = new ArrayList<>();
        treeList(permissionList, resList, 0);
        return resList;
    }

    /**
     * 新增角色
     *
     * @param roles 角色
     * @param permissionId 角色对应的权限id
     * @Author Reich
     * @Date: 2018/4/15 10:08
     */
    @Override
    @Transactional(rollbackFor =RuntimeException.class)
    public void saveRoles(Roles roles, Integer[] permissionId) {
        //保存角色
        roles.setCreateTime(new Date());
        rolesMapper.insertSelective(roles);

        //建立角色和权限的对应关系
        for (Integer perId : permissionId) {
            RolesPrimissionKey rolesPrimissionKey = new RolesPrimissionKey();
            rolesPrimissionKey.setPermissionId(perId);
            rolesPrimissionKey.setRolesId(roles.getId());

            rolesPrimissionMapper.insert(rolesPrimissionKey);
        }
        logger.info("保存角色 {}",roles);

    }

    /**
     * 根据id删除权限
     *
     * @param id
     * @throws ServiceException 删除失败则抛出异常，例如权限已被占用时
     * @Author Reich
     * @Date: 2018/4/15 14:37
     */
    @Override
    public void delPermissionById(Integer id) throws ServiceException {
        //查询该节点下是否存在子节点
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andParentIdEqualTo(id);
        List<Permission> permissionList = permissionMapper.selectByExample(permissionExample);
        if (permissionList != null && !permissionList.isEmpty()){
            throw new ServiceException("该节点下有子节点，删除失败");
        }

        //查询改权限是否已被使用
        RolesPrimissionExample rolesPrimissionExample = new RolesPrimissionExample();
        rolesPrimissionExample.createCriteria().andPermissionIdEqualTo(id);

        List<RolesPrimissionKey> rolesPrimissionKeys = rolesPrimissionMapper.selectByExample(rolesPrimissionExample);
        if (rolesPrimissionKeys != null && !rolesPrimissionKeys.isEmpty()){
            throw new ServiceException("该权限有角色在使用，删除失败");
        }

        Permission permission = permissionMapper.selectByPrimaryKey(id);
        permissionMapper.deleteByPrimaryKey(id);

        logger.info("删除权限{}",permission);

    }

    /**
     * 根据id查找权限
     *
     * @Author Reich
     * @Date: 2018/4/15 16:10
     */
    @Override
    public Permission findAllPermissionById(Integer id) {
       return permissionMapper.selectByPrimaryKey(id);
    }

    /**
     * 修改权限
     *
     * @param permission
     * @throws ServiceException 若该权限已被角色使用则抛出异常
     * @Author Reich
     * @Date: 2018/4/15 16:42
     */
    @Override
    public void updatePermission(Permission permission, Integer permissionID) throws ServiceException {

        //判断改权限是否被使用
        RolesPrimissionExample rolesPrimissionExample = new RolesPrimissionExample();
        rolesPrimissionExample.createCriteria().andPermissionIdEqualTo(permissionID);

        List<RolesPrimissionKey> primissionKeys = rolesPrimissionMapper.selectByExample(rolesPrimissionExample);

        if (primissionKeys != null && !primissionKeys.isEmpty()){
            throw new ServiceException("该权限正在使用中，无法修改！");
        }

        permission.setId(permissionID);
        permission.setUpdateTime(new Date());
        permissionMapper.updateByPrimaryKeySelective(permission);
        logger.info("{}修改",permission);

    }

    /**
     * 查找所有的角色
     *
     * @Author Reich
     * @Date: 2018/4/15 19:19
     */
    @Override
    public List<Roles> findAllRoles() {

        RolesPrimissionExample rolesPrimissionExample = new RolesPrimissionExample();
        RolesExample rolesExample = new RolesExample();
        return rolesMapper.selectByExample(rolesExample);

    }

    /**
     * 查找角色并加载对应的权限列表
     *
     * @Author Reich
     * @Date: 2018/4/16 10:05
     */
    @Override
    public List<Roles> findRolesAndPermission() {
        return rolesMapper.findRolesAndPermission();
    }

    /**
     * 根据id查找该角色
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/16 10:54
     */
    @Override
    public Roles findByIdRolesAndPermission(Integer id) {
        return rolesMapper.findByIdRolesAndPermission(id);
    }

    /**
     * 根据id删除角色
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/16 17:08
     */
    @Transactional(rollbackFor = RuntimeException.class)
    @Override
    public void delRoles(Integer id) {
        //查询该角色是否被引用 若被引用则不删除
        AccountRolesExample accountRolesExample = new AccountRolesExample();
        accountRolesExample.createCriteria().andAccountIdEqualTo(id);
        List<AccountRolesKey> rolesKeyList = accountRolesMapper.selectByExample(accountRolesExample);
        if (rolesKeyList != null && !rolesKeyList.isEmpty()){
            throw new ServiceException("该角色已被引用，无法删除");
        }

        //删除角色和权限关系
        RolesPrimissionExample rolesPrimissionExample = new RolesPrimissionExample();
        rolesPrimissionExample.createCriteria().andRolesIdEqualTo(id);

        rolesPrimissionMapper.deleteByExample(rolesPrimissionExample);

        //删除角色
        Roles roles = rolesMapper.selectByPrimaryKey(id);
        rolesMapper.deleteByPrimaryKey(id);

        logger.info("删除角色{}", roles);

    }

    /**
     * 更新角色
     *
     * @param roles
     * @param permissionId 权限id数组
     * @Author Reich
     * @Date: 2018/4/16 18:35
     */
    @Override
    @Transactional(rollbackFor = RuntimeException.class)
    public void updateRolesAndPermission(Roles roles, Integer[] permissionId) {
        //删除角色关联的权限
        RolesPrimissionExample rolesPrimissionExample = new RolesPrimissionExample();
        rolesPrimissionExample.createCriteria().andRolesIdEqualTo(roles.getId());

        rolesPrimissionMapper.deleteByExample(rolesPrimissionExample);
        if (permissionId != null){
            for (Integer perId : permissionId){
                //重新建立角色权限对应关系
                RolesPrimissionKey rolesPrimissionKey = new RolesPrimissionKey();
                rolesPrimissionKey.setRolesId(roles.getId());
                rolesPrimissionKey.setPermissionId(perId);
                rolesPrimissionMapper.insertSelective(rolesPrimissionKey);
            }
        }
        //修改角色对象
        rolesMapper.updateByPrimaryKeySelective(roles);
        logger.info("修改对象{}",roles);


    }

    /**
     * 根据账户id查找当前账户拥有的角色
     *
     * @param id
     * @Author Reich
     * @Date: 2018/4/16 22:27
     */
    @Override
    public List<Roles> findRolesByAccountId(Integer id) {
        List<Roles> rolesList = rolesMapper.findRoleByAccountId(id);
        return rolesList;
    }


    private void treeList(List<Permission> permissionList, List<Permission> resList, int i) {
        //Collections2.filter()从一个集合里面筛选出符合条件的元素
        List<Permission> permissions = Lists.newArrayList(Collections2.filter(permissionList, new Predicate<Permission>() {
            @Override
            public boolean apply(@Nullable Permission input) {
                return input.getParentId().equals(i);
            }
        }));

        for (Permission permission : permissions){
            resList.add(permission);
            treeList(permissionList, resList, permission.getId());
        }

    }

    /**
     * 保存权限
     *
     * @param permission
     * @Author Reich
     * @Date: 2018/4/13 14:09
     */
    @Override
    public void savePermission(Permission permission) {

        permission.setCreateTime(new Date());
        permissionMapper.insertSelective(permission);
        logger.info("添加权限{}", permission);

    }

    /**
     * 查询菜单类型的权限列表
     *
     * @param permissionType 权限类型 菜单或者按钮
     * @Author Reich
     * @Date: 2018/4/13 14:21
     */
    @Override
    public List<Permission> findPermissionByPermissionType(String permissionType) {
        PermissionExample permissionExample = new PermissionExample();
        permissionExample.createCriteria().andPermissionTypeEqualTo(permissionType);
        return permissionMapper.selectByExample(permissionExample);
    }


}
