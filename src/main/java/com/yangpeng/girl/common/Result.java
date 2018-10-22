package com.yangpeng.girl.common;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.util.Objects;

/**
 * http请求返回的最外层对象
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 8169426942330219150L;

    /** 错误码 */
    private Integer code;

    /** 提示信息 */
    private String msg;

    /** 具体的内容 */
    private T data;

    public Result(Integer code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public Result(Integer code) {
        this.code = code;
    }

    public Result(Integer code,String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Result(Integer code, T data) {
        this.code = code;
        this.data = data;
    }

    public Result(String msg, T data) {
        this.code = code;
        this.data = data;
    }



    public Result() {
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Result<?> result = (Result<?>) o;
        return Objects.equals(code, result.code) &&
                Objects.equals(msg, result.msg) &&
                Objects.equals(data, result.data);
    }

    @Override
    public int hashCode() {

        return Objects.hash(code, msg, data);
    }

    @SuppressWarnings("unchecked")
    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    @JsonIgnore   //json忽略isSuccess()这个方法(后台推数据到前台的时候,就会把这个给忽略掉)
    public boolean isSuccess() {
        return this.code == ResultCode.SUCCESS.getCode();
    }


    public static <T> Result<T> ok(String msg,T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> Result<T> ok(T data){
        return new Result<T>(ResultCode.SUCCESS.getCode(),ResultCode.SUCCESS.getDesc(),data);
    }
    
    public static <T> Result<T> error(String msg,T data){
        return new Result<T>(ResultCode.ERROR.getCode(),msg,data);
    }

    public static <T> Result<T> error(){
        return new Result<T>(ResultCode.ERROR.getCode(),ResultCode.ERROR.getDesc());
    }

    public static <T> Result<T> error(T data){
        return new Result<T>(ResultCode.ERROR.getCode(),ResultCode.ERROR.getDesc(),data);
    }

    public static <T> Result<T> error(String msg){
        return new Result<T>(ResultCode.ERROR.getCode(),msg);
    }
}
