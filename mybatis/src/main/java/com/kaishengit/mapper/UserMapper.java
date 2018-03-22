package com.kaishengit.mapper;

import com.kaishengit.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 *
 * @author 周云飞
 * @date 2018/3/22
 */
public interface UserMapper {

    void save(User user);
    User findByid(int id);
    List<User> findAll();
    List<User> page(Map<String, Integer> map);
    List<User> page2(int start, int size);
    List<User> page3(@Param("start") int start,@Param("size") int size);
    int update(User user);
    int delById(int id);

}
