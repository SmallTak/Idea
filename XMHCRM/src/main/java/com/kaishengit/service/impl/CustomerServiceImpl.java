package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Customer;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductType;
import com.kaishengit.mapper.CustomerMapper;
import com.kaishengit.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    private Logger logger = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Autowired
    private CustomerMapper productMapper;

    /**
     * @param id
     * @Author 周云飞
     * @MethodDescription 根据id查找商品
     * @Date: 2018/4/10 12:42
     */
    @Override
    public Customer findById(Integer id) {
        return productMapper.findById(id);
    }


    /**@Author 周云飞
     * 保存商品
     * @param  * @param null
     * @Date: 2018/4/10 19:40
     */
    @Override
    public void saveCustomer(Customer customer) {
        customer.setCreateTime(new Timestamp(System.currentTimeMillis()));
        productMapper.saveCustomer(customer);
        logger.info("保存商品 {}",customer);
    }

    /**
     * @param pageNo
     * @Author 周云飞
     * 分页
     * @Date: 2018/4/10 19:51
     */
    @Override
    public PageInfo<Product> findAllPage(Integer pageNo) {
        return null;
    }


    /**
     * @Author 周云飞
     * 查找所有商品的类型
     * @Date: 2018/4/10 22:29
     */
    @Override
    public List<ProductType> findAllProductType() {
        return null;
    }

    /**
     * @Author 周云飞
     * 查找所有商品的类型
     * @Date: 2018/4/10 22:29
     */


    /**
     * @param id
     * @Author 周云飞
     * 根据id删除商品
     * @Date: 2018/4/10 23:02
     */
    @Override
    public void delProduct(Integer id) {

        Customer customer = productMapper.findById(id);
        if (customer != null){
            productMapper.delProduct(id);
            logger.info("删除商品 {}",customer);
        }
    }

    /**
     * @Author 周云飞
     * 修改商品信息
     * @Date: 2018/4/10 23:24
     */
    @Override
    public void updateProduct(Customer customer) {
        customer.setUpdateTime(new Timestamp(System.currentTimeMillis()));
        productMapper.updateProduct(customer);
        logger.info("修改商品{}",customer);
    }

    /**
     * @param pageNo
     * @param
     * @Author 周云飞
     * 搜索商品分页
     * @Date: 2018/4/11 15:13
     */
    @Override
    public PageInfo<Product> findAllPageAndQueryParam(Integer pageNo, Map<String,Object> queryParamMap) {

        PageHelper.startPage(pageNo,8);
        List<Product> productList = productMapper.findAllPageAndQueryParam(queryParamMap);
        return new PageInfo<>(productList);
    }




}
