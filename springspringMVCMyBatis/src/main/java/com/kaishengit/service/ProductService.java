package com.kaishengit.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.Product;
import com.kaishengit.entity.ProductType;

import java.util.List;


public interface ProductService {
    /**@Author 周云飞
     * @MethodDescription 根据id查找商品
     * @param id
     * @Date: 2018/4/10 12:42
     */
    Product findById(Integer id);

    /**@Author 周云飞
     *
     *查询所有的商品分类
     * @Date: 2018/4/10 19:40
     */
    List<ProductType> findAllByType();

    /**@Author 周云飞
     * 保存商品
     * @param  * @param null
     * @Date: 2018/4/10 19:40
     */
    void saveProduct(Product product);

    /**@Author 周云飞
    *分页
    * @Date: 2018/4/10 19:51
    */
    PageInfo<Product> findAllPage(Integer pageNo);

    /**@Author 周云飞
     *查找所有商品的类型
     * @Date: 2018/4/10 22:29
     */
    List<ProductType> findAllProductType();

    /**@Author 周云飞
     *根据id删除商品
     * @Date: 2018/4/10 23:02
     */
    void delProduct(Integer id);

    /**@Author 周云飞
     *修改商品信息
     * @Date: 2018/4/10 23:24
     */
    void updateProduct(Product product);
}
