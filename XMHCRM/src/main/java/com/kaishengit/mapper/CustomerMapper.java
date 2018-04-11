package com.kaishengit.mapper;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Customer;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductType;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {


    Customer findById(Integer id);

    void saveCustomer(Customer customer);

    List<Product> findAllPage();

    List<Product> findAllWithPage();

    void delProduct(Integer id);

    void updateProduct(Customer customer);

    List<Product> findAllPageAndQueryParam();
}
