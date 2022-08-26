package top.hyizhou.aria2j.client;

import jdk.internal.util.xml.impl.Input;
import top.hyizhou.aria2j.entity.OptionsEntity;
import top.hyizhou.aria2j.entity.params.Method;
import top.hyizhou.aria2j.entity.result.*;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;

/**
 * aria2中提供的rpc调用接口
 * @author hyizhou
 * @date 2022/8/11 16:55
 */
public interface Aria2 {
    String ADD_URI_METHOD = "aria2.addUri";
    String GET_GLOBAL_STAT_METHOD = "aria2.getGlobalStat";
    String MULTICALL_METHOD = "system.multicall";
    String LIST_METHODS = "system.listMethods";
    String TELL_STATUS_METHOD = "aria2.tellStatus";
    String ADD_TORRENT = "aria2.addTorrent";
    String ADD_METALINK = "aria2.addMetalink";
    String REMOVE = "aria2.remove";
    String FORCE_REMOVE = "aria2.forceRemove";
    String PAUSE = "aria2.pause";
    String PAUSE_ALL = "aria2.pauseAll";
    String FORCE_PAUSE = "aria2.forcePause";
    String FORCE_PAUSE_ALL = "aria2.forcePauseAll";
    String UNPAUSE = "aria2.unpause";
    String UNPAUSE_ALL = "aria2.unpauseAll";
    String TELL_STATUS = "aria2.tellStatus";
    String GET_URIS = "aria2.getUris";
    String GET_FILES = "aria2.getFiles";
    String GET_PEERS = "aria2.getPeers";
    String GET_SERVERS = "aria2.getServers";
    String TELL_ACTIVE = "aria2.tellActive";
    String TELL_WAITING = "aria2.tellWaiting";
    String TELL_STOPPED = "aria2.tellStopped";
    String CHANGE_POSITION = "aria2.changePosition";
    String CHANGE_URI = "aria2.changeUri";
    String GET_OPTION = "aria2.getOption";
    String CHANGE_OPTION = "aria2.changeOption";
    String GET_GLOBAL_OPTION = "aria2.getGlobalOption";
    String CHANGE_GLOBAL_OPTION = "aria2.changeGlobalOption";
    String GET_GLOBAL_STAT = "aria2.getGlobalStat";
    String PURGE_DOWNLOAD_RESULT = "aria2.purgeDownloadResult";
    String REMOVE_DOWNLOAD_RESULT = "aria2.removeDownloadResult";
    String GET_VERSION = "aria2.getVersion";
    String GET_SESSION_INFO = "aria2.getSessionInfo";
    String SHUTDOWN = "aria2.shutdown";
    String FORCE_SHUTDOWN = "aria2.forceShutdown";
    String SAVE_SESSION = "aria2.saveSession";
    String LIST_NOTIFICATION = "system.listNotifications";

    /**
     * 添加一个下载
     * @param options 设置，可为空
     * @param link 一条下载链接，绝对不能为空，若为null则会报空指针异常
     * @return 返回该下载的gid
     */
    String addUri(OptionsEntity options, String link);

    /**
     * 获取全局统计信息
     * @return 返回全局统计信息对象
     */
    GetGlobalStatResult getGlobalStat();

    /**
     * 通过上传文件形式添加BitTorrent下载
     * @param torrent .torrent文件流，不可为空
     * @param uris 用于web播种
     * @param options 设置项
     * @return 返回gid
     */
    String addTorrent(InputStream torrent, String[] uris, OptionsEntity options);

    /**
     * 通过上传.metalink文件形式添加metalink下载
     * @param metalink 文件流
     * @param options 设置项
     * @return 返回gid
     */
    String addMetalink(InputStream metalink, OptionsEntity options);

    /**
     * 删除gid表示的下载
     * @param gid 下载的标识符
     * @return 已删除下载的gid
     */
    String remove(String gid);

    /**
     * 删除gid表示的下载，相当于强制删除
     * @param gid 下载的标识符
     * @return 已删除下载的标识符
     */
    String forceRemove(String gid);

    /**
     * 暂停gid表示下载
     * @param gid 下载的标识符
     * @return 已暂停下载的gid
     */
    String pause(String gid);

    /**
     * 暂停所有的下载
     * @return 成功返回 ok
     */
    String pauseAll();

    /**
     * 强制暂停下载
     * @param gid 下载的标识符
     * @return 已暂停下载的gid
     */
    String forcePause(String gid);

    /**
     * 强制暂停所有下载
     * @return 成功返回ok
     */
    String forcePauseAll();

    /**
     * 取消暂停
     * @param gid 下载的标识符
     * @return 返回未暂停下载的gid
     */
    String unpause(String gid);

    /**
     * 取消所有的暂停
     * @return 成功返回ok
     */
    String unpauseAll();

