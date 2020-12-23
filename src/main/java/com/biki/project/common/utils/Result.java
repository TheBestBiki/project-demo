package com.biki.project.common.utils;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/11
 */
public class Result<T> {

    private static final long serialVersionUID = 1L;

    private T data;

    private Integer code;

    private String msg;

    private Boolean success;

    public static <T> Result<T> success(T data){
        Result<T> result = new Result<>();
        result.data = data;
        result.success=true;
        result.code=200;
        return result;
    }

    public static Result<String> successMsg(String msg){
        Result<String> result = new Result<>();
        result.msg=msg;
        result.success=true;
        result.code=200;
        return result;
    }

    public static <T> Result<T> fail(T data){
        Result<T> result = new Result<>();
        result.data = data;
        result.success=false;
        result.code=500;
        return result;
    }

    public static Result<String> failMsg(String msg){
        Result<String> result = new Result<>();
        result.msg=msg;
        result.success=false;
        result.code=500;
        return result;
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
}
