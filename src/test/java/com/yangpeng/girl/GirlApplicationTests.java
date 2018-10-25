package com.yangpeng.girl;

import com.yangpeng.girl.service.GirlServiceTest;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * 测试的基类
 */
@RunWith(SpringRunner.class) //表示使用Spring Test组件进行单元测试，其中SpringRunner继承类SpringJUnit4ClassRunner。
@SpringBootTest //加载整个spring工程
@WebAppConfiguration //由于是Web项目，Junit需要模拟ServletContext，因此我们需要给我们的测试类加上@WebAppConfiguration。
//配置事务的回滚,对数据库的增删改都会回滚,便于测试用例的循环利用
//@TransactionConfiguration(transactionManager = "transactionManager", defaultRollback = true)
//@Transactional
public class GirlApplicationTests {
    /** slf4日志*/
    public static final Logger logger = LoggerFactory.getLogger(GirlServiceTest.class);

    @Test
    public void contextLoads() {
    }

    /**
     * 测试前执行的方法
     */
    @Before
    public void init() {
        System.out.println("开始测试-----------------");
    }

    /**
     *测试后执行的方法
     */
    @After
    public void after() {
        System.out.println("测试结束-----------------");
    }

}
