package com.kaishengit.service.impl;

import com.kaishengit.entity.Product;
import com.kaishengit.mapper.ProductMapper;
import com.kaishengit.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductMapper productMapper;

    /**
     * @param id
     * @Author 周云飞
     * @MethodDescription 根据id查找商品
     * @Date: 2018/4/10 12:42
     */
    @Override
    public Product findById(Integer id) {
        return productMapper.findById(id);
    }
}
