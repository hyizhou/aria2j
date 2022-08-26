package top.hyizhou.aria2j.entity.basic;


import java.io.Serializable;

/**
 * rpc 调用方法响应的报文
 * @author hyizhou
 * @date 2022/8/12 10:43
 */
public class RpcResponse<T> implements Serializable {

    /** json-rpc版本，一般固定为 2.0 */
    private String jsonrpc;
    /** 唯一标识符 */
    private String id;
    /** 响应值，失败时不出现 */
    private T result;
    /** 失败值，成功时不出现 */
    private Error error;

    public String getJsonrpc() {
        return jsonrpc;
    }

    public void setJsonrpc(String jsonrpc) {
        this.jsonrpc = jsonrpc;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public T getResult() {
        return result;
    }

    public void setResult(T result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "RpcResponse{" +
                "jsonrpc='" + jsonrpc + '\'' +
                ", id='" + id + '\'' +
                ", result=" + result +
                ", error=" + error +
                '}';
    }
}
