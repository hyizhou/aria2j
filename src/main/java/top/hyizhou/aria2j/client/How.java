package top.hyizhou.aria2j.client;

/**
 * 用于某些方法中表示相对位置
 * @author huanggc
 * @date 2022/8/25 14:25
 */
public enum How {
    /** 分别表示开头，当前位置和末尾 */
    POS_SET("POS_SET"),
    POS_CUR("POS_CUR"),
    POS_END("POS_END");

    How(String name){
        this.name = name;
    }
    public final String name;
}
