package com.sparta.week02.domain;

public class Person {
    private String name;
    private String job;
    private int age;
    private String address;

    public String getName() {
        return this.name;
    }

    public String getJob() {
        return this.job;
    }

    public int getAge() {
        return this.age;
    }

    public String getAddress() {
        return this.address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
