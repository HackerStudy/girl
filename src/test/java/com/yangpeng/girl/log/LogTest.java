package com.yangpeng.girl.log;

import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @class: LogTest
 * @description:
 * @author: yangpeng03614
 * @date: 2018-10-29 18:03
 */
@RunWith(SpringRunner.class) //表示使用Spring Test组件进行单元测试，其中SpringRunner继承类SpringJUnit4ClassRunner。
@SpringBootTest //加载整个spring工程
@WebAppConfiguration
//@Slf4j
@Log
public class LogTest {

    @Test
    public void writeLog(){
        log.info("输出到girl.log文件中");
        log.warning("将警告输出到girl.log文件中");
        log.info("10月30");
    }
}
