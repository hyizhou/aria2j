package top.hyizhou.aria2j.client;

import com.alibaba.fastjson2.util.ParameterizedTypeImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import top.hyizhou.aria2j.config.Configuration;
import top.hyizhou.aria2j.entity.OptionsEntity;
import top.hyizhou.aria2j.entity.basic.AriaRequestEntity;
import top.hyizhou.aria2j.entity.basic.RpcResponse;
import top.hyizhou.aria2j.entity.params.Method;
import top.hyizhou.aria2j.entity.result.*;
import top.hyizhou.aria2j.send.SimpleHttp;
import top.hyizhou.aria2j.util.Aria2Exception;

import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * Http rpc请求方式，此方式无法主动接收通知
 * @author hyizhou
 * @date 2022/8/12 17:54
 */
public class Aria2Http implements Aria2, Closeable {
    private final Logger log = LoggerFactory.getLogger(Aria2Http.class);
    /** http请求发起对象 */
    private final SimpleHttp http;
    /** aria2 调用地址 */
    private final String uri;
    /** 秘钥 */
    private final String token;

    public Aria2Http(SimpleHttp http, Configuration config) {
        this.http = http;
        uri = config.getUrl();
        token = Objects.nonNull(config.getToken()) ? "token:"+config.getToken() : null ;
    }

    @Override
    public String addUri(OptionsEntity options, String link){
        RpcResponse<String> response = handle(String.class, ADD_URI_METHOD, token, new String[]{link}, options);
        return response.getResult();
    }

    @Override
    public GetGlobalStatResult getGlobalStat(){
        return handle(GetGlobalStatResult.class, GET_GLOBAL_STAT_METHOD, token).getResult();
    }

    @Override
    public String addTorrent(InputStream torrent, String[] uris, OptionsEntity options) {
        // todo 文件流处理
        return null;
    }

    @Override
    public String addMetalink(InputStream metalink, OptionsEntity options) {
        // todo 文件处理
        return null;
    }

    @Override
    public String remove(String gid) {
        return handle(String.class, REMOVE, token, gid).getResult();
    }

    @Override
    public String forceRemove(String gid) {
        return handle(String.class, FORCE_REMOVE, token, gid).getResult();
    }

    @Override
    public String pause(String gid) {
        return handle(String.class, PAUSE, token, gid).getResult();
    }

    @Override
    public String pauseAll() {
        return handle(String.class, PAUSE_ALL, token).getResult();
    }

    @Override
    public String forcePause(String gid) {
        return handle(String.class, FORCE_PAUSE, token, gid).getResult();
    }

    @Override
    public String forcePauseAll() {
        return handle(String.class, FORCE_PAUSE_ALL, token).getResult();
    }

    @Override
    public String unpause(String gid) {
        return handle(String.class, UNPAUSE, token, gid).getResult();
    }

    @Override
    public String unpauseAll() {
        return handle(String.class, UNPAUSE_ALL, token).getResult();
    }

    @Override
    public TellStatusResult tellStatus(String gid, String[] keys) {
        return handle(TellStatusResult.class, TELL_STATUS_METHOD, token, gid, keys).getResult();
    }

