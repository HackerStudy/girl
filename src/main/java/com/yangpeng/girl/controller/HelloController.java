package com.yangpeng.girl.controller;

import com.yangpeng.girl.aspect.HttpAspect;
import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.properties.GirlProperties;
import javafx.application.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @class: HelloController
 * @description:
 * @author: yangpeng03614
 * @date: 2018-10-15 11:46
 */

//@RestController = @Controller+@ResponseBody
@RestController
//@Controller
//@ResponseBody
@RequestMapping("/hello")
public class HelloController {
    /** slf4j日志*/
    private static  final Logger logger= LoggerFactory.getLogger(HelloController.class);

    @Value("${cupSize}")
    private String cupSize; //读取配置文件中的数据

    @Value("${age}")
    private int age;

    @Value("${content}")
    private String content;

    @Autowired
    private GirlProperties girlProperties;  //读取配置文件一组的数据

    /** 通过Evnironment来获取配置文件中的值*/
    @Autowired
    private Environment env;

    /**
     * rest模式的get方法，返回传入数据和配置文件中数据的打印结果
     * @param context
     * @return
     */
    @RequestMapping(value = "/say/{context}",method = RequestMethod.GET)
    public String say(@PathVariable String context){
        Map<String,Object> map = new HashMap<String, Object>();
        map.put("cupSize",cupSize);
        map.put("age",age);
        map.put("content",content);
        map.put("context",context);
        map.put("girlProperties.cupSize",girlProperties.getCupSize());
        map.put("girlProperties.age",girlProperties.getAge());
        return map.toString();
    }

    /**
     * thymeleaf模板的测试方法，跳转到index页面
     * @return
     */
    @RequestMapping(value = "/look",method = RequestMethod.GET)
    public String look(){
        return "index";
    }

    /**
     * 多个请求对应着一个方法
     * @return
     */
    @RequestMapping(value ={"/allforone","/nihao"} ,method = RequestMethod.GET)
    public String ALlforone(){
        return "多个链接对应一个方法";
    }

    /**
     * Post请求
     * @return
     */
    @RequestMapping(value ="/postRequest" ,method = RequestMethod.POST)
    public String postRequest(@RequestBody String context){
        return "这是post请求输出内容为："+context;
    }

    /**
     * Post请求2
     * @return
     */
    @RequestMapping(value ="/postRequest2" ,method = RequestMethod.POST)
    public String postRequest2(){
        return "hello Spring boot";
    }

    /**
     * getAndpost请求(不推荐使用)
     * @return
     */
    @RequestMapping(value ="/getAndpostRequest")
    public String getAndpostRequest(){
        return "get and post request";
    }

    /**
     * 通过@RequestParam来获取带参数的请求
     * @return
     */
    @RequestMapping(value ="/getResult",method = RequestMethod.GET)
    public String getResult(@RequestParam("context") String context){
        return "context:"+context;
    }

    /**
     * 通过@RequestParam来获取带参数的请求(设置非必传,设置默认值为“你好”)
     * @return
     */
    @RequestMapping(value ="/getResult3",method = RequestMethod.GET)
    public String getResult3(@RequestParam(value = "context",required = false,defaultValue = "你好") String context){
        return "context:"+context;
    }

    /**
     * 通过@PathVariable来获取请求中url里面的参数
     * @return
     */
    @RequestMapping(value ="/getResult2/{context}",method = RequestMethod.GET)
    public String getResult2(@PathVariable("context") String context){
        return "context:"+context;
    }

    /**
     * 组合注解
     * @param context
     * @return
     */
    @GetMapping("/combinationMapping")
//    @PostMapping("/combinationMapping")
//    @PutMapping("/combinationMapping")
//    @DeleteMapping("/combinationMapping")
    public String combinationMapping(String context){
        return "context:"+context;
    }

    /**
     * 通过Evnironment来获取配置文件中的值
     * @return
     */
    @GetMapping("/getProperties")
    public Result<?> getProperties(){
        Map<String,Object> returnMap = new HashMap<>();
        String cupSize = env.getProperty("girl.cupSize");
        String age = env.getProperty("girl.age");
        returnMap.put("cupSize",cupSize);
        returnMap.put("age",age);
        return Result.ok("成功获取到配置文件数据",returnMap);
    }

    /**
     * 测试aop中的Around
     * @param result
     * @return
     */
    @GetMapping("/testAround")
    public String testAround(String result){
        return "result:"+result;
    }
}
