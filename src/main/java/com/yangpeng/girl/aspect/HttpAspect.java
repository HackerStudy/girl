package com.yangpeng.girl.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

@Aspect //标注该类的是aop类
@Component
/**
 * http请求前后的一些数据的日志打印
 */
public class HttpAspect {

    /** 序列化 */
    private static  final Logger logger= LoggerFactory.getLogger(HttpAspect.class);

    /** com.yangpeng.girl.controller.GirlController包下面的公共方法需要被执行"AOP" */
    @Pointcut("execution(public * com.yangpeng.girl.controller.GirlController.*(..))")
    public void log(){
    }

    /** com.yangpeng.girl.controller.GirlController包及其子包的方法需要被执行"AOP" */
    @Pointcut("execution(* com.yangpeng.girl.controller.*.*(..))")
    public void logController(){
    }

    /** 所以的方法都需要被执行"AOP" */
    @Pointcut("execution(* *(..))")
    public void logAll(){

    }

    /**
     * 请求前的提示语句
     */
    @Before("log()")
    public void doBeforeLog(){
        logger.info("请求前");
    }

    /**
     * 请求执行后的提示语句
     */
    @After("log()")
    public void doAfterLog(){
        logger.info("请求后");
    }

    /**
     *获取请求的url,method,ip,class_method,args
     * @param joinPoint
     */
    @Before("log()")
    public void doBeforeHttpRequestLog(JoinPoint joinPoint){
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        //url
        logger.info("url={}",request.getRequestURI());
        //method
        logger.info("method={}",request.getMethod());
        //ip
        logger.info("ip={}",request.getRemoteAddr());
        //类方法
        logger.info("class_method={}",joinPoint.getSignature().getDeclaringTypeName()+"."+joinPoint.getSignature().getName());
        //参数
        logger.info("args={}",joinPoint.getArgs());
    }

    /**
     *输出请求后的返回结果
     * @param object
     */
    @AfterReturning(returning = "object",pointcut = "log()")
    public void doAfterReturning(Object object){
        logger.info("response={}",object.toString());
    }
}
