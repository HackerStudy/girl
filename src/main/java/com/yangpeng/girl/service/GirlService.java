package com.yangpeng.girl.service;

import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.entity.Girl;
import com.yangpeng.girl.exception.RuleException;

import java.util.List;

/**
 * @class: GirlService
 * @description:
 * @author: yangpeng03614
 * @date: 2018-11-09 09:27
 */
public interface GirlService {
    void saveTwoGirl();

    Result<?> getAgeByIdThrowException(Integer id) throws Exception;

    Result<?> getAgeByIdThrowRuleException(Integer id) throws RuleException;

    List<Girl> findAll();

    List<Girl> findByAge(Integer age);

    Girl findById(Integer id);

    int save(Girl girl);

    int delete(Integer id);

    int updateByGirl(Girl girl);

    int updateByMap(Girl girl);

    int insertBatch(List<Girl> list);
}
