package com.yangpeng.girl.service;
import com.yangpeng.girl.GirlApplicationTests;
import com.yangpeng.girl.entity.Girl;
import com.yangpeng.girl.exception.RuleException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Map;

/**
 * @class: GirlServiceTest
 * @description: GirlService的单元测试类
 * @author: yangpeng03614
 * @date: 2018-10-24 14:51
 */
public class GirlServiceTest extends ServiceTest {

    @Autowired
    private GirlService girlService;

    /**
     *测试getAgeByIdThrowRuleException，并做异常记录和断言
     */
    @Test
    public void getAgeByIdThrowRuleException(){
        Integer age = new Integer(0);
        try {
            Girl girl = (Girl) girlService.getAgeByIdThrowRuleException(9).getData();
            age = girl.getAge();
        }catch (RuleException e){
            logger.error("【查询异常】",e);
        }
        Assert.assertEquals(new Integer(20),age); //断言
        Assert.assertEquals("判断两个年龄是否相等",new Integer(20),age); //断言
    }

    @Test
    public void saveTwoGirl() {
    }

    @Test
    public void getAgeByIdThrowException() {
    }
}
