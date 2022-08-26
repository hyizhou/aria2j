package top.hyizhou.aria2j.entity.result;

/**
 * getServers响应数组的元素
 * @author huanggc
 * @date 2022/8/23 14:52
 */
public class GetServersResult {
    private String index;
    private Server servers;

    static class Server{
        /** 原始uri */
        private String uri;
        /** 当前用于下载的uri */
        private String currentUri;
        /** 下载速度 */
        private String downloadSpeed;
    }

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public Server getServers() {
        return servers;
    }

    public void setServers(Server servers) {
        this.servers = servers;
    }
}
