package com.gyf.ssm.dao;

import com.gyf.ssm.Role;
import com.gyf.ssm.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;


public interface IUserDao {
    //查询所有用户
   @Select("select *from users")
   List<UserInfo> findAll();


    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType =java.util.List.class,many = @Many(select = "com.gyf.ssm.dao.IRoleDao.findById"))
    })
    public UserInfo findByUsername(String username) throws Exception;
    //保存用户
@Insert("insert into users (email,username,password,phoneNum,status) values (#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo user);
//根据id查询用户详情
    @Select("select *from users where id=#{id}")
    @Results({
            @Result(id=true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType =java.util.List.class,many = @Many(select = "com.gyf.ssm.dao.IRoleDao.findById"))
    })
    UserInfo findById(String id);
//根据用户ID查询可以添加的角色
    @Select("select *from role where id not in (select roleId from users_role where userId=#{userId} )")
    List<Role> findOtherRoles(String userId);
//给用户添加角色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleToUser(@Param("userId") String userId, @Param("roleId") String roleId);
}

