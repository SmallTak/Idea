package com.kaishengit.mapper;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductType;

import java.util.List;
import java.util.Map;

public interface ProductMapper {


    Product findById(Integer id);

    void saveProduct(Product product);

    List<Product> findAllPage();

    List<Product> findAllWithPage();

    void delProduct(Integer id);

    void updateProduct(Product product);

    List<Product> findAllPageAndQueryParam(Map<String, Object> queryParamMap);
}
