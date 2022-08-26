package top.hyizhou.aria2j.send;

/**
 * 简单响应对象
 * @author hyizhou
 * @date 2022/8/16 16:38
 */
public class SimpleHttpResp {
    /** 响应码， 可以在{@link org.apache.http.HttpStatus}中查看 */
    private Integer code;
    /** 报文体 */
    private String body;

    public SimpleHttpResp(Integer code, String body) {
        this.code = code;
        this.body = body;
    }

    public Integer getCode() {
        return code;
    }

    public String getBody() {
        return body;
    }

}
