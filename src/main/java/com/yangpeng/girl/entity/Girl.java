package com.yangpeng.girl.entity;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Table(name = "girl")
public class Girl {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY,generator = "JDBC")
    private Integer id;

    @Column(name = "cup_size")
    private String cupSize;

    @Column(name = "age")
    @Min(value = 18,message = "不满18岁") //校验条件
    private Integer age;

    public Girl() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Girl{" +
                "id=" + id +
                ", cupSize='" + cupSize + '\'' +
                ", age=" + age +
                '}';
    }
}
