package com.kaishengit.service;

import com.kaishengit.dao.ProductDao;

import com.kaishengit.entity.Product;
import org.hamcrest.core.Is;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductDao productDao;

    //在该事务中发生runtimeException及其子类异常事务都会回滚,      设置回滚方式为只要出现异常事务就要回滚
    @Transactional(rollbackFor = Exception.class,isolation = Isolation.SERIALIZABLE,propagation = Propagation.REQUIRED)//设置事务隔离级别和事务的传播性
    public void insert(List<Product> productList) throws Exception {
        for(Product product : productList){
            productDao.insert(product);
            throw new Exception("");
        }
    }


}
