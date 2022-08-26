package top.hyizhou.aria2j.entity.result;

/**
 * getPeers方法响应数组的元素
 * @author huanggc
 * @date 2022/8/23 14:45
 */
public class GetPeersResult {
    /** 百分比编码对等id */
    private String peerId;
    /** 对等体ip */
    private String ip;
    /** 对等体端口 */
    private String port;
    /** 对方下载区块进度 */
    private String bitfield;
    private Boolean amChoking;
    private Boolean peerChoking;
    private String downloadSpeed;
    private String uploadSpeed;
    private Boolean seeder;

    public String getPeerId() {
        return peerId;
    }

    public void setPeerId(String peerId) {
        this.peerId = peerId;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getBitfield() {
        return bitfield;
    }

    public void setBitfield(String bitfield) {
        this.bitfield = bitfield;
    }

    public Boolean getAmChoking() {
        return amChoking;
    }

    public void setAmChoking(Boolean amChoking) {
        this.amChoking = amChoking;
    }

    public Boolean getPeerChoking() {
        return peerChoking;
    }

    public void setPeerChoking(Boolean peerChoking) {
        this.peerChoking = peerChoking;
    }

    public String getDownloadSpeed() {
        return downloadSpeed;
    }

    public void setDownloadSpeed(String downloadSpeed) {
        this.downloadSpeed = downloadSpeed;
    }

    public String getUploadSpeed() {
        return uploadSpeed;
    }

    public void setUploadSpeed(String uploadSpeed) {
        this.uploadSpeed = uploadSpeed;
    }

    public Boolean getSeeder() {
        return seeder;
    }

    public void setSeeder(Boolean seeder) {
        this.seeder = seeder;
    }
}
