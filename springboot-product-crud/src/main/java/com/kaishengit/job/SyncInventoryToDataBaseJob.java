package com.kaishengit.job;

import com.kaishengit.entity.SeckillProduct;
import com.kaishengit.mapper.SeckillProductMapper;
import org.quartz.Job;
import org.quartz.JobDataMap;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.SchedulerException;
import org.springframework.context.ApplicationContext;
import org.springframework.data.redis.core.StringRedisTemplate;

public class SyncInventoryToDataBaseJob implements Job {

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        //获取商品的id
        JobDataMap mergedJobDataMap = jobExecutionContext.getMergedJobDataMap();
        Integer productId = mergedJobDataMap.getIntegerFromString("productId");

        //获取ApplicationContext
        try {
            ApplicationContext applicationContext = (ApplicationContext) jobExecutionContext.getScheduler().getContext().get("applicationContext");
            //获取StringRedisTemplate
            StringRedisTemplate redisTemplate  = applicationContext.getBean(StringRedisTemplate.class);
            //获得当前库存的数量
            Long size = redisTemplate.opsForList().size("product:" + productId + "inventory");

            //获取ProductMapper
            SeckillProductMapper seckillProductMapper = applicationContext.getBean(SeckillProductMapper.class);
            SeckillProduct seckillProduct = seckillProductMapper.selectByPrimaryKey(productId);
            seckillProduct.setProductInventory(size.intValue());

            seckillProductMapper.updateByPrimaryKeySelective(seckillProduct);
            System.out.println("同步数据库完成:" + productId);
        }catch (SchedulerException e){
            e.printStackTrace();
        }
    }



}
