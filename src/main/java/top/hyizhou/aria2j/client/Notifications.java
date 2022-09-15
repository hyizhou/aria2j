package top.hyizhou.aria2j.client;

/**
 * RPC通知处理的接口，若使用到通知功能需要实现本接口，来对通知进行处理
 * @author huanggc
 * @date 2022/9/15 15:26
 */
public interface Notifications {
    /**
     * 此通知将在开始下载时发送
     * @param gid 下载的唯一标识符
     */
    void onDownloadStart(String gid);

    /**
     * 此通知在下载暂停时发送
     * @param gid 下载的唯一标识符
     */
    void onDownloadPause(String gid);

    /**
     * 用户停止下载时发送此通知
     * @param gid 下载的唯一标识符
     */
    void onDownloadStop(String gid);

    /**
     * 下载完成后发送此通知
     * @param gid 下载的唯一标识符
     */
    void onDownloadComplete(String gid);

    /**
     * 下载因错误而停止时，发送此通知
     * @param gid 下载的唯一标识符
     */
    void onDownloadError(String gid);

    /**
     * 当种子下载完成但种子设定仍在进行时，将发送此通知
     * @param gid 下载的唯一标识符
     */
    void onBtDownloadComplete(String gid);
}
