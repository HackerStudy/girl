package com.yangpeng.girl.enums;

/**
 * 错误码的枚举类
 */
public enum ResultCodeEnum {
    SUCCESS(200,"SUCCESS"), //成功
    ERROR(1,"ERROR"),   //失败
    ERROR500(500,"ERROR500"), //服务端储出现的500错误
    NEED_LOGIN(10,"NEED_LOGIN"),   //需要登录
    ILLEGAL_ARGUMENT(2,"ILLEGAL_ARGUMENT");  //非法参数

    /** 错误码 */
    private final Integer code;

    /** 提示信息 */
    private final String desc;

    ResultCodeEnum(Integer code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    /**
     * 根据错误码获取枚举对象
     * @param code
     * @return
     */
    public static ResultCodeEnum getResultCodeEnumByCode(Integer code) {
        for (ResultCodeEnum resultCode : ResultCodeEnum.values()) {
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
        return "ResultCodeEnum{" +
                "code=" + code +
                ", desc='" + desc + '\'' +
                '}';
    }
}
