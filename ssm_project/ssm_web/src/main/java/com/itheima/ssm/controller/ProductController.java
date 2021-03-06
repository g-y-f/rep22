package com.itheima.ssm.controller;

import com.gyf.ssm.Product;
import com.gyf.ssm.service.IProductService;
import com.gyf.ssm.Product;
import com.gyf.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;


    //查询全部产品
    @RolesAllowed("ADMIN")
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        mv.addObject("productList", ps);
        mv.setViewName("product-list1");
        return mv;

    }
    //保存产品
    @RequestMapping("/save.do")
    public String saveAll(Product product){
     productService.save(product);
     return "redirect:findAll.do";
    }
}
