package com.kaishengit.mapper;

import com.kaishengit.entity.Student;

import java.util.List;

public interface StudentMapper {

    Student findById(int id);
    Student findId(int id);
    List<Student> findAll();
    Student findByIdTag(int id);

}
