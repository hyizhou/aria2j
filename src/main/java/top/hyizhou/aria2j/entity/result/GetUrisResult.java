package top.hyizhou.aria2j.entity.result;

/**
 * getUris方法响应数组的元素
 * @author huanggc
 * @date 2022/8/23 14:23
 */
public class GetUrisResult {
    /** 下载uri */
    private String uri;
    /** 状态 */
    private String status;

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
