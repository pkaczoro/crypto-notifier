package com.pk.cryptonotifier.exchange.test;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConnectionTest {
    @RequestMapping("/test")
    public String test() {
        return "costam";
    }

}
