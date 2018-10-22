package com.yangpeng.girl.common;

import org.aspectj.apache.bcel.classfile.Code;

public enum ResultCode {
    SUCCESS(200,"SUCCESS"),
    ERROR(1,"ERROR"),
    ERROR500(500,"ERROR500"),
    NEED_LOGIN(10,"NEED_LOGIN"),   //需要登录
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");  //非法参数

    private final Integer code;

    private final String desc;

    ResultCode(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    public static ResultCode getResultCodeByCode(Integer code) {
        for (ResultCode resultCode : ResultCode.values()) {
            if (resultCode.getCode().equals(code)) {
                return resultCode;
            }
        }
        return null;
    }

    public Integer getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    @Override
    public String toString() {
        return "ResultCode{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
