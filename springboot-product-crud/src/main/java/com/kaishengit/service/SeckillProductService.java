package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.SeckillProduct;

import java.util.List;

public interface SeckillProductService {

    /**查找所我的秒杀宝贝  并分页
     *
     * @Author Reich
     * @Date: 2018/5/14 13:05
     */
    PageInfo<SeckillProduct> findAllProductPage(Integer pageNo);

    /**添加product
     *
     * @Author Reich
     * @Date: 2018/5/14 14:14
     */
    void saveProduct(SeckillProduct seckillProduct);

    /**根据id删除商品
     *
     * @Author Reich
     * @Date: 2018/5/14 14:49
     */
    void delProduct(Integer id);

    /**修改商品
     *
     * @Author Reich
     * @Date: 2018/5/14 15:02
     */
    void editProduct(SeckillProduct seckillProduct);

    /**通过id查找商品
     *
     * @Author Reich
     * @Date: 2018/5/14 15:03
     */
    SeckillProduct findProductById(Integer id);

    /**异步  抢购
     *
     * @Author Reich
     * @Date: 2018/5/14 18:00
     */
    void buyProduct(Integer id) throws RuntimeException;
}
