package com.itheima.ssm.controller;


import com.github.pagehelper.PageInfo;
import com.gyf.ssm.Orders;
import com.gyf.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private IOrdersService ordersService;
@RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true) String orderId) throws Exception {
    ModelAndView mv = new ModelAndView();
    Orders orders=ordersService.findById(orderId);
    mv.addObject("orders",orders);
    mv.setViewName("orders-show");
    return mv;
}
//    @RequestMapping("/findAll.do")
//    public ModelAndView findAll() throws Exception {
//        ModelAndView mv = new ModelAndView();
//        List<Orders> ps = ordersService.findAll();
//        mv.addObject("pageInfo", ps);
//        mv.setViewName("orders-page-list");
//        return mv;
//    }
@RequestMapping("/findAll.do")
public ModelAndView findAll() throws Exception {
    ModelAndView mv = new ModelAndView();
    List<Orders> ordersList = ordersService.findAll();
    mv.addObject("pageInfo", ordersList);
    mv.setViewName("orders-page-list");
    return mv;
}
}
