package com.yangpeng.girl.exception;

import com.yangpeng.girl.enums.ResultCode;

/**
 * @class: RuleException
 * @description: 自定义规则处理异常（spring中只对抛出异常为RuntimeException才会做出事务回滚，
 * 如果是Exception异常是不会回滚的）
 * @author: yangpeng03614
 * @date: 2018-10-24 11:12
 */
public class RuleException extends RuntimeException{
    /** 错误码*/
   private Integer code;

    public RuleException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    /**
     * 依据枚举返回错误码和提示信息
     * @param resultCode
     */
    public RuleException(ResultCode resultCode) {
        super(resultCode.getDesc());
        this.code = resultCode.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
