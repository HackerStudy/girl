package com.yangpeng.girl.handle;

import com.yangpeng.girl.common.Result;
import com.yangpeng.girl.exception.RuleException;
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
@ControllerAdvice
public class ExceptionHandle {

    /**
     * 处理exception异常
     * @param e
     * @return
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public Result<?> handleException(Exception e){
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
        return Result.error(e.getCode(),e.getMessage());
    }
}
