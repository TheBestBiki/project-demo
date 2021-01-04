package com.biki.project.common.exception;

import com.biki.project.common.constant.ErrorMessageEnum;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2021/1/4
 */
public class UnifiedException extends RuntimeException {
    private static final long serialVersionUID = 14894864L;
    // 默认错误代码
    public static final Integer GENERIC = 1000000; // 系统内部错误
    public static final Integer CUSTOM = 1111; // 用户自定义错误
    public static final Integer REQUEST_ERROR_CODE = 1001;

    private int errorCode;

    private Exception e;
    private List<String> params = new ArrayList<String>(4);

    public UnifiedException() {}

    @Deprecated //该注解表示所标记的方法已弃用，可以使用但是建议不要使用
    public UnifiedException(String message) {
        super(message);
        this.errorCode = CUSTOM;
    }

    public static UnifiedException from(String msg) {
        return new UnifiedException(REQUEST_ERROR_CODE, msg);
    }

    public UnifiedException(int code) {
        super(ErrorMessageEnum.getMessage(code));
        this.errorCode = code;
    }

    public UnifiedException(ErrorMessageEnum errorMessageEnum) {
        super(errorMessageEnum.getMessage());
        this.errorCode = errorMessageEnum.getCode();
    }

    public UnifiedException(ErrorMessageEnum errorMessageEnum, String... message) {
        super(MessageFormat.format(errorMessageEnum.getMessage(), message));
        this.errorCode = errorMessageEnum.getCode();
    }

    public UnifiedException(int errorCode, String message) {
        super(message);
        this.errorCode = errorCode;
    }

    public UnifiedException(int errorCode, Throwable cause) {
        this(errorCode, null, cause);
    }

    public UnifiedException(String message, Throwable cause) {
        this(GENERIC, message, cause);
    }

    public UnifiedException(int errorCode, String message, Throwable cause) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }

    public void addParams(String param) {
        this.params.add(param);
    }

    public List<String> getParams() {
        return params;
    }
}
