package com.pk.cryptonotifier.connection.websocket;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
public class KuCoinSocketHandler extends TextWebSocketHandler {

    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        /*for (WebSocketSession webSocketSession : sessions) {
            //Map value = new Gson().fromJson(message.getPayload(), Map.class);


        }*/


        String payload = message.getPayload();
        session.sendMessage(new TextMessage("Hello " + payload + " !"));
    }


}
