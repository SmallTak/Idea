package com.kaishengit.service;

import com.kaishengit.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.inject.Inject;

//@Service
public class UserService {

    /*@Autowired*/
    /*@Inject*/
    @Resource
    private UserDao userDao;

    public void  saveTest(){
        userDao.save();
    }
}
