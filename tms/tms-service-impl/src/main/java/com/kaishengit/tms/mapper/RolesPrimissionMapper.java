package com.kaishengit.tms.mapper;

import com.kaishengit.tms.entity.RolesPrimissionExample;
import com.kaishengit.tms.entity.RolesPrimissionKey;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface RolesPrimissionMapper {
    long countByExample(RolesPrimissionExample example);

    int deleteByExample(RolesPrimissionExample example);

    int deleteByPrimaryKey(RolesPrimissionKey key);

    int insert(RolesPrimissionKey record);

    int insertSelective(RolesPrimissionKey record);

    List<RolesPrimissionKey> selectByExample(RolesPrimissionExample example);

    int updateByExampleSelective(@Param("record") RolesPrimissionKey record, @Param("example") RolesPrimissionExample example);

    int updateByExample(@Param("record") RolesPrimissionKey record, @Param("example") RolesPrimissionExample example);
}