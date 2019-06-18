package com.alipayjf.game.util;

import android.util.Log;

import com.alipayjf.game.base.MessageEvent;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketAdapter;
import com.neovisionaries.ws.client.WebSocketException;
import com.neovisionaries.ws.client.WebSocketFrame;

import org.greenrobot.eventbus.EventBus;

import java.util.List;
import java.util.Map;

public class WsListener extends WebSocketAdapter {
    @Override
    public void onTextMessage(WebSocket websocket, String text) throws Exception {
        super.onTextMessage(websocket, text);
        Log.e("cdj","==是否收到消息==="+text);
        String[] msgs = text.split("\\|");
        EventBus.getDefault().postSticky(new MessageEvent(null));
    }

    @Override
    public void onConnected(WebSocket websocket, Map<String, List<String>> headers)
            throws Exception {
        super.onConnected(websocket, headers);
    }

    @Override
    public void onConnectError(WebSocket websocket, WebSocketException exception)
            throws Exception {
        super.onConnectError(websocket, exception);
        Log.e("cdj","=====连接错误======="+exception.getError()+"====="+exception.getMessage());
    }

    @Override
    public void onDisconnected(WebSocket websocket, WebSocketFrame serverCloseFrame, WebSocketFrame clientCloseFrame, boolean closedByServer)
            throws Exception {
        super.onDisconnected(websocket, serverCloseFrame, clientCloseFrame, closedByServer);
        Log.e("cdj","=====连接断开=======");
    }

}
