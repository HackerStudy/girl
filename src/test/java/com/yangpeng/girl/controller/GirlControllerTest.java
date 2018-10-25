package com.yangpeng.girl.controller;

import com.yangpeng.girl.GirlApplicationTests;
import com.yangpeng.girl.service.GirlServiceTest;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

public class GirlControllerTest extends ControllerTest {

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