package com.gyf.ssm.dao;

import com.gyf.ssm.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ITraveller {
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(String ordersId) throws Exception;
}
