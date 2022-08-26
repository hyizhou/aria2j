package top.hyizhou.aria2j.entity.basic;

import java.io.Serializable;

/**
 * rpc 使用 json 调用报文
 * @author hyizhou
 * @date 2022/8/11 17:49
 */
public class RpcRequest implements Serializable {
    /** json-rpc版本，一般固定为 2.0 */
    private String jsonrpc;
    /** rpc调用的方法 */
    private String method;
    /** 唯一标识符 */
    private String id;
    /** 参数 */
    private Object params;

    public String getJsonrpc(){
        return this.jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Object getParams() {
        return params;
    }

    public void setParams(Object params) {
        this.params = params;
    }

    @Override
    public String toString() {
        return "RpcRequest{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", method='" + method + '\'' +
                ", id='" + id + '\'' +
                ", params=" + params +
                '}';
    }
}
