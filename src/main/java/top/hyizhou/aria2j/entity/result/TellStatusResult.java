package top.hyizhou.aria2j.entity.result;

import java.util.List;

/**
 * 表示下载状态
 * @author huanggc
 * @date 2022/8/22 16:25
 */
public class TellStatusResult {
    private String gid;
    /** 当前状态，有：waiting、paused、error、complete、removed */
    private String status;
    /** 总长度，字节bytes为单位，下同 */
    private String totalLength;
    /** 下载长度 */
    private String completedLength;
    /** 上传的长度 */
    private String uploadLength;
    /** 下载区块进度的十六进制表示形式 */
    private String bitfield;
    /** 下载速度，字节/秒，下同 */
    private String downloadSpeed;
    /** 上传速度 */
    private String uploadSpeed;
    /** 哈希信息，仅限bitTorrent */
    private String infoHash;
    /** seeder连接数，仅限bitTorrent */
    private String numSeeders;
    /** 如果本地端点是seeder（大概意思就是本地在做种吧）,仅限bitTorrent */
    private Boolean seeder;
    /** 片长度 */
    private String pieceLength;
    /** 片数 */
    private String numPieces;
    /** 连接到的节点/服务器的数量 */
    private String connections;
    /** 此项最后一个错误代码，仅适用于已经停止或完成的下载 */
    private String errorCode;
    /** 错误消息 */
    private String errorMessage;
    /** 作为此下载结果的gid列表，如磁力会生成多个下载 */
    private String[] followedBy;
    /** 反向链接，会有如下选项：followedBy，followedBy，following */
    private String following;
    /** 父级下载的gid */
    private String belongsTo;
    /** 保存文件的目录 */
    private String dir;
    /** 文件列表， 结构与 getFiles方法 相同 */
    private List<GetFilesResult> files;
    /** 从.torrent（文件）检索到的信息的结构， 仅限BitTorrent */
    private Bittorrent bittorrent;
    /** 对文件进行哈希检查时已验证的字节数，仅当对此下载进行哈希检查时，此项才存在*/
    private String verifiedLength;
    /** 是否等待队列中的哈希检查，仅当对此下载进行哈希检查时，此项才存在*/
    private Boolean verifyIntegrityPending;

    static class Bittorrent{
        /** bt服务器列表*/
        private String[] announceList;
        /** 评论 */
        private String comment;
        /** 创建时间 */
        private String creationDate;
        /** 种子文件模式 */
        private String mode;
        /** 包含信息字典中的数据的结构 */
        private Object info;

        public String[] getAnnounceList() {
            return announceList;
        }

        public void setAnnounceList(String[] announceList) {
            this.announceList = announceList;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(String creationDate) {
            this.creationDate = creationDate;
        }

        public String getMode() {
            return mode;
        }

        public void setMode(String mode) {
            this.mode = mode;
        }

        public Object getInfo() {
            return info;
        }

        public void setInfo(Object info) {
            this.info = info;
        }
    }

    public String getGid() {
        return gid;
    }

    public void setGid(String gid) {
        this.gid = gid;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTotalLength() {
        return totalLength;
    }

    public void setTotalLength(String totalLength) {
        this.totalLength = totalLength;
    }

    public String getCompletedLength() {
        return completedLength;
    }

    public void setCompletedLength(String completedLength) {
        this.completedLength = completedLength;
    }

    public String getUploadLength() {
        return uploadLength;
    }

    public void setUploadLength(String uploadLength) {
        this.uploadLength = uploadLength;
    }

    public String getBitfield() {
        return bitfield;
    }

    public void setBitfield(String bitfield) {
        this.bitfield = bitfield;
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

    public String getInfoHash() {
        return infoHash;
    }

    public void setInfoHash(String infoHash) {
        this.infoHash = infoHash;
    }

    public String getNumSeeders() {
        return numSeeders;
    }

    public void setNumSeeders(String numSeeders) {
        this.numSeeders = numSeeders;
    }

    public Boolean getSeeder() {
        return seeder;
    }

    public void setSeeder(Boolean seeder) {
        this.seeder = seeder;
    }

    public String getPieceLength() {
        return pieceLength;
    }

    public void setPieceLength(String pieceLength) {
        this.pieceLength = pieceLength;
    }

    public String getNumPieces() {
        return numPieces;
    }

    public void setNumPieces(String numPieces) {
        this.numPieces = numPieces;
    }

    public String getConnections() {
        return connections;
    }

    public void setConnections(String connections) {
        this.connections = connections;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String[] getFollowedBy() {
        return followedBy;
    }

    public void setFollowedBy(String[] followedBy) {
        this.followedBy = followedBy;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getBelongsTo() {
        return belongsTo;
    }

    public void setBelongsTo(String belongsTo) {
        this.belongsTo = belongsTo;
    }

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public List<GetFilesResult> getFiles() {
        return files;
    }

    public void setFiles(List<GetFilesResult> files) {
        this.files = files;
    }

    public Bittorrent getBittorrent() {
        return bittorrent;
    }

    public void setBittorrent(Bittorrent bittorrent) {
        this.bittorrent = bittorrent;
    }

    public String getVerifiedLength() {
        return verifiedLength;
    }

    public void setVerifiedLength(String verifiedLength) {
        this.verifiedLength = verifiedLength;
    }

    public Boolean getVerifyIntegrityPending() {
        return verifyIntegrityPending;
    }

    public void setVerifyIntegrityPending(Boolean verifyIntegrityPending) {
        this.verifyIntegrityPending = verifyIntegrityPending;
    }
}

