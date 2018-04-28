package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.TicketStroe;
import com.kaishengit.tms.entity.TicketStroeExample;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

public interface TicketStroeMapper {
    long countByExample(TicketStroeExample example);

    int deleteByExample(TicketStroeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TicketStroe record);

    int insertSelective(TicketStroe record);

    List<TicketStroe> selectByExample(TicketStroeExample example);

    TicketStroe selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TicketStroe record, @Param("example") TicketStroeExample example);

    int updateByExample(@Param("record") TicketStroe record, @Param("example") TicketStroeExample example);

    int updateByPrimaryKeySelective(TicketStroe record);

    int updateByPrimaryKey(TicketStroe record);

    Map<String,Long> countByStateAndStoreAccountId(Integer id);
}