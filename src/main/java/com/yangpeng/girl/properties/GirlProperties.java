package com.yangpeng.girl.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * @class: GirlProperties
 * @description: 读取配置文件girl这一组配置的实体类
 * @author: yangpeng03614
 * @date: 2018-10-17 11:08
 */
@Component  //注入实体类的bean
@ConfigurationProperties(prefix = "girl")//读取配置文件girl这个一组的配置
//@ConfigurationProperties(prefix = "girl",locations = "classpath:author.properties")
// PropertySource默认取application.properties
// @PropertySource(value = "config.properties") //获取config.properties配置文件中的东西
public class GirlProperties {
    private String cupSize;

    private int age;

    public GirlProperties() {
    }

    public GirlProperties(String cupSize, int age) {
        this.cupSize = cupSize;
        this.age = age;
    }

    public String getCupSize() {
        return cupSize;
    }

    public void setCupSize(String cupSize) {
        this.cupSize = cupSize;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
