package com.itheima.ssm.controller;

import com.gyf.ssm.service.ISysLogService;
import com.gyf.ssm.sysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/sysLog")
public class SysLogController {
    @Autowired
    private ISysLogService sysLogService;
    @RequestMapping("/findAll.do")
    public ModelAndView fingAll(){
          List<sysLog> sysLogs=sysLogService.findAll();
        ModelAndView mv = new ModelAndView();
        mv.addObject("sysLogs",sysLogs);
        mv.setViewName("syslog-list");
        return mv;
    }
}
