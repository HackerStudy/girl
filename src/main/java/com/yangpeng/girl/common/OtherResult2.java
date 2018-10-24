package com.yangpeng.girl.common;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.yangpeng.girl.enums.ResultCode;

import java.io.Serializable;
import java.util.Objects;

/**
 * 统一返回值类
 */
public class OtherResult2 implements Serializable{
    /** 序列化 */
    private static final long serialVersionUID = -7280043765160868923L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体的内容 */
    private Object data;

    public OtherResult2() {
    }

    public OtherResult2(Integer code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public OtherResult2(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 获取该类的序列号
     * @return
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtherResult2 that = (OtherResult2) o;
        return Objects.equals(code, that.code) &&
                Objects.equals(msg, that.msg) &&
                Objects.equals(data, that.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, msg, data);
    }

    @Override
    public String toString() {
        return "OtherResult{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * 判断返回是否成功
     * @return
     */
    @JsonIgnore   //json忽略isSuccess()这个方法(后台推数据到前台的时候,就会把这个给忽略掉)
    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }

    /**
     *设置data的值
     * @param data
     * @return
     */
    public OtherResult2 putDataValue(Object data){
        this.data=data;
        return this;
    }

    public static OtherResult2 ok(){
        return new OtherResult2(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getDesc());
    }

    public static OtherResult2 error(){
        return new OtherResult2(ResultCode.ERROR.getCode(),ResultCode.ERROR.getDesc());
    }

    public static OtherResult2 error(String msg){
        return new OtherResult2(ResultCode.ERROR.getCode(),msg);
    }


}
