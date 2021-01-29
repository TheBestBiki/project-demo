package com.biki.project.common.utils;

import com.alibaba.fastjson.JSON;
import com.biki.project.common.exception.UnifiedException;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.URI;
import java.util.Map;


/**
 * @author o-Biki.huang
 * @version 1.0
 * 参考网址1：https://www.jianshu.com/p/6c977fa29cca
 * 参考网址2：https://www.cnblogs.com/shenjiangwei/p/11068312.html
 * @date 2021/1/28
 */
public class HttpClientUtil {

    private static final Logger logger = LoggerFactory.getLogger(HttpClientUtil.class);

    /**
     * delete请求
     */
    public static String HttpDelete(String url, String json, Map<String, String> header) {
        CloseableHttpClient client = null;
        HttpDeleteWithBody httpDelete = null;
        String result = null;
        try {
            client = HttpClients.createDefault();
            httpDelete = new HttpDeleteWithBody(url);

            if (header != null) {
                for (Map.Entry<String, String> entry : header.entrySet()) {
                    httpDelete.addHeader(entry.getKey(), entry.getValue());
                }
            }
            httpDelete.setEntity(new StringEntity(json));

            CloseableHttpResponse response = client.execute(httpDelete);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity);

            if (200 == response.getStatusLine().getStatusCode()) {
                logger.info("DELETE方式请求远程调用成功，返回结果:{}", JSON.toJSONString(result));
            }
        } catch (Exception e) {
            logger.error("DELETE方式请求远程调用失败,异常信息:{}", e.getMessage(), e);
        } finally {
            try{
                client.close();
            } catch (IOException e) {
                logger.error("DELETE请求客户端关闭失败");
                throw UnifiedException.from(e.toString());
            }
        }
        return result;
    }

    /**
     * HttpDelete不能传参数entity，所以要新建一个类
     * 参考网址：https://www.cnblogs.com/shenjiangwei/p/11068312.html
     */
    public static class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
        public static final String METHOD_NAME = "DELETE";

        /**
         * 获取方法（必须重载）
         *
         * @return
         */
        @Override
        public String getMethod() {
            return METHOD_NAME;
        }

        public HttpDeleteWithBody(final String uri) {
            super();
            setURI(URI.create(uri));
        }

        public HttpDeleteWithBody(final URI uri) {
            super();
            setURI(uri);
        }

        public HttpDeleteWithBody() {
            super();
        }

    }


}
