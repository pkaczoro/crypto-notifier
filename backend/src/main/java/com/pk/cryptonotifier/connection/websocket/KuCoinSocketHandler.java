package com.pk.cryptonotifier.connection.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
import org.springframework.messaging.simp.stomp.StompSessionHandler;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.client.WebSocketClient;
import org.springframework.web.socket.client.standard.StandardWebSocketClient;
import org.springframework.web.socket.handler.TextWebSocketHandler;
import org.springframework.web.socket.messaging.WebSocketStompClient;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
public class KuCoinSocketHandler extends TextWebSocketHandler {

    Logger logger = LoggerFactory.getLogger(KuCoinSocketHandler.class);
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    @Autowired
    private KuCoinWebSocketConfigInfo info;

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        /*for (WebSocketSession webSocketSession : sessions) {
            //Map value = new Gson().fromJson(message.getPayload(), Map.class);


        }*/

        if (!sessions.contains(session)) {
            sessions.add(session);
        }

        String payload = message.getPayload();
        session.sendMessage(new TextMessage("Hello " + payload + " !"));
    }

    @PostConstruct
    public void init() {

        String info = this.info.getConfig();

        WebSocketClient client = new StandardWebSocketClient();
        WebSocketStompClient stompClient = new WebSocketStompClient(client);
        stompClient.setMessageConverter(new MappingJackson2MessageConverter());

        //StompSessionHandler sessionHandler = new MyStompSessionHandler();
        //stompClient.connect(URL, sessionHandler);

        logger.info("init..." + info);
    }


}
