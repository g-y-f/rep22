package com.gyf.ssm.service;

import com.gyf.ssm.Role;
import com.gyf.ssm.UserInfo;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

public interface IUserService extends UserDetailsService{
    //查询用户
    List<UserInfo> findAll();
//保存用户
    void save(UserInfo user);
//根据用户id查询用户
    UserInfo findById(String id);
//根据用户id查询可以添加的角色
    List<Role> findOtherRoles(String userId);
//给用户添加角色
    void addRoleToUser(String userId, String[] roleIds);
}
