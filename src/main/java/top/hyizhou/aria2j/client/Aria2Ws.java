package top.hyizhou.aria2j.client;

import com.alibaba.fastjson2.util.ParameterizedTypeImpl;
import top.hyizhou.aria2j.config.Configuration;
import top.hyizhou.aria2j.entity.How;
import top.hyizhou.aria2j.entity.OptionsEntity;
import top.hyizhou.aria2j.entity.basic.RpcResponse;
import top.hyizhou.aria2j.entity.params.Method;
import top.hyizhou.aria2j.entity.result.*;
import top.hyizhou.aria2j.send.SimpleWebSocket;

import java.io.InputStream;
import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * webSocket方式的远程调用
 * @author huanggc
 * @date 2022/9/15 16:24
 */
public class Aria2Ws implements Aria2{

    /** 秘钥 */
    private final String token;
    /** websocket客户端 */
    private SimpleWebSocket client;

    public Aria2Ws(SimpleWebSocket client, Configuration config){
        this.client = client;
        this.token = Objects.nonNull(config.getToken()) ? "token:"+config.getToken() : null ;
    }

    private <T> RpcResponse<T> handle(ParameterizedTypeImpl type, String method, Object... params){
        return null;
    }

    @Override
    public String addUri(OptionsEntity options, String link) {
        return null;
    }

    @Override
    public GetGlobalStatResult getGlobalStat() {
        return null;
    }

    @Override
    public String addTorrent(InputStream torrent, String[] uris, OptionsEntity options) {
        return null;
    }

    @Override
    public String addMetalink(InputStream metalink, OptionsEntity options) {
        return null;
    }

    @Override
    public String remove(String gid) {
        return null;
    }

    @Override
    public String forceRemove(String gid) {
        return null;
    }

    @Override
    public String pause(String gid) {
        return null;
    }

    @Override
    public String pauseAll() {
        return null;
    }

    @Override
    public String forcePause(String gid) {
        return null;
    }

    @Override
    public String forcePauseAll() {
        return null;
    }

    @Override
    public String unpause(String gid) {
        return null;
    }

    @Override
    public String unpauseAll() {
        return null;
    }

    @Override
    public TellStatusResult tellStatus(String gid, String[] keys) {
        return null;
    }

    @Override
    public List<GetUrisResult> getUris(String gid) {
        return null;
    }

    @Override
    public List<GetFilesResult> getFiles(String gid) {
        return null;
    }

    @Override
    public List<GetPeersResult> getPeers(String gid) {
        return null;
    }

    @Override
    public List<GetServersResult> getServers(String gid) {
        return null;
    }

    @Override
    public List<TellStatusResult> tellActive(String[] keys) {
        return null;
    }

    @Override
    public List<TellStatusResult> tellWaiting(int offset, int num, String[] keys) {
        return null;
    }

    @Override
    public List<TellStatusResult> tellStopped(int offset, int num, String[] keys) {
        return null;
    }

    @Override
    public Integer changePosition(String gid, int pos, How how) {
        return null;
    }

    @Override
    public Map<String, Object> getOption(String gid) {
        return null;
    }

    @Override
    public String changeOption(String gid, OptionsEntity options) {
        return null;
    }

    @Override
    public Map<String, Object> getGlobalOption() {
        return null;
    }

    @Override
    public String changeGlobalOption(OptionsEntity options) {
        return null;
    }

    @Override
    public String purgeDownloadResult() {
        return null;
    }

    @Override
    public String removeDownloadResult(String gid) {
        return null;
    }

    @Override
    public GetVersionResult getVersion() {
        return null;
    }

    @Override
    public GetSessionInfoResult getSessionInfo() {
        return null;
    }

    @Override
    public String shutdown() {
        return null;
    }

    @Override
    public String forceShutdown() {
        return null;
    }

    @Override
    public String saveSession() {
        return null;
    }

    @Override
    public List<Object> multicall(List<Method> methods) {
        return null;
    }

    @Override
    public List<String> listMethods() {
        return null;
    }

    @Override
    public List<String> listNotifications() {
        return null;
    }
}
