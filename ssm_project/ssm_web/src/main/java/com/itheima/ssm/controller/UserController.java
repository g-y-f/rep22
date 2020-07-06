package com.itheima.ssm.controller;

import com.gyf.ssm.Role;
import com.gyf.ssm.UserInfo;
import com.gyf.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;
    //给用户添加角色
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) String userId,@RequestParam(name = "ids", required = true) String[] roleIds){
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    //根据userid查询用户以及用户可以添加的角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true) String userId  ){
        //根据用户的id查询用户
        UserInfo user = userService.findById(userId);
        //根据用户的id查询可以添加的角色
        List<Role> otherRoles=userService.findOtherRoles(userId);
        ModelAndView mv = new ModelAndView();
        mv.addObject("user",user);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;

    }

    //查询所有用户
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userlist = userService.findAll();
        mv.setViewName("user-list");
        mv.addObject("userList", userlist);
        return mv;
    }

//保存用户
    @RequestMapping("/save.do")
    public String save(UserInfo user){
        userService.save(user);
        return "redirect:findAll.do";
    }
    //根据id查询用户的详细信息
    @RequestMapping("/findById.do")
    public ModelAndView findById(String id){
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo=userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;

    }
}