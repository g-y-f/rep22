package com.gyf.ssm.service;

import com.gyf.ssm.Permission;
import com.gyf.ssm.Role;

import java.util.List;

public interface IRoleDaoService {
    //查询所有角色
public List<Role> findAll();
//保存角色
    void save(Role role);
//根据roleid查询role
    Role findById(String roleId);
//根据roleid查询可以添加给角色的权限
    List<Permission> findOtherPermissions(String roleId);
//给角色添加权限
    void addPermissionToRole(String roleId, String[] permissionIds);
}
