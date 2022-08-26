package top.hyizhou.aria2j.entity.result;

/**
 * 获取全局状态(getGlobalStat)的响应
 * @author hyizhou
 * @date 2022/8/12 17:29
 */
public class GetGlobalStatResult {
    /** 活动下载数 */
    private String numActive;
    /** 等待下载数 */
    private String numWaiting;
    /** 总体下载速度，字节/秒 */
    private String downloadSpeed;
    /** 总体上传速度，字节/秒 */
    private String uploadSpeed;
    /** 停止下载数 */
    private String numStopped;
    /** 停止下载数，不受--max-download-result（内存中保存最大结果数）参数影响 */
    private String numStoppedTotal;

    public String getNumActive() {
        return numActive;
    }

    public void setNumActive(String numActive) {
        this.numActive = numActive;
    }

    public String getNumWaiting() {
        return numWaiting;
    }

    public void setNumWaiting(String numWaiting) {
        this.numWaiting = numWaiting;
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

    public String getNumStopped() {
        return numStopped;
    }

    public void setNumStopped(String numStopped) {
        this.numStopped = numStopped;
    }

    public String getNumStoppedTotal() {
        return numStoppedTotal;
    }

    public void setNumStoppedTotal(String numStoppedTotal) {
        this.numStoppedTotal = numStoppedTotal;
    }

    @Override
    public String toString() {
        return "GetGlobalStatResult{" +
                "numActive='" + numActive + '\'' +
                ", numWaiting='" + numWaiting + '\'' +
                ", downloadSpeed='" + downloadSpeed + '\'' +
                ", uploadSpeed='" + uploadSpeed + '\'' +
                ", numStopped='" + numStopped + '\'' +
                ", numStoppedTotal='" + numStoppedTotal + '\'' +
                '}';
    }
}
