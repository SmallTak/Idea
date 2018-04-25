package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.StroeLoginLog;
import com.kaishengit.tms.entity.StroeLoginLogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StroeLoginLogMapper {
    long countByExample(StroeLoginLogExample example);

    int deleteByExample(StroeLoginLogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StroeLoginLog record);

    int insertSelective(StroeLoginLog record);

    List<StroeLoginLog> selectByExample(StroeLoginLogExample example);

    StroeLoginLog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StroeLoginLog record, @Param("example") StroeLoginLogExample example);

    int updateByExample(@Param("record") StroeLoginLog record, @Param("example") StroeLoginLogExample example);

    int updateByPrimaryKeySelective(StroeLoginLog record);

    int updateByPrimaryKey(StroeLoginLog record);
}