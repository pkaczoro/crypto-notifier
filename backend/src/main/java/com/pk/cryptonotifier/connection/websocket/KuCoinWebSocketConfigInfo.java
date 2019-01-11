package com.pk.cryptonotifier.connection.websocket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.messaging.converter.MappingJackson2MessageConverter;
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
import java.net.URL;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


@Component
public class KuCoinWebSocketConfigInfo  {


    public String getConfig() {

        URL url = null;
        try {
            url = new URL("https://kitchen.kucoin.com/v1/bullet/usercenter/loginUser?protocol=websocket&encrypt=true");
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");


        } catch (IOException e) {
            e.printStackTrace();
        }

        return "";
    }


}
