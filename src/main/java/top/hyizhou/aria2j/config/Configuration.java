package top.hyizhou.aria2j.config;

import com.sun.xml.internal.ws.developer.HttpConfigFeature;
import org.apache.http.HttpConnection;
import org.apache.http.client.config.RequestConfig;

import java.net.URL;
import java.util.Objects;

/**
 * 配置类
 * @author hyizhou
 * @date 2022/8/11 17:05
 */
public class Configuration {
    /** 调用ip地址或域名，如：http://1.12.11.111:8080/jsonrpc，也可不加协议，后续会通过protocol参数来自动添加协议头 */
    private String url;

    /** 秘钥 */
    private String token;

    /** 远程调用使用的协议*/
    private Protocol protocol;

    public void setUrl(String url) {
        this.url = url;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Protocol getProtocol() {
        return protocol;
    }

    public void setProtocol(Protocol protocol) {
        this.protocol = protocol;
    }

    /**
     * 若不带协议，会自动添加，如：1.2.3.4:8080/jsonrpc -> http://1.2.3.4:8080/jsonrpc
     */
    public String getUrl(){
        String delimiter = "://";
        if (Objects.nonNull(url) && !url.contains(delimiter)) {
            return protocol.getHeader() + delimiter + this.url;
        }
        return url;
    }

    public static Builder custom(){
        return new Builder();
    }

    public static class Builder{
        private String url;
        private String token;
        private Protocol protocol;

        public Builder setProtocol(Protocol protocol) {
            this.protocol = protocol;
            return this;
        }

        public Builder setUrl(String url) {
            this.url = url;
            return this;
        }

        public Builder setToken(String token) {
            this.token = token;
            return this;
        }

        public Configuration build(){
            Configuration conf = new Configuration();
            conf.setUrl(this.url);
            conf.setToken(this.token);
            conf.setProtocol(this.protocol);
            return conf;
        }
    }
}
