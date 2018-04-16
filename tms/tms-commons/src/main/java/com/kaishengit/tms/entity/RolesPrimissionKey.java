package com.kaishengit.tms.entity;

import java.io.Serializable;

/**
 * roles_primission
 * @author 
 */
public class RolesPrimissionKey implements Serializable {
    private Integer rolesId;

    private Integer permissionId;

    private static final long serialVersionUID = 1L;

    public Integer getRolesId() {
        return rolesId;
    }

    public void setRolesId(Integer rolesId) {
        this.rolesId = rolesId;
    }

    public Integer getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(Integer permissionId) {
        this.permissionId = permissionId;
    }
}