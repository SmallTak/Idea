package com.kaishengit.mapper;

import com.kaishengit.entity.Customer;
import com.kaishengit.entity.Product;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {


    Customer findById(Integer id);

    void saveCustomer(Customer customer);

    void delProduct(Integer id);

    void updateProduct(Customer customer);

    List<Product> findAllPageAndQueryParam(Map<String,Object> queryParamMap);


}
