package top.hyizhou.aria2j.entity;

/**
 * 表下载时的不同状态
 * @author huanggc
 * @date 2022/8/26 15:14
 */
public enum StatusEnum {
    /** 在队列中等待状态 */
    waiting,
    /** 正在下载 */
    active,
    /** 暂停状态 */
    paused,
    /** 因为错误而处于停止状态 */
    error,
    /** 已停止和已完成状态 */
    complete,
    /** 删除的状态 */
    removed;

}
