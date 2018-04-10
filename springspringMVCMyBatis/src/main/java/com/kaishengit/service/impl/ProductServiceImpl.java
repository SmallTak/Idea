package com.kaishengit.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductType;
import com.kaishengit.mapper.ProductMapper;
import com.kaishengit.mapper.ProductTypeMapper;
import com.kaishengit.service.ProductService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private Logger logger = LoggerFactory.getLogger(ProductServiceImpl.class);

    @Autowired
    private ProductMapper productMapper;
    @Autowired
    private ProductTypeMapper productTypeMapper;

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

    /**@Author 周云飞
     *查询所有的商品分类
     * @Date: 2018/4/10 19:40
     */
    @Override
    public List<ProductType> findAllByType() {
        return productTypeMapper.findAll();
    }

    /**@Author 周云飞
     * 保存商品
     * @param  * @param null
     * @Date: 2018/4/10 19:40
     */
    @Override
    public void saveProduct(Product product) {
        product.setCommentNum(Product.DEFAULT_COMMENT_NUM);
        productMapper.saveProduct(product);
        logger.info("保存商品 {}",product);
    }

    /**
     * @Author 周云飞
     * 分页
     * @Date: 2018/4/10 19:51
     */
    @Override
    public PageInfo<Product> findAllPage(Integer pageNo) {
        PageHelper.startPage(pageNo,20);
        List<Product> withPage = productMapper.findAllWithPage();
        return new PageInfo<>(withPage);
    }

    /**
     * @Author 周云飞
     * 查找所有商品的类型
     * @Date: 2018/4/10 22:29
     */
    @Override
    public List<ProductType> findAllProductType() {

        return productTypeMapper.findAll();
    }

    /**
     * @param id
     * @Author 周云飞
     * 根据id删除商品
     * @Date: 2018/4/10 23:02
     */
    @Override
    public void delProduct(Integer id) {

        Product product = productMapper.findById(id);
        if (product != null){
            productMapper.delProduct(id);
            logger.info("删除商品 {}",product);
        }
    }

    /**
     * @Author 周云飞
     * 修改商品信息
     * @Date: 2018/4/10 23:24
     */
    @Override
    public void updateProduct(Product product) {
        productMapper.updateProduct(product);
        logger.info("修改商品{}",product);
    }


}
