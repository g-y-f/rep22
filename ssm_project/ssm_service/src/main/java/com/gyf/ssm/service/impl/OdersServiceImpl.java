package com.gyf.ssm.service.impl;

import com.gyf.ssm.Orders;
import com.gyf.ssm.dao.IOdersDao;
import com.gyf.ssm.service.IOrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OdersServiceImpl implements IOrdersService {
    @Autowired
    private IOdersDao ordersDao;
    @Override
    public Orders findById(String orderId) throws Exception {
        return ordersDao.findById(orderId);
    }

    @Override
    public List<Orders> findAll() throws Exception {
        return ordersDao.findAll();
    }
}
