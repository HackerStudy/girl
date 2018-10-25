package com.yangpeng.girl.controller;

import com.yangpeng.girl.GirlApplicationTests;
import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @class: ControllerTest
 * @description:
 * @author: yangpeng03614
 * @date: 2018-10-25 15:46
 */
@AutoConfigureMockMvc   //注入一个MockMvc实例；
public class ControllerTest extends GirlApplicationTests {
    /**  MockMvc实现了对Http请求的模拟，能够直接使用网络的形式，转换到Controller的调用 */
    @Autowired
    public MockMvc mvc; // 模拟MVC对象，通过MockMvcBuilders.webAppContextSetup(this.wac).build()初始化。

    @Autowired
    private WebApplicationContext wac; // 注入WebApplicationContext

    @Before // 在测试开始前初始化工作,MockMvcBuilders使用构建MockMvc对象   （项目拦截器有效）
    public void setup() {
        this.mvc = MockMvcBuilders.webAppContextSetup(this.wac).build();
    }

}
