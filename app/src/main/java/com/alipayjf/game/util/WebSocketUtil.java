package com.alipayjf.game.util;

import com.alipayjf.game.base.Constants;
import com.neovisionaries.ws.client.WebSocket;
import com.neovisionaries.ws.client.WebSocketFactory;

import java.io.IOException;

public class WebSocketUtil{

    private static WebSocketUtil wsocketUtil;
    private WebSocket ws;

    private WebSocketUtil(){}

    public static WebSocketUtil getInstance(){
        if(wsocketUtil == null){
            wsocketUtil = new WebSocketUtil();
        }
        return wsocketUtil;
    }

    /*
    * 连接websocket
    * */
    public void connection(int id){
        try {
            ws = new WebSocketFactory().createSocket(Constants.WEBSOCKET+id, 10000) //ws地址，和设置超时时间
                    .setFrameQueueSize(5)//设置帧队列最大值为5
                    .setMissingCloseFrameAllowed(false)//设置不允许服务端关闭连接却未发送关闭帧
                    .addListener(new WsListener())//添加回调监听
                    .connectAsynchronously();//异步连接
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /*
    * 判断是否连接
    * */
    public boolean isConnection(){
        if(ws == null || !ws.isOpen()){
            return false;
        }
        return true;
    }
}
