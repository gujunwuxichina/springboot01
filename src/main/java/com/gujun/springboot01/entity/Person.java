package com.gujun.springboot01.entity;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;

public class Person  implements Serializable {

    private static final long serialVersionUID = -1970211084014242532L;

    @JSONField(serialize=false) //若使用fastjson,无需序列化，即此字段不会返回；
    private Integer id;

    private String name;

    private int age;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public Person() {
    }

    public Person(Integer id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

}
