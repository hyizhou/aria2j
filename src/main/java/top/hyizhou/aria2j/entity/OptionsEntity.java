package top.hyizhou.aria2j.entity;

import com.alibaba.fastjson2.annotation.JSONField;

/**
 * 下载时能提供一些选项以控制下载行为，如下载位置，文件重命名等
 * @author hyizhou
 * @date 2022/8/12 10:25
 */
public class OptionsEntity {
    /** 下载目录路径 */
    private String dir;
    /** 下载文件重命名 */
    private String out;
    /** 最大下载速度，字节每秒，也可以指定单位，如1K、1M */
    @JSONField(name = "max-download-limit")
    private String maxDownloadLimit;

    public String getDir() {
        return dir;
    }

    public void setDir(String dir) {
        this.dir = dir;
    }

    public String getOut() {
        return out;
    }

    public void setOut(String out) {
        this.out = out;
    }

    public String getMaxDownloadLimit() {
        return maxDownloadLimit;
    }

    public void setMaxDownloadLimit(String maxDownloadLimit) {
        this.maxDownloadLimit = maxDownloadLimit;
    }
}
