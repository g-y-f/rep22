package com.gyf.ssm.service;

import com.gyf.ssm.sysLog;

import java.util.List;

public interface ISysLogService {

     void save(sysLog sysLog1);

    List<sysLog> findAll();
}
