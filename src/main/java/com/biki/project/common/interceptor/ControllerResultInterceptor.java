package com.biki.project.common.interceptor;

import com.alibaba.fastjson.JSON;
import com.biki.project.common.utils.Result;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.util.StringUtils;
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

    /**
     * Controller的接口处理完毕，这里对Controller接口的返回值进行拦截并作处理
     * @return
     */
    @Override
    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        //对controller接口返回值里的数据，在传给前端之前进行修改
        if(body instanceof Result){
            ((Result) body).setMsg(StringUtils.isEmpty(((Result) body).getMsg()) ? "ControllerResultInterceptor" : "ControllerResultInterceptor:"+((Result) body).getMsg());
            //System.out.println(JSON.toJSONString(body));
        }
        return body;
    }

}
