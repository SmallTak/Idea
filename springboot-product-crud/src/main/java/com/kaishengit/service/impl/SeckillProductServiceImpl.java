package com.kaishengit.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.SeckillProduct;
import com.kaishengit.entity.SeckillProductExample;
import com.kaishengit.mapper.SeckillProductMapper;
import com.kaishengit.service.SeckillProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeckillProductServiceImpl implements SeckillProductService {

    @Autowired
    private SeckillProductMapper seckillProductMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    /**
     * 查找所我的秒杀宝贝  并分页
     *
     * @param pageNo
     * @Author Reich
     * @Date: 2018/5/14 13:05
     */
    @Override
    public PageInfo<SeckillProduct> findAllProductPage(Integer pageNo) {
        PageHelper.startPage(pageNo, 10);

        return new PageInfo<>(seckillProductMapper.selectByExample(new SeckillProductExample()));
    }

    /**
     * 添加product
     *
     * @param seckillProduct
     * @Author Reich
     * @Date: 2018/5/14 14:14
     */
    @Override
    public void saveProduct(SeckillProduct seckillProduct) {
        seckillProductMapper.insertSelective(seckillProduct);
        //将seckillProduct对象和库存放入到redis中
        redisTemplate.opsForValue().set("product:" + seckillProduct.getId(), JSON.toJSONString(seckillProduct));
        redisTemplate.opsForValue().set("product:" + seckillProduct.getId() + "inventory", String.valueOf(seckillProduct.getProductInventory()));
    }

    /**
     * 根据id删除商品
     *
     * @param id
     * @Author Reich
     * @Date: 2018/5/14 14:49
     */
    @Override
    public void delProduct(Integer id) {
        seckillProductMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改商品
     *
     * @param seckillProduct
     * @Author Reich
     * @Date: 2018/5/14 15:02
     */
    @Override
    public void editProduct(SeckillProduct seckillProduct) {
        seckillProductMapper.updateByPrimaryKeySelective(seckillProduct);
    }

    /**
     * 通过id查找商品
     *
     * @param id
     * @Author Reich
     * @Date: 2018/5/14 15:03
     */
    @Override
    public SeckillProduct findProductById(Integer id) {
        return seckillProductMapper.selectByPrimaryKey(id);
    }

    /**
     * 异步  抢购
     *
     * @param id
     * @Author Reich
     * @Date: 2018/5/14 18:00
     */
    @Override
    public void buyProduct(Integer id) throws RuntimeException {

        String json = redisTemplate.opsForValue().get("product:" + id);
        SeckillProduct seckillProduct = JSON.parseObject(json, SeckillProduct.class);

        if (!seckillProduct.isAfter()){
            throw new RuntimeException("未到开抢时间");
        }

        if (!seckillProduct.isBefore()){
            throw new RuntimeException("开抢时间已过");
        }

        seckillProduct.setProductInventory(seckillProduct.getProductInventory() - 1);
        seckillProductMapper.updateByPrimaryKey(seckillProduct);
    }
}
