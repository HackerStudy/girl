package com.yangpeng.girl.handle;

import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.exception.RuleException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @class: ExceptionHandle
 * @description: 统一异常处理类
 * @author: yangpeng03614
 * @date: 2018-10-24 09:51
 */
//基于@ControllerAdvice注解的全局异常统一处理只能针对于Controller层的异常，意思是只能捕获到Controller层的异常，在service层或者其他层面的异常都不能捕获。
@ControllerAdvice //controller 增强器
public class ExceptionHandle {

    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandle.class);

    /**
     * 处理exception异常，并打印异常输出
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> handleException(Exception e){
        if(e instanceof RuleException){
            return Result.error(((RuleException) e).getCode(),e.getMessage());
        }
        logger.error("【系统异常】捕获到Exception异常",e);
        return Result.error500(e.getMessage());
    }


    /**
     * 处理RuleException异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = RuleException.class)
    @ResponseBody
    public Result<?> handleRuleException(RuleException e){
        logger.error("【自定义异常】捕获到RuleException异常",e);
        return Result.error(e.getCode(),e.getMessage());
    }
}
