package com.kaishengit.mapper;

import com.kaishengit.entity.Product;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ProductMapper {

    Product findById(Integer id);
    List<Product> findByLike(@Param("productName") String productName);
    void insert(Product product);

}
