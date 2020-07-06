package com.gyf.ssm.service;

import com.gyf.ssm.Orders;

import java.util.List;

public interface IOrdersService {
    Orders findById(String orderId) throws Exception;
    List<Orders> findAll() throws Exception;
}
