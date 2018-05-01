package com.kaishengit.tms.service;

import com.github.pagehelper.PageInfo;
import com.kaishengit.tms.entity.*;

import java.util.List;
import java.util.Map;

public interface TicketService {

    /**年票入库
     *
     * @Author Reich
     * @Date: 2018/4/20 19:15
     */
    void saveTicketInWarehouse(TicketInRecord ticketInRecord, Account account);

    /**
     * 查找所有入库记录
     * @Author Reich
     * @Date: 2018/4/20 22:32
     */
    List<TicketInRecord> findTicketAndTicketInRecord();

    /**通过id删除入库记录
     *
     * @Author Reich
     * @Date: 2018/4/20 23:15
     */
    void delTicketInRecordById(Integer id);

    /**年票入库信息回显
     *
     * @Author Reich
     * @Date: 2018/4/21 10:32
     */
    TicketInRecord findTicketInRecord(Integer id);

    /**修改年票入库信息
     *
     * @Author Reich
     * @Date: 2018/4/21 10:49
     */
    void updateTicketInRecord(Integer id, TicketInRecord ticketInRecord);

    /**查询所有的年票代理点
     *
     * @Author Reich
     * @Date: 2018/4/23 11:05
     */
    List<TicketStroe> findAllTikcetStroe();

    /**新增年票下发
     *
     * @Author Reich
     * @Date: 2018/4/23 11:21
     */
    void saveTicketOut(TicketOutRecord ticketOutRecord, Account account);

    /**查出所有的出库记录
     *
     * @Author Reich
     * @Date: 2018/4/23 14:28
     */
    PageInfo<TicketOutRecord> findAllTicketOutRecord(Integer pageNo);

    /**通过id删除年票下发记录
     *
     * @Author Reich
     * @Date: 2018/4/23 16:56
     */
    void delTicketOutRecord(Integer id);

    /**数据统计
     *
     * @Author Reich
     * @Date: 2018/4/23 22:07
     */
    Map<String,Long> countTicketByState();

    /**查找所有年票的下发记录
     *
     * @Author Reich
     * @Date: 2018/4/24 12:44
     */
    PageInfo<TicketOutRecord> findAllTicketOutAndPage(Integer pageNo, Map<String, Object> queryParam);

    /**通过id查找缴费年票订单的金额
     *
     * @Author Reich
     * @Date: 2018/4/24 14:17
     */
    TicketOutRecord findTicketOutRecordPay(Integer id);

    /**提交缴费记录
     *
     * @Author Reich
     * @Date: 2018/4/24 14:24
     */
    void savePayRecord(Integer id, String paymentMethod, Account account);

    /**通过年票id查找年票
     *
     * @Author Reich
     * @Date: 2018/5/1 20:47
     */
    Ticket findTicketByTicketNum(String ticketNum);
}
