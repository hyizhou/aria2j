package top.hyizhou.aria2j;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.hyizhou.aria2j.client.Aria2;
import top.hyizhou.aria2j.client.Aria2Http;
import top.hyizhou.aria2j.client.Aria2Ws;
import top.hyizhou.aria2j.client.Notifications;
import top.hyizhou.aria2j.config.Configuration;
import top.hyizhou.aria2j.config.Protocol;
import top.hyizhou.aria2j.send.SimpleHttp;
import top.hyizhou.aria2j.send.SimpleWebSocket;

/**
 * @author hyizhou
 * @date 2022/8/11 16:31
 */
public class Aria2jInit {
    private static final Logger logger = LoggerFactory.getLogger(Aria2jInit.class);

    /**
     * 创建使用http协议的远程调用对象
     * @param url 地址
     * @param token 秘钥
     * @return 返回远程调用对象
     */
    public static Aria2 initHttp(String url, String token){
        Configuration conf = Configuration.custom().setUrl(url).setToken(token).setProtocol(Protocol.http).build();
        SimpleHttp http = new SimpleHttp();
        return new Aria2Http(http, conf);
    }

    /**
     * 创建使用WebSocket协议的远程调用对象
     * @param url 地址
     * @param token 秘钥
     * @param notifications 通知处理类，若不需要处理通知可以传入null
     * @return 返回远程调用对象
     */
    public static Aria2 initWs(String url, String token, Notifications notifications){
        Configuration conf = Configuration.custom().setUrl(url).setToken(token).setProtocol(Protocol.webSocket).build();
        SimpleWebSocket client = new SimpleWebSocket(notifications);
        return new Aria2Ws(client, conf);
    }
}
