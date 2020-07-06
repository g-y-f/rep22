package com.gyf.ssm.service.impl;

import com.gyf.ssm.Product;
import com.gyf.ssm.dao.IProductaDao;
import com.gyf.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
@Service
@Transactional
public class ProductServiceImpl implements IProductService {
    @Autowired
    private IProductaDao iProductDao;
    @Override
    public List<Product> findAll() throws Exception {

        return iProductDao.findAll();
    }

    @Override
    public void save(Product product) {
        iProductDao.save(product);
    }
}
