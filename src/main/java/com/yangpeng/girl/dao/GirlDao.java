package com.yangpeng.girl.dao;

import com.yangpeng.girl.common.BaseMapper;
import com.yangpeng.girl.entity.Girl;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @class: GirlDao
 * @description:
 * @author: yangpeng03614
 * @date: 2018-11-09 09:09
 */
@Mapper
public interface GirlDao extends BaseMapper<Girl> {

    /**
     * 按年龄查找
     * @param age
     * @return
     */
    List<Girl> findByAge(@Param("age") Integer age);

    List<Girl> findAll();

    /**
     * 按id查找
     * @param id
     * @return
     */
    Girl findById(@Param("id") Integer id);

    /**
     * 更新通过girl
     * @param girl
     * @return
     */
    int updateByGirl(Girl girl);

    /**
     * 更新通过map
     * @param girl
     * @return
     */
    int updateByMap(Girl girl);
}
