package top.hyizhou.aria2j.send;

import com.alibaba.fastjson2.JSONObject;
import com.alibaba.fastjson2.TypeReference;
import com.alibaba.fastjson2.util.ParameterizedTypeImpl;
import org.apache.commons.codec.binary.StringUtils;
import org.apache.http.*;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicHeader;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.hyizhou.aria2j.entity.basic.AriaRequestEntity;
import top.hyizhou.aria2j.entity.basic.RpcResponse;
import top.hyizhou.aria2j.entity.result.GetGlobalStatResult;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

/**
 * 简单封装的http请求工具，使用close方法将释放资源，若再使用需要重新创建对象
 * @author hyizhou
 * @date 2022/8/16 11:53
 */
public class SimpleHttp implements Closeable {
    private final Logger log = LoggerFactory.getLogger(SimpleHttp.class);
    /** http客户端 */
    private final CloseableHttpClient httpClient;
    /** 代理，仅仅方便调试的 */
    private HttpHost proxy;
    /** 发送json所需的请求头 */
    private final Header JSON_CONTENT_TYPE;

    public SimpleHttp() {
        this.httpClient = HttpClients.createDefault();
//        ContentType.APPLICATION_JSON
        JSON_CONTENT_TYPE = new BasicHeader("Content-Type", "application/json");
    }

    public SimpleHttp(String uri, int port){
        this();
        this.proxy = new HttpHost(uri, port);

    }

    /**
     * 通过post发送json请求，响应正文也将使用utf-8编码解析为文本
     * @param url 请求地址
     * @param json json字符串
     * @return 响应对象
     * @throws IOException 连接异常或终止
     */
    @Deprecated
    public SimpleHttpResp post(String url, String json) throws IOException {
        log.debug("发起post请求 -- uri:[{}], json: {}",url, json);
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader(JSON_CONTENT_TYPE);
        // 携带json内容
        HttpEntity entity = new StringEntity(json, StandardCharsets.UTF_8);
        httpPost.setEntity(entity);
        CloseableHttpResponse response = httpClient.execute(httpPost);
        int statusCode = response.getStatusLine().getStatusCode();
        // 将响应正文转换成字符串
        String body = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        if (log.isDebugEnabled()){
            if (statusCode != HttpStatus.SC_OK){
                log.debug("响应码不为200 -- 响应码：[{}]，尝试打印出原始响应：\n{}", statusCode, body);
            }
        }
        response.close();
        return new SimpleHttpResp(statusCode, body);
    }

    /**
     * 通过post方式发送json-rpc 2.0规范请求，并通过所给type类型，将响应反序列化为对象，若响应正文不为json格式或为空将产生IO异常
     * @param url 请求地址
     * @param entity 请求实体对象
     * @param type 为了嵌套多层泛型，此处直接传入type类型，当需要简单类型时，直接传入该类型的class；若是包含泛型的类型，
     *             如list，则使用ParameterizedTypeImpl将类型进行包装
     * @param <T> RpcResponse需要的泛型，对应type参数指示的类型
     * @return 响应反序列化成的实体类
     */
    public <T> RpcResponse<T> post(String url, Object entity, Type type) throws IOException {
        HttpEntity reqEntity = new StringEntity(JSONObject.toJSONString(entity), StandardCharsets.UTF_8);
        if (reqEntity.isRepeatable()){
            log.debug("请求报文：{}",EntityUtils.toString(reqEntity));
        }
        HttpPost post = new HttpPost(url);
        setProxy(post);
        post.setHeader(JSON_CONTENT_TYPE);
        post.setEntity(reqEntity);
        // 自定义响应处理方法
        return httpClient.execute(post, x -> {
            // 若响应不为ok，则将响应码打印在日志方便排查异常
            if (x.getStatusLine().getStatusCode() != HttpStatus.SC_OK){
                log.info("响应码未返回成功 -- 响应码:{}", x.getStatusLine().getStatusCode());
            }
            HttpEntity httpEntity = x.getEntity();
            // 正常响应和大部分异常响应都是有报文实体的，但是要防止少部分的没有
            if (Objects.isNull(httpEntity)){
                throw new IOException("无报文实体 -- 响应码："+x.getStatusLine().getStatusCode());
            }
            String body = EntityUtils.toString(httpEntity, StandardCharsets.UTF_8);
            // 若为空会导致后续做json反序列化返回null
            if ("".equals(body.trim())){
                throw new IOException("响应正文为空 -- 响应码："+x.getStatusLine().getStatusCode());
            }
            log.debug("响应报文：\n{}", body);
            // 避免泛型擦除
            Type parameterizedType = new ParameterizedTypeImpl(new Type[]{type}, null, RpcResponse.class);
            return JSONObject.parseObject(body, parameterizedType);
        });
    }

    /**
     * TODO 通过post发送文件，文件以流的形式作为参数提供
     * @param uri 地址
     * @param in 文件流
     * @return 响应对象
     */
    public SimpleHttpResp postFile(String uri, InputStream in){
        return null;
    }

    @Override
    public void close() throws IOException {
        httpClient.close();
    }

    /**
     * 若存在代理配置的话，则为请求添加代理
     * @param req 请求，如HttpPost
     */
    private void setProxy(HttpRequestBase req){
        if (Objects.isNull(this.proxy)){
            return;
        }
        RequestConfig build = RequestConfig.custom().setProxy(this.proxy).build();
        req.setConfig(build);
    }



}
