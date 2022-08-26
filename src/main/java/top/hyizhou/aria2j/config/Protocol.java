package top.hyizhou.aria2j.config;

/**
 * 远程调用协议
 * @author hyizhou
 * @date 2022/8/11 17:07
 */
public enum Protocol {
    /** http协议或webSocket等协议 */
    http("http"),https("https") , webSocket("ws"), websockets("wss");

    /** 协议头 */
    private final String header;

    Protocol(String header){
        this.header = header;
    }

    public String getHeader(){
        return this.header;
    }
}
