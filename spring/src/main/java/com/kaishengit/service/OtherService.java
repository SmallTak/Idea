package com.kaishengit.service;

import com.kaishengit.dao.StudentDao;

import java.util.*;

public class OtherService {

    private Integer id;
    private String name;
    private Double score;
    private List<String> nameList;
    private Set<Integer> numSet;
    private Map<String,StudentDao> map;
    private Properties properties;

    public void show(){
        System.out.println("id:" + id);
        System.out.println("name:" + name);
        System.out.println("score:" + score);
        for (String name : nameList){
            System.out.println("name:" + name);
        }
        for (Integer num : numSet){
            System.out.println("num:" + num);
        }
//        for (Map.Entry<String,StudentDao> entry : map.entrySet()){
//            System.out.println(entry.getKey() + "->" + entry.getValue());
//        }
       Iterator<Map.Entry<String, StudentDao>> maps = map.entrySet().iterator();
        while (maps.hasNext()){
            Map.Entry<String, StudentDao> entry = maps.next();
            System.out.println(entry.getKey() + entry.getValue());
        }

        Enumeration<Object> enumeration = properties.keys();
        while (enumeration.hasMoreElements()){
            Object key = enumeration.nextElement();
            Object value = properties.get(key);
            System.out.println("key" + key + "value" + value);
        }


    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public void setNameList(List<String> nameList) {
        this.nameList = nameList;
    }

    public void setNumSet(Set<Integer> numSet) {
        this.numSet = numSet;
    }

    public void setMap(Map<String, StudentDao> map) {
        this.map = map;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }
}
