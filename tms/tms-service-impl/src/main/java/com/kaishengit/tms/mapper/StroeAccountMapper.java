package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.StroeAccount;
import com.kaishengit.tms.entity.StroeAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StroeAccountMapper {
    long countByExample(StroeAccountExample example);

    int deleteByExample(StroeAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(StroeAccount record);

    int insertSelective(StroeAccount record);

    List<StroeAccount> selectByExample(StroeAccountExample example);

    StroeAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") StroeAccount record, @Param("example") StroeAccountExample example);

    int updateByExample(@Param("record") StroeAccount record, @Param("example") StroeAccountExample example);

    int updateByPrimaryKeySelective(StroeAccount record);

    int updateByPrimaryKey(StroeAccount record);
}