    @Override
    public List<GetUrisResult> getUris(String gid) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{GetUrisResult.class}, null, List.class);
        RpcResponse<List<GetUrisResult>> response = handle(type, GET_URIS, token, gid);
        return response.getResult();
    }

    @Override
    public List<GetFilesResult> getFiles(String gid) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{GetFilesResult.class}, null, List.class);
        RpcResponse<List<GetFilesResult>> response = handle(type, GET_FILES, token, gid);
        return response.getResult();
    }

    @Override
    public List<GetPeersResult> getPeers(String gid) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{GetPeersResult.class}, null, List.class);
        RpcResponse<List<GetPeersResult>> response = handle(type, GET_PEERS, token, gid);
        return response.getResult();
    }

    @Override
    public List<GetServersResult> getServers(String gid) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{GetServersResult.class}, null, List.class);
        RpcResponse<List<GetServersResult>> response = handle(type, GET_SERVERS, token, gid);
        return response.getResult();
    }

    @Override
    public List<TellStatusResult> tellActive(String[] keys) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{TellStatusResult.class}, null, List.class);
        RpcResponse<List<TellStatusResult>> response = handle(type, TELL_ACTIVE, token, keys);
        return response.getResult();
    }

    @Override
    public List<TellStatusResult> tellWaiting(int offset, int num, String[] keys) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{TellStatusResult.class}, null, List.class);
        RpcResponse<List<TellStatusResult>> response = handle(type, TELL_WAITING, token, offset, num, keys);
        return response.getResult();
    }

    @Override
    public List<TellStatusResult> tellStopped(int offset, int num, String[] keys) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{TellStatusResult.class}, null, List.class);
        RpcResponse<List<TellStatusResult>> response = handle(type, TELL_STOPPED, token, offset, num, keys);
        return response.getResult();
    }

    @Override
    public Integer changePosition(String gid, int pos, How how) {
        RpcResponse<Integer> response = handle(Integer.class, CHANGE_POSITION, token, gid, pos, how.name);
        return response.getResult();
    }

    @Override
    public Map<String, Object> getOption(String gid) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{String.class, Object.class}, null, Map.class);
        RpcResponse<Map<String, Object>> response = handle(type, GET_OPTION, token, gid);
        return response.getResult();
    }

    @Override
    public String changeOption(String gid, OptionsEntity options) {
        RpcResponse<String> response = handle(String.class, CHANGE_OPTION, token, gid, options);
        return response.getResult();
    }

    @Override
    public Map<String, Object> getGlobalOption() {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{String.class, Object.class}, null, Map.class);
        RpcResponse<Map<String, Object>> response = handle(type, GET_GLOBAL_OPTION, token);
        return response.getResult();
    }

    @Override
    public String changeGlobalOption(OptionsEntity options) {
        return handle(String.class, CHANGE_GLOBAL_OPTION, token, options).getResult();
    }

    @Override
    public String purgeDownloadResult() {
        RpcResponse<String> response = handle(String.class, PURGE_DOWNLOAD_RESULT, token);
        return response.getResult();
    }

    @Override
    public String removeDownloadResult(String gid) {
        RpcResponse<String> response = handle(String.class, REMOVE_DOWNLOAD_RESULT, token, gid);
        return response.getResult();
    }

    @Override
    public GetVersionResult getVersion() {
        return handle(GetVersionResult.class, GET_VERSION, token).getResult();
    }

    @Override
    public GetSessionInfoResult getSessionInfo() {
        return handle(GetSessionInfoResult.class, GET_SESSION_INFO, token).getResult();
    }

    @Override
    public String shutdown() {
        return handle(String.class, SHUTDOWN, token).getResult();
    }

    @Override
    public String forceShutdown() {
        return handle(String.class, FORCE_SHUTDOWN, token).getResult();
    }

    @Override
    public String saveSession() {
        return handle(String.class, SAVE_SESSION, token).getResult();
    }

    @Override
    public List<Object> multicall(List<Method> methods) {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{Object.class}, null, List.class);
        // 不需要传入token，由子方法中填入
        RpcResponse<List<Object>> handle = handle(type, MULTICALL_METHOD, methods);
        return handle.getResult();
    }

    @Override
    public List<String> listMethods() {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{String.class}, null, List.class);
        RpcResponse<List<String>> handle = handle(type, LIST_METHODS);
        return handle.getResult();
    }

    @Override
    public List<String> listNotifications() {
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{String.class}, null, List.class);
        RpcResponse<List<String>> response = handle(type, LIST_NOTIFICATION);
        return response.getResult();
    }

    /**
     * 请求流程的封装
     * @param clazz 响应结果类型
     * @param method 方法名
     * @param params 参数列表
     * @param <T> 响应结果类型
     * @return rpc响应报文json封装
     */
    private <T> RpcResponse<T> handle(Class<T> clazz, String method, Object... params){
        ParameterizedTypeImpl type = new ParameterizedTypeImpl(new Type[]{}, null, clazz);
        return handle(type, method, params);
    }

    /**
     * 远程调用流程的封装，当使用到泛型时，请使用本方法
     * @param type 响应结果类型的包装类型
     * @param method 调用方法
     * @param params 参数们
     * @param <T> 对应type包装的类型
     * @return 响应报文反序列化成的实体类
     */
    private <T> RpcResponse<T> handle(ParameterizedTypeImpl type, String method, Object... params){
        AriaRequestEntity entity = AriaRequestEntity.create(method, params);
        RpcResponse<T> resp;
        try {
            resp = http.post(uri, entity, type);
        } catch (IOException e) {
            throw new Aria2Exception(e);
        }
        // 若响应了错误信息，弹出错误提示报文
        if (resp.getError() != null){
            throw new Aria2Exception("["+method + "]调用失败 -- 提示信息："+resp.getError().toString());
        }else if (resp.getResult() != null){
            return resp;
        }else {
            throw new Aria2Exception("["+method + "]响应异常 -- 响应中不存在结果信息也不存在异常提示");
        }
    }


    /**
     * 关闭连接客户端
     * @throws IOException 发生io错误
     */
    @Override
    public void close() throws IOException {
        http.close();
    }
}
