package com.biki.project.common.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 请求拦截器 -- 验证权限
 *
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/11
 */
@Component
public class WebInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        /*String appId = request.getHeader(HTTP_HEAD_APPID);
        String nonce = request.getHeader(HTTP_HEAD_NONCE);
        String timestamp = request.getHeader(HTTP_HEAD_TIMESTAMP);
        String reqSign = request.getHeader(HTTP_HEAD_SIGN);

        if(!APP_ID.equals(appId) || StringUtils.isBlank(nonce) || StringUtils.isBlank(timestamp) || StringUtils.isBlank(reqSign)
                || reqSign.equals(DigestUtils.md5Hex(String.format(SIGN_FORMAT, appId, nonce, timestamp, appSecret)))){
            throw new Exception("非法请求，请求失败");
        }*/

        return true;
    }

}
