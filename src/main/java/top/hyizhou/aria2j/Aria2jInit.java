package top.hyizhou.aria2j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.hyizhou.aria2j.client.Aria2;
import top.hyizhou.aria2j.client.Aria2Http;
import top.hyizhou.aria2j.config.Configuration;
import top.hyizhou.aria2j.config.Protocol;
import top.hyizhou.aria2j.send.SimpleHttp;

/**
 * @author hyizhou
 * @date 2022/8/11 16:31
 */
public class Aria2jInit {
    private static final Logger logger = LoggerFactory.getLogger(Aria2jInit.class);

    /**
     * 生成调用对象，没有秘钥，使用http连接
     * @param url rpc地址
     * @return 返回调用对象
     */
    public static Aria2 init(String url){
        return init(url, null, null);
    }

    /**
     * 生成远程调用对象
     * @param url 地址
     * @param token 秘钥
     * @param protocol 协议，如http
     * @return 返回远程调用对象
     */
    public static Aria2 init(String url, String token, Protocol protocol){
        Configuration conf = Configuration.custom().setUrl(url).setToken(token).setProtocol(protocol).build();
        SimpleHttp http = new SimpleHttp();
        return new Aria2Http(http, conf);
    }
}
