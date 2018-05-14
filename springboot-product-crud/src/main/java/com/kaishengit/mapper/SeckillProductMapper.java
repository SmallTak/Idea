package com.kaishengit.mapper;

import com.kaishengit.entity.SeckillProduct;
import com.kaishengit.entity.SeckillProductExample;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface SeckillProductMapper {
    long countByExample(SeckillProductExample example);

    int deleteByExample(SeckillProductExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(SeckillProduct record);

    int insertSelective(SeckillProduct record);

    List<SeckillProduct> selectByExample(SeckillProductExample example);

    SeckillProduct selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") SeckillProduct record, @Param("example") SeckillProductExample example);

    int updateByExample(@Param("record") SeckillProduct record, @Param("example") SeckillProductExample example);

    int updateByPrimaryKeySelective(SeckillProduct record);

    int updateByPrimaryKey(SeckillProduct record);
}