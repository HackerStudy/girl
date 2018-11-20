package com.yangpeng.girl.service.impl;

import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.dao.GirlDao;
import com.yangpeng.girl.entity.Girl;
import com.yangpeng.girl.exception.RuleException;
import com.yangpeng.girl.service.GirlService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @class: GirlServiceImpl
 * @description:
 * @author: yangpeng03614
 * @date: 2018-11-09 09:13
 */
@Service("girlService")
public class GirlServiceImpl implements GirlService{
    /** 日志 */
    private static  final Logger logger= LoggerFactory.getLogger(GirlService.class);

    @Autowired
    private GirlDao girlDao;

    /**
     * 用事务管理来控制插入两个girl（要么同时执行成功，要么直接失败）
     */
    @Override
    @Transactional
    public void saveTwoGirl(){
        Girl girl1 = new Girl();
//        girl1.setId(3);
        girl1.setCupSize("B");
        girl1.setAge(20);
        girlDao.insert(girl1);

        Girl girl2 = new Girl();
//        girl2.setId(4);
        girl2.setAge(22);
        girl2.setCupSize("DDDD");
        girlDao.insert(girl2);
    }


    /**
     * 先判断年龄>10,<20的再做操作(抛出Exception异常)
     */
    @Override
    public Result<?> getAgeByIdThrowException(Integer id) throws Exception {
        Girl girl = girlDao.findById(id);
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
    @Override
    public Result<?> getAgeByIdThrowRuleException(Integer id) throws RuleException {
        Girl girl = girlDao.findById(id);
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

    @Override
    public List<Girl> findAll(){
        return girlDao.findAll();
    }

    @Override
    public List<Girl> findByAge(Integer age) {
        return girlDao.findByAge(age);
    }

    @Override
    public Girl findById(Integer id) {
        return girlDao.findById(id);
    }

    @Override
    public int save(Girl girl) {
        return girlDao.insert(girl);
    }

    @Override
    public int delete(Integer id) {
        return girlDao.deleteByPrimaryKey(id);
    }

    @Override
    public int updateByGirl(Girl girl) {
        return girlDao.updateByGirl(girl);
    }

    @Override
    public int updateByMap(Girl girl) {
        return girlDao.updateByMap(girl);
    }

    @Override
    public int insertBatch(List<Girl> list) {
        return girlDao.insertList(list);
    }


}
