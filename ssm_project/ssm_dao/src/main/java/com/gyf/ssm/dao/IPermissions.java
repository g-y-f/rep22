package com.gyf.ssm.dao;

import com.gyf.ssm.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IPermissions {
@Select("select *from permission where id in(select permissionId from role_permission where roleId=#{id} )")
    public List<Permission> findByRoleId(String id);
@Select("select *from permission")
    List<Permission> findAll();
@Insert("insert into permission (permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission);
}
