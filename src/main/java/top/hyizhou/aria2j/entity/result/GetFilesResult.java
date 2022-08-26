package top.hyizhou.aria2j.entity.result;

import java.util.List;

/**
 * getFiles方法响应数组的元素
 * @author huanggc
 * @date 2022/8/23 14:28
 */
public class GetFilesResult {
    private String index;
    private String length;
    private String path;
    /** 已完成长度 */
    private String completedLength;
    /** 未指定--select-file，或单文件种子下载或者不是种子下载时为true */
    private Boolean selected;
    private List<GetUrisResult> uris;

    public String getIndex() {
        return index;
    }

    public void setIndex(String index) {
        this.index = index;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getCompletedLength() {
        return completedLength;
    }

    public void setCompletedLength(String completedLength) {
        this.completedLength = completedLength;
    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public List<GetUrisResult> getUris() {
        return uris;
    }

    public void setUris(List<GetUrisResult> uris) {
        this.uris = uris;
    }
}
