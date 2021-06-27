package com.guanting.common.utils;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Base64;



public class HttpUtils {
    private Logger log = Logger.getLogger(this.getClass());

    private RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(60000)
            .setConnectTimeout(15000)
            .setConnectionRequestTimeout(15000)
            .build();

    public String sendHttpGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);
            response.addHeader("Content-Type", "application/json;charset=utf-8");
            response.addHeader("Accept", "application/json");


            entity = response.getEntity();

            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e, e);
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e, e);
            }
        }
        return responseContent;
    }


    public boolean sendHttpGetOut(String httpUrl, OutputStream outputStream) {
        HttpGet httpGet = new HttpGet(httpUrl);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);
            entity = response.getEntity();

            InputStream inputStream = entity.getContent();
            int ch;
            while ((ch = inputStream.read()) != -1) {
                outputStream.write(ch);
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error(e, e);
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error(e, e);
            }
        }
        return true;
    }


    public String sendHttpPost(String httpUrl, String param1) {
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
        // 创建参数队列
        StringEntity stringEntity = null;
        try {
            stringEntity = new StringEntity(param1);
        } catch (UnsupportedEncodingException e) {
            log.error(e, e);
            e.printStackTrace();
        }

        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity;
        String responseContent = null;
        try {
            httpPost.setEntity(stringEntity);
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(requestConfig);
            httpPost.setHeader("Content-Type", "text/xml");
            httpPost.setHeader("SOAPAction", "");
            // 执行请求
            response = httpClient.execute(httpPost);
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            log.error(e, e);
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                log.error(e, e);
                e.printStackTrace();
            }
        }
        return responseContent;
    }


    /**
     * 从OSS中获取图片，并将图片转为byte64
     * @param path 图片路径
     * @return
     */
    public String getPhotoFromOSSToByte64(String path) {
        String byte64String = "";
        HttpGet httpGet = new HttpGet(path);
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);
            entity = response.getEntity();
            InputStream inputStream = entity.getContent();
            byte[] bytes = IOUtils.toByteArray(inputStream);
            Base64.Encoder encoder = Base64.getEncoder();
            byte64String = encoder.encodeToString(bytes);
            if(inputStream != null){
                inputStream.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取图片转为byte64异常", e);
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
                log.error("关闭httpClient异常", e);
            }
        }
        return byte64String;
    }

}
