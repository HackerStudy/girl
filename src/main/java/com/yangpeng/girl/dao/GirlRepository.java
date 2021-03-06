package com.yangpeng.girl.dao;

import com.yangpeng.girl.entity.Girl;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * girl的dao层接口，继承jpa（里面实体类为Girl,id主键为Integer类型）
 */
//@Repository
//@RepositoryDefinition(domainClass=Girl.class,idClass=Integer.class)
public interface GirlRepository extends JpaRepository<Girl,Integer>{
    /**
     * 按年龄查找
     * @param age
     * @return
     */
    List<Girl> findByAge(Integer age);


}
