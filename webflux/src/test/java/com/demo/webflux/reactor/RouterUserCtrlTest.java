package com.demo.webflux.reactor;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.reactive.server.WebTestClient;

/**
 * @author hjx
 * @version 1.0
 * @date 2021/7/20 0:58
 */
@SpringBootTest
public class RouterUserCtrlTest
{
    @Autowired
    private WebTestClient client;
    @Test
    public  void test()
    {
        WebTestClient.ResponseSpec exchange = client.get().uri("/hello").accept(MediaType.ALL).exchange();
        System.out.println(exchange.toString());
    }
}
