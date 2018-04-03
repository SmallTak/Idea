package com.kaishengit.dao;

import org.springframework.stereotype.Repository;

import javax.inject.Named;


/*@Named*/
//@Repository
public class UserDao {

    public void save(){
        System.out.println("userDao save ...");
    }

}
