package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.TicketStroe;

import java.util.List;

public interface TicketStoreService {

    /**查找所有的代理年票客户
     *
     * @Author Reich
     * @Date: 2018/4/19 20:24
     */
    List<TicketStroe> findAllTicketStrop();

    /**根据代理人id删除代理人
     *
     * @Author Reich
     * @Date: 2018/4/19 21:16
     */
    void delTicketStroe(Integer id);


    /**根据id查找TicletStroe
     *
     * @Author Reich
     * @Date: 2018/4/19 22:22
     */
    TicketStroe findTicketStroeById(Integer id);

    /**更新ticketStroe
     *
     * @Author Reich
     * @Date: 2018/4/19 22:47
     */
    void updateTicketStroe(Integer id, TicketStroe ticketStroe);
}
