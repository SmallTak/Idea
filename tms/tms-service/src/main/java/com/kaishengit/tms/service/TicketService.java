package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Account;
import com.kaishengit.tms.entity.TicketInRecord;

import java.util.List;
import java.util.zip.Adler32;

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
}
