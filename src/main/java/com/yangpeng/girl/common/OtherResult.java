package com.yangpeng.girl.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class OtherResult implements Serializable{

    private static final long serialVersionUID = -7280043765160868923L;

    private Integer code;

    private String msg;

    private Map<String,Object> data = new HashMap<>();

    public OtherResult() {
    }

    public OtherResult(Integer code, String msg, Map<String, Object> data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public OtherResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

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

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OtherResult that = (OtherResult) o;
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

    @JsonIgnore   //json忽略isSuccess()这个方法(后台推数据到前台的时候,就会把这个给忽略掉)
    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }

    public OtherResult putDataValue(String key,Object value){
        this.data.put(key,value);
        return this;
    }

    public static OtherResult ok(){
        return new OtherResult(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getDesc());
    }

    public static OtherResult error(){
        return new OtherResult(ResultCode.ERROR.getCode(),ResultCode.ERROR.getDesc());
    }

    public static OtherResult error(String msg){
        return new OtherResult(ResultCode.ERROR.getCode(),msg);
    }


}
