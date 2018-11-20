package com.yangpeng.girl;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Springboot的启动类
 * mybatis指定的扫描dao层的路径
 * 开启事务支持
 * @author yangpeng03614
 * @date
 */
@SpringBootApplication
@EnableTransactionManagement
@MapperScan(basePackages = {"com.yangpeng.girl.dao"})
public class GirlApplication {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplication.class, args);
    }

}
