package com.gyf.ssm.dao;

import com.gyf.ssm.Member;
import com.gyf.ssm.UserInfo;
import org.apache.ibatis.annotations.Select;

public interface IMemberDao {
    @Select("select *from member where id=#{id}")
    public Member findById(String id) throws Exception;
}
