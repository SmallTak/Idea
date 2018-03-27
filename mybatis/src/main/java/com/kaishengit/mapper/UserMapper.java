package com.kaishengit.mapper;

import com.kaishengit.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 周云飞
 * @date 2018/3/22
 */
public interface UserMapper {

    @Insert("insert into t_user(user_name, age, phone_num) values (#{userName},#{age}, #{phoneNum})")
    @Options(useGeneratedKeys = true, keyProperty = "id")
    void save(User user);

    @Select("select * from t_user where id = #{id}")
    User findByid(int id);

    List<User> findAll();

    List<User> page(Map<String, Integer> map);

    @Select(" SELECT * FROM t_user limit #{arg0}, #{arg1}")
    List<User> page2(int start, int size);
    List<User> page3(@Param("start") int start,@Param("size") int size);

    int update(User user);

    @Delete("delete from t_user where id = #{id}")
    int delById(int id);

}


