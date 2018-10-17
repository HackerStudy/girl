package com.yangpeng.girl;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * girl的dao层接口，继承jpa（里面实体类为Girl,id主键为Integer类型）
 */
public interface GirlRepository extends JpaRepository<Girl,Integer>{

}
