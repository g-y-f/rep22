package com.gyf.ssm.service.impl;

import com.gyf.ssm.dao.ISyslogDao;
import com.gyf.ssm.service.ISysLogService;
import com.gyf.ssm.sysLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {
    @Autowired
    private ISyslogDao syslogDao;
    @Override
    public void save(sysLog sysLog1) {
         syslogDao.save(sysLog1);
    }

    @Override
    public List<sysLog> findAll() {
        return syslogDao.findAll();
    }
}
