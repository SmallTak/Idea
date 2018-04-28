package com.kaishengit.tms.service;

import com.kaishengit.tms.entity.Customer;
import com.kaishengit.tms.entity.StroeAccount;

public interface TicketCustomerService {

    /**保存客户购票信息
     *
     * @Author Reich
     * @Date: 2018/4/27 21:29
     */
    void saveTicketCustomer(Customer customer, StroeAccount stroeAccount);
}
