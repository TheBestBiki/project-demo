package com.biki.project.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.biki.project.common.utils.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

/**
 * @author o-Biki.huang
 * @version 1.0
 * @date 2020/9/11
 */
@ControllerAdvice
public class ControllerResultInterceptor implements ResponseBodyAdvice<Object> {

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //对controller接口返回值里的数据，在传给前端之前进行修改
        /*if(body instanceof Result){
            ((Result) body).setData("修改后的数据");
            System.out.println(JSON.toJSONString(body));
        }*/
        return body;
    }

}
