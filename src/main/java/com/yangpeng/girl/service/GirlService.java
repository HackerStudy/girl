package com.yangpeng.girl.service;

import com.yangpeng.girl.aspect.HttpAspect;
import com.yangpeng.girl.dao.GirlRepository;
import com.yangpeng.girl.entity.Girl;
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
}
