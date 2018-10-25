package com.yangpeng.girl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 * Springboot的启动类(打包方式为war)
 */
//@SpringBootApplication
public class GirlApplicationWar extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(GirlApplicationWar.class, args);
    }

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder){
        return builder.sources(GirlApplicationWar.class);
    }
}
