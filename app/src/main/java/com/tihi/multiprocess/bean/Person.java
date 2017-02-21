package com.tihi.multiprocess.bean;

/**
 * description:
 * author: duantianhui
 * date: 2017/2/21 10:55
 */

public class Person {
    private String name;
    private String address;
    private int age;

    public Person() {}

    public Person(String name, String add, int age) {
        this.name = name;
        this.address = add;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
