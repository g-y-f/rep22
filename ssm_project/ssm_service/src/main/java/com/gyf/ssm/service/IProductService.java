package com.gyf.ssm.service;

import com.gyf.ssm.Product;

import java.util.List;

public interface IProductService {
    public List<Product> findAll()throws Exception;

    public void save(Product product);
}
