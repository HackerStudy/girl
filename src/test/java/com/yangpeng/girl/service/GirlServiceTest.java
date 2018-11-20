package com.yangpeng.girl.service;

import com.yangpeng.girl.entity.Girl;
import com.yangpeng.girl.exception.RuleException;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void insertBatch(){
        List<Girl> girlList = new ArrayList<Girl>();
        Girl girl1 =new Girl();
//        girl1.setId(14);
        girl1.setCupSize("B");
        girl1.setAge(18);
        girlList.add(girl1);
        Girl girl2 = new Girl();
//        girl2.setId(15);
        girl2.setCupSize("D");
        girl2.setAge(24);
        girlList.add(girl2);
        girlService.insertBatch(girlList);
    }

    @Test
    public void delete() {
        girlService.delete(13);
    }
}
