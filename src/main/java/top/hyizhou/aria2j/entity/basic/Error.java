package top.hyizhou.aria2j.entity.basic;

import com.alibaba.fastjson2.JSONObject;

/**
 * 错误响应时返回的参数
 * @author hyizhou
 * @date 2022/8/12 10:55
 */
public class Error {
    /** 错误码 */
    private Integer code;
    /** 错误描述 */
    private String message;
    /** 附加数据 */
    private Object data;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    @Override
    public String toString(){
        return JSONObject.toJSONString(this);
    }
}
