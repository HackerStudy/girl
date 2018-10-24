package com.yangpeng.girl.service;

import com.yangpeng.girl.aspect.HttpAspect;
import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.dao.GirlRepository;
import com.yangpeng.girl.entity.Girl;
import com.yangpeng.girl.exception.RuleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

/**
 * @class: GirlService
 * @description:
 * @author: yangpeng03614
 * @date: 2018-10-19 13:56
 */
@Service
public class GirlService {

    /** 日志 */
    private static  final Logger logger= LoggerFactory.getLogger(GirlService.class);

    @Autowired
    private GirlRepository girlRepository;  //girl的数据库操作接口

    /**
     * 用事务管理来控制插入两个girl（要么同时执行成功，要么直接失败）
     */
    @Transactional
    public void saveTwoGirl(){
        Girl girl1 = new Girl();
//        girl1.setId(3);
        girl1.setCupSize("B");
        girl1.setAge(20);
        girlRepository.save(girl1);

        Girl girl2 = new Girl();
//        girl2.setId(4);
        girl2.setAge(22);
        girl2.setCupSize("DDDD");
        girlRepository.save(girl2);
    }


    /**
     * 先判断年龄>10,<20的再做操作(抛出Exception异常)
     */
    public Result<?> getAgeByIdThrowException(Integer id) throws Exception {
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age<10){
            String msg = "还在上小学";
            logger.error(msg);
            throw new Exception(msg);
        }else if(age>20){
            String msg = "已经上大学了";
            logger.error(msg);
            throw new Exception(msg);
        }
        return Result.ok("查询成功",girl);
    }

    /**
     * 先判断年龄>10,<20的再做操作(抛出RuleException异常)
     */
    public Result<?> getAgeByIdThrowRuleException(Integer id) throws RuleException {
        Girl girl = girlRepository.findById(id).orElse(null);
        Integer age = girl.getAge();
        if(age<10){
            String msg = "还在上小学";
            logger.error(msg);
            throw new RuleException(501,msg);
        }else if(age>20){
            String msg = "已经上大学了";
            logger.error(msg);
            throw new RuleException(501,msg);
        }
        return Result.ok("查询成功",girl);
    }
}
