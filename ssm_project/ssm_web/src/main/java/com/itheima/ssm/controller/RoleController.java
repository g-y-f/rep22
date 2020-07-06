package com.itheima.ssm.controller;

import com.gyf.ssm.Permission;
import com.gyf.ssm.Role;
import com.gyf.ssm.UserInfo;
import com.gyf.ssm.dao.IRoleDao;
import com.gyf.ssm.dao.IUserDao;
import com.gyf.ssm.service.IRoleDaoService;
import com.gyf.ssm.service.IUserService;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private IRoleDaoService roleDaoService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll(){
        ModelAndView mv = new ModelAndView();
        List<Role> roles=roleDaoService.findAll();
        mv.addObject("roleList",roles);
        mv.setViewName("role-list");
     return mv;

    }
    @RequestMapping("/save.do")
    public String save(Role role){
        roleDaoService.save(role);
        return "redirect:findAll.do";
    }
    //根据角色id查询角色以及给角色赋予权限
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id" ,required = true) String roleId){
 //根据roleId查询出角色
        Role role=roleDaoService.findById(roleId);
        //根据roleId查询出可以赋予的权限
        List<Permission> permissions=roleDaoService.findOtherPermissions(roleId);
        ModelAndView mv = new ModelAndView();
        mv.setViewName("role-permission-add");
        mv.addObject("permissionList",permissions );
        mv.addObject("role",role);
        return mv;
    }
    //给角色添加权限
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId") String roleId,@RequestParam(name = "ids") String[] permissionIds){
        roleDaoService.addPermissionToRole(roleId,permissionIds);
        return "redirect:findAll.do";

    }
}
