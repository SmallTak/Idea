package com.kaishengit.service;

import com.kaishengit.entity.Product;


public interface ProductService {
    /**@Author 周云飞
     * @MethodDescription 根据id查找商品
     * @param id
     * @Date: 2018/4/10 12:42
     */
    Product findById(Integer id);

}
