package com.yangpeng.girl;

import com.yangpeng.girl.controller.GirlControllerTest;
import com.yangpeng.girl.service.GirlServiceTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * @class: TestSuits
 * @description: 打包测试全部
 * @author: yangpeng03614
 * @date: 2018-10-24 16:40
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({GirlControllerTest.class,GirlServiceTest.class})
public class TestSuits{
}
