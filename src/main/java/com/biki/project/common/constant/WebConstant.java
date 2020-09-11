package com.biki.project.common.constant;

/**
 * 公共常量
 *
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/11
 */
public class WebConstant {

    public static final String HTTP_HEAD_APPID = "AppId-Gw";

    public static final String HTTP_HEAD_INVOKEURL = "InvokeUrl-Gw";

    public static final String HTTP_HEAD_NONCE = "Nonce-Gw";

    public static final String HTTP_HEAD_TIMESTAMP = "Timestamp-Gw";

    public static final String HTTP_HEAD_SIGN = "Sign-Gw";

    public static final String HTTP_HEAD_ERRORCODE = "ErrorCode-Gw";

    public static final String HTTP_HEAD_NONCE_S = "Nonce-Gw-S";

    public static final String HTTP_HEAD_TIMESTAMP_S = "Timestamp-Gw-S";

    public static final String HTTP_HEAD_SIGN_S = "Sign-Gw-S";

    public static final String HTTP_HEAD_JAEGER_TRACING = "uber-trace-id";

    /**
     * 标签格式
     * sign format
     */
    public static final String GW_SIGN_FORMAT = HTTP_HEAD_APPID + "%s" + HTTP_HEAD_INVOKEURL + "%s"
            + HTTP_HEAD_NONCE + "%s" + HTTP_HEAD_TIMESTAMP + "%s%s";

    /**
     * 标签格式
     * sign format
     */
    public static final String SIGN_FORMAT = HTTP_HEAD_APPID + "%s" + HTTP_HEAD_NONCE + "%s" + HTTP_HEAD_TIMESTAMP + "%s%s";

}
