package com.gyf.ssm.dao;

import com.gyf.ssm.Permission;
import com.gyf.ssm.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IRoleDao {
    @Select("select *from role where id in(select roleId from users_role where userId=#{id})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class ,many = @Many(select = "com.gyf.ssm.dao.IPermissions.findByRoleId")),

    })
    public List<Role> findById(String id);
@Select("select *from role")
    List<Role> findAll();
@Insert("insert into role(roleName,roleDesc)values (#{roleName},#{roleDesc})")
    void save(Role role);
@Select("select *from role where id=#{roleId}")
    Role findByIds(String roleId);
@Select("select* from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);
@Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionToRole(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
