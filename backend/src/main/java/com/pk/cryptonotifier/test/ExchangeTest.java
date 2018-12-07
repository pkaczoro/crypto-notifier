package com.pk.cryptonotifier.test;

import com.google.gson.JsonObject;
import com.pk.cryptonotifier.connection.KuCoinConfig;
import com.pk.cryptonotifier.connection.KucoinApiException;
import com.pk.cryptonotifier.connection.KucoinRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
public class ExchangeTest {

    KuCoinConfig config = new KuCoinConfig();

    @RequestMapping("/test")
    String test() {

        JsonObject response = null;
        try {
            response = (new KucoinRequest(config.getBaseUrl() + "v1/user/info"))
                    .sign(config.getApiKey(), config.getSecret())
                    .read().asJsonObject();
        } catch (KucoinApiException e) {
            e.printStackTrace();
        }

        return response.toString();
    }


    @RequestMapping("/test-websocket")
    String wsTest() {
        return "dupa";
    }

}
