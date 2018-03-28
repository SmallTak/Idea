package com.kaishengit.mapper;

import com.kaishengit.entity.Tag;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TagMapper {
    @Select("SELECT * FROM t_student stu INNER JOIN t_stu_tag st ON stu.id = st.sid INNER JOIN t_tag t ON st.tid = t.id WHERE stu.id = #{id}")
    List<Tag> findTag(int id);

}
