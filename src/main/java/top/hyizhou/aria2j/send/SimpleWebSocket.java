package top.hyizhou.aria2j.send;

import org.java_websocket.client.WebSocketClient;
import org.java_websocket.handshake.ServerHandshake;
import top.hyizhou.aria2j.client.Notifications;

import java.net.URI;

/**
 * webSocket客户端的简单实现
 * @author huanggc
 * @date 2022/9/15 15:16
 */
public class SimpleWebSocket {
    /** 通知 */
    private Notifications notifications;
    private class Client extends WebSocketClient {
        public Client(URI serverUri) {
            super(serverUri);
        }

        @Override
        public void onOpen(ServerHandshake handshakedata) {
        }

        @Override
        public void onMessage(String message) {

        }

        @Override
        public void onClose(int code, String reason, boolean remote) {

        }

        @Override
        public void onError(Exception ex) {

        }
    }

    public SimpleWebSocket(Notifications notifications){
        this.notifications = notifications;
    }

    public SimpleWebSocket(){}
}
