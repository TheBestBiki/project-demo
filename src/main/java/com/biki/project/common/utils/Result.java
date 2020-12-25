package com.biki.project.common.utils;

import java.io.Serializable;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/11
 */
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private static final Integer SUCCESS_CODE = 1;
    private static final Integer FAIL_CODE = 0;

    private T data;

    private Integer code;

    private String msg;

    private Boolean success;

    private Result() {
    }

    private Result(T data, Integer code, Boolean success) {
        this.data = data;
        this.code = code;
        this.success = success;
    }

    private Result(Integer code, String msg, Boolean success) {
        this.code = code;
        this.msg = msg;
        this.success = success;
    }

    public static <T> Result<T> success(T data){
        return new Result<>(data,SUCCESS_CODE,true);
    }

    public static Result<String> successMsg(String msg){
        return new Result<>(SUCCESS_CODE,msg,true);
    }

    public static <T> Result<T> fail(T data){
        return new Result<>(data,FAIL_CODE,false);
    }

    public static Result<String> failMsg(String msg){
        return new Result<>(FAIL_CODE,msg,false);
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
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

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    @Override
    public String toString() {
        return "Result{" +
                "data=" + data +
                ", code=" + code +
                ", msg='" + msg + '\'' +
                ", success=" + success +
                '}';
    }
}
