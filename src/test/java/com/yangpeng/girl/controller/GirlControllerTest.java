package com.yangpeng.girl.controller;

import com.yangpeng.girl.GirlApplicationTests;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.match.MockRestRequestMatchers;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import static org.junit.Assert.*;

/**
 * @class: GirlControllerTest
 * @description: GirlController的单元测试类（API测试类）
 * @author: yangpeng03614
 * @date: 2018-10-24 15:36
 */
@AutoConfigureMockMvc   //注入一个MockMvc实例；
public class GirlControllerTest extends GirlApplicationTests {
    /**  MockMvc实现了对Http请求的模拟，能够直接使用网络的形式，转换到Controller的调用 */
    @Autowired
    private MockMvc mvc;

    /**
     *测试girlListAPI（并测试请求地址，状态码，请求返回的内容）
     * @throws Exception
     */
//    @Ignore("not ready yet") //忽略注解，写在方法上，可以忽略这个测试方法，写在类上，可以忽略这个类。
    @Test
    public void girlList() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/girls"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.content().string("你好"));
    }
}