package com.kaishengit.service.impl;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.kaishengit.entity.SeckillProduct;
import com.kaishengit.entity.SeckillProductExample;
import com.kaishengit.job.SyncInventoryToDataBaseJob;
import com.kaishengit.mapper.SeckillProductMapper;
import com.kaishengit.service.SeckillProductService;
import org.apache.activemq.command.ActiveMQQueue;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.quartz.CronScheduleBuilder;
import org.quartz.JobBuilder;
import org.quartz.JobDataMap;
import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.stereotype.Service;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;
import java.util.Random;

@Service
public class SeckillProductServiceImpl implements SeckillProductService {

    @Autowired
    private SeckillProductMapper seckillProductMapper;

    @Autowired
    private StringRedisTemplate redisTemplate;

    @Autowired
    private SchedulerFactoryBean schedulerFactoryBean;

    @Autowired
    private JmsTemplate jmsTemplate;

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
        for (int i = 1; i <= seckillProduct.getProductInventory(); i++){
            redisTemplate.opsForList().leftPush("product:"+seckillProduct.getId()+"inventory",String.valueOf(i));
        }

        //添加动态的定时任务，让秒杀结束后同步库存到数据库中
        addSyncInventoryJob(seckillProduct.getId(),seckillProduct.getEndTime());

        //redisTemplate.opsForValue().set("product:" + seckillProduct.getId() + "inventory", String.valueOf(seckillProduct.getProductInventory()));
    }

    private void addSyncInventoryJob(Integer id, String endTime) {

        JobDataMap jobDataMap = new JobDataMap();
        jobDataMap.putAsString("productId", id);

        JobDetail jobDetail = JobBuilder.newJob(SyncInventoryToDataBaseJob.class)
                .withIdentity("product:" + id, "product:sync:database")
                .setJobData(jobDataMap)
                .build();

        DateTimeFormatter dateTimeFormatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm");
        DateTime dateTime = dateTimeFormatter.parseDateTime(endTime);

        //拼接cron表达式
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("0 ");
        stringBuilder.append(dateTime.getMinuteOfHour()).append(" ");
        stringBuilder.append(dateTime.getHourOfDay()).append(" ");
        stringBuilder.append(dateTime.getDayOfMonth()).append(" ");
        stringBuilder.append(dateTime.getMonthOfYear()).append(" ");
        stringBuilder.append("? ");
        stringBuilder.append(dateTime.getYear());

        String cron = stringBuilder.toString();

        CronScheduleBuilder cronScheduleBuilder = CronScheduleBuilder.cronSchedule(cron);
        Trigger trigger =TriggerBuilder.newTrigger().withSchedule(cronScheduleBuilder).build();

        Scheduler scheduler = schedulerFactoryBean.getScheduler();

        try {
            scheduler.scheduleJob(jobDetail, trigger);
            scheduler.start();
        } catch (SchedulerException e) {
            e.printStackTrace();
        }

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
//        String s = redisTemplate.opsForValue().get("product:"+seckillProduct.getId()+"inventory");
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
     * 通过id查找商品
     *
     * @param id
     * @Author Reich
     * @Date: 2018/5/14 15:03
     */
    @Override
    public SeckillProduct findProductById(Integer id) {
        String json = redisTemplate.opsForValue().get("product:" + id);
        SeckillProduct seckillProduct = JSON.parseObject(json, SeckillProduct.class);
        //获取最新的库存
        Long size = redisTemplate.opsForList().size("product:"+id+"inventory");
        seckillProduct.setProductInventory(size.intValue());
        return seckillProduct;
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

        if (!seckillProduct.isBefore()){
            throw new RuntimeException("未到开抢时间");
        }

        if (seckillProduct.isAfter()){
            throw new RuntimeException("开抢时间已过");
        }

        //第二种解决超卖方案  推荐使用 list push pop   弹出最左边的元素，弹出之后该值在列表中将不复存在
        if (redisTemplate.opsForList().leftPop("product:" + id + "inventory") != null){
            Long size = redisTemplate.opsForList().size("product:" + id + "inventory");
            System.out.println("抢购成功" + size);
            //下订单-> MQ
            sendOrderInfoToMQ(id);
        } else {
            System.out.println("已售罄......");
        }



        //第一种解决超卖方案  有线程安全问题  不推荐使用

    /*    try {
            Thread.sleep(new Random().nextInt(200));
        }catch (InterruptedException e){
            e.printStackTrace();
        }*/

        /*if (redisTemplate.opsForValue().get("product:" + id + "inventory").equals(0)){
            System.out.println("商品已被抢光");
        }else {
            redisTemplate.opsForValue().increment("product:" + id + "inventory", -1);
            System.out.println("商品抢购成功");
        }*/

    }

    public void sendOrderInfoToMQ(Integer id){

        ActiveMQQueue queue = new ActiveMQQueue("user-order");
        jmsTemplate.send(queue, new MessageCreator() {
            @Override
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage = session.createTextMessage(String.valueOf(id));
                return textMessage;
            }
        });

    }

}
