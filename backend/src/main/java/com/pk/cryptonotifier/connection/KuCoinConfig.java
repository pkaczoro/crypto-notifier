package com.pk.cryptonotifier.connection;

public class KuCoinConfig {

    private String apiKey = "5c0260fa53b52073effce18a";
    private String secret = "c07d99d2-822e-4453-844a-8e9b52c74d3b";

    public String baseUrl = "https://api.kucoin.com/";

    public String getBaseUrl() {
        return baseUrl;
    }

    public String getApiKey() {
        return apiKey;
    }

    public String getSecret() {
        return secret;
    }
}
