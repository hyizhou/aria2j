package top.hyizhou.aria2j.util;

/**
 * 表示调用aria2产生的错误，如调用时响应了异常。
 * 注：连接中断、请求失败等网络错误也包含在里面以便处理
 * @author huanggc
 * @date 2022/8/23 16:16
 */
public class Aria2Exception extends RuntimeException{
    public Aria2Exception(String msg) {
        super(msg);
    }

    public Aria2Exception(Throwable e){
        super(e);
    }
}
