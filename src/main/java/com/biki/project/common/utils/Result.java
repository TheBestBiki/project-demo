package com.biki.project.common.utils;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/11
 */
public class Result<T> {

    private static final long serialVersionUID = 1L;

    private T data;

    private String code;

    private String msg;

    private Boolean success;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
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
