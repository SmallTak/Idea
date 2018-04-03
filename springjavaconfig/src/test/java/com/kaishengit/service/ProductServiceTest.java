package com.kaishengit.service;

import com.kaishengit.baseTestCase;
import com.kaishengit.entity.Product;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

public class ProductServiceTest extends baseTestCase {

    @Autowired
    ProductService productService;

    @Test
    public void test() throws Exception {
        List<Product> productList = Arrays.asList(
                new Product("You",22),
                new Product("Me",22)
        );
        productService.insert(productList);
    }


}
