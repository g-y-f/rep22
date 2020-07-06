package com.gyf.ssm.dao;

import com.gyf.ssm.sysLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ISyslogDao {

    @Insert("insert into sysLog(visitTime,username,ip,url,executionTime,method) values(#{visitTime},#{username},#{ip},#{url},#{executionTime},#{method})")
    void save(sysLog sysLog);
@Select("select *from sysLog")
    List<sysLog> findAll();
}