    /**
     * 返回下载进度
     * @param gid 下载的标识符
     * @param keys 指定返回哪些数据，若不指定则返回所有内容
     * @return 响应是一个比较复杂结构，指定keys后只会返回其中指定的项
     */
    TellStatusResult tellStatus(String gid, String[] keys);

    /**
     * 返回下载的uri以及状态
     * @param gid 下载的标识符
     * @return 返回一个数组，每个元素包括下载地址和状态
     */
    List<GetUrisResult> getUris(String gid);

    /**
     * 返回该下载的文件列表
     * @param gid 下载的标识符
     * @return 返回数组
     */
    List<GetFilesResult> getFiles(String gid);

    /**
     * 返回下载的做种方，一般种子下载才用的到
     * @param gid 下载的标识符
     * @return 返回数组
     */
    List<GetPeersResult> getPeers(String gid);

    /**
     * 返回当前连接的 HTTP（S）/FTP/SFTP 服务器
     * @param gid 下载的标识符
     * @return 返回数组
     */
    List<GetServersResult> getServers(String gid);

    /**
     * 返回当前活动的下载的进度情况
     * @param keys 指定返回的项目
     * @return 返回数组，其中元素与 tellStatus 返回的结构相同
     */
    List<TellStatusResult> tellActive(String[] keys);

    /**
     * 返回当前等待的下载进度情况，包括已暂停的下载
     * @param offset 下载列表的偏移量，若是正数，则返回[offset, offset+num]范围，若是负数，则是从最后按相反的顺序，必要参数
     * @param num 返回的下载数。必须指定且大于等于0
     * @param keys 指定返回的项目
     * @return 返回数组，其中元素与 tellStatus 返回的结构相同
     */
    List<TellStatusResult> tellWaiting(int offset, int num, String[] keys);

    /**
     * 返回以停止的下载列表情况，参数与返回部分与 tellWaiting 方法相同
     * @param offset 偏移量
     * @param num 返回的下载数
     * @param keys 返回的项目
     * @return 返回数组，其中元素与 tellStatus 返回的结构相同
     */
    List<TellStatusResult> tellStopped(int offset, int num, String[] keys);

    /**
     * 更改在下载队列中的位置
     * @param gid 下载的标识符
     * @param pos 表示移动到how表示的位置某位置
     * @param how 表示按哪种方位移动，有如下参数：POS_SET（开头）、POS_CUR（当前位置）、POS_END（末尾）
     * @return 表示结果位置
     */
    Integer changePosition(String gid, int pos, How how);

//    changeUri();

    /**
     * 返回该下载的下载选项
     * @param gid 下载的标识符
     * @return 选项们
     */
    Map<String, Object> getOption(String gid);

    /**
     * 更改下载选项
     * @param gid 下载的表示符
     * @param options 新选项
     * @return 成功返回“ok”
     */
    String changeOption(String gid, OptionsEntity options);

    /**
     * 获取全局选项，一般用来作为设置新选项的模板
     * @return 选项们
     */
    Map<String, Object> getGlobalOption();

    /**
     * 更改全局下载选项
     * @see <a href="https://aria2.github.io/manual/en/html/aria2c.html#aria2.changeGlobalOption">...</a>
     * @param options 新选项
     * @return 成功返回"ok"
     */
    String changeGlobalOption(OptionsEntity options);

    /**
     * 将已完成、错误、已删除的下载清除
     * @return 成功返回"ok"
     */
    String purgeDownloadResult();

    /**
     * 删除gid表示的下载
     * @param gid 下载标识符
     * @return 成功返回ok字符
     */
    String removeDownloadResult(String gid);

    /**
     * 获取版本号以及功能列表
     * @return 包括版本号可功能列表，功能列表使用字符串展示
     */
    GetVersionResult getVersion();

    /**
     * 获取会话信息
     * @return 会话信息，只包含一个值：会话id
     */
    GetSessionInfoResult getSessionInfo();

    /**
     * 关闭aria2
     * @return 成功返回ok字符
     */
    String shutdown();

    /**
     * 强制关闭aira2
     * @return 成功返回ok字符
     */
    String forceShutdown();

    /**
     * 保存会话
     * @return 成功返回ok字符
     */
    String saveSession();

    /**
     * 一次调用多个方法，秘钥token放在子方法中
     * @see <a href="https://aria2.github.io/manual/en/html/aria2c.html#system.multicall"/>
     * @param methods 方法列表以及其参数
     * @return 每个方法的结果对应列表中的一个元素，该元素虽然在此处写的是Obj，但其实其具体类型也为List（反序列化后
     *         为com.alibaba.fastjson2.JSONArray）
     */
    List<Object> multicall(List<Method> methods);

    /**
     * 此方法不需要秘钥令牌，返回所有rpc方法名称
     * @return rpc调用方法列表
     */
    List<String> listMethods();

    /**
     * 返回所有可用的rpc通知名称
     * @return rpc通知列表
     */
    List<String> listNotifications();
}
