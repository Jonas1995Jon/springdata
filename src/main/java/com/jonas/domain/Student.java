package com.jonas.domain;

import java.io.Serializable;

/**
 * Desc：Student实体类
 * Author Jonas
 * 2018/10/30 15:11
 */
public class Student implements Serializable {

    private int id; //主键

    private String name; //姓名

    private int age; //年龄

    public Student() {
    }

    public Student(int id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
