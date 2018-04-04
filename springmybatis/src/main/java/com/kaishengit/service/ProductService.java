package com.kaishengit.service;

import com.kaishengit.entity.Product;
import com.kaishengit.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductMapper productMapper;

    public Product findById(Integer id){
        return productMapper.findById(id);
    }

    public List<Product> findByLike(String productName){
        return productMapper.findByLike(productName);
    }

    public void insertTest(Product product){
        productMapper.insert(product);
    }

}
