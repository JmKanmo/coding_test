package com.service.whatap_test.domain;


public class UserDomain {
    private Integer id;
    private String name;
    private Integer age;
    private String sex;
    private Integer payment;

    public UserDomain(Integer id, String name, Integer age, String sex, Integer payment) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.payment = payment;
    }

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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getPayment() {
        return payment;
    }

    public void setPayment(Integer payment) {
        this.payment = payment;
    }
}
