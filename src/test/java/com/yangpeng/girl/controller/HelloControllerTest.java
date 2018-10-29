package com.yangpeng.girl.controller;

import com.alibaba.fastjson.JSON;
import com.sun.media.jfxmedia.logging.Logger;
import com.yangpeng.girl.GirlApplicationTests;
import org.junit.Test;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.handler;

/**
 * @class: HelloControllerTest
 * @description: HelloController的测试类
 * @author: yangpeng03614
 * @date: 2018-10-25 15:16
 */

public class HelloControllerTest extends ControllerTest {

    /**
     * 获取配置文件中的值（api测试）
     * @throws Exception
     */
    @Test
    public void getProperties() throws Exception{
        String requestBody = "{\"id\":1, \"name\":\"zhang\"}"; //模拟的json请求类型
//        mvc.perform(MockMvcRequestBuilders.get("/hello/getProperties"))
//                .andExpect(MockMvcResultMatchers.status().isOk());
        //调用接口，传入添加的用户参数
        RequestBuilder request = MockMvcRequestBuilders.get("/hello/getProperties")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .content(JSON.toJSONString(null));
        MvcResult mvcResult = mvc.perform(request)
                .andExpect(handler().handlerType(HelloController.class)) //验证执行的控制器类型
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().contentType(MediaType.APPLICATION_JSON_UTF8)) // 预期返回值的媒体类型text/plain;charset=UTF-8
                .andDo(MockMvcResultHandlers.print())
                .andReturn();
        int status = mvcResult.getResponse().getStatus();
        String content = mvcResult.getResponse().getContentAsString();
//        System.out.println("content"+content);
//        System.out.println("status"+status);
        System.out.println("请求的数据：");
        logger.info("characterEncoding={}",mvcResult.getRequest().getCharacterEncoding());
        logger.info("Content={}",mvcResult.getRequest().getContentAsString());
        logger.info("Method={}",mvcResult.getRequest().getMethod());
        logger.info("RequestURI={}",mvcResult.getRequest().getRequestURI());
        logger.info("AuthType={}",mvcResult.getRequest().getAuthType());
        logger.info("ContextPath={}",mvcResult.getRequest().getContextPath());
        System.out.println("响应的数据：");
        logger.info("content={}",content);
        logger.info("status={}",status);
//        logger.info("ModelAndView={}",mvcResult.getModelAndView().toString());
        logger.info("CharacterEncoding={}",mvcResult.getResponse().getCharacterEncoding());
    }
}