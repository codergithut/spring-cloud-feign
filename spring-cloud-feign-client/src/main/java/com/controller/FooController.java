package com.controller;

import com.client.UserClient;
import com.client.UserClientFallBack;
import com.config.FeignConfiguration;
import feign.Feign;
import feign.codec.Decoder;
import feign.codec.Encoder;
import feign.httpclient.ApacheHttpClient;
import feign.hystrix.HystrixFeign;
import org.apache.http.impl.client.HttpClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.feign.FeignClientsConfiguration;
import org.springframework.context.annotation.Import;
import org.springframework.stereotype.Service;

@Import({FeignClientsConfiguration.class,FeignConfiguration.class})
@Service
class FooController {

    private UserClient fooClient;

    private UserClient hystClient;


    @Autowired
    public FooController(
            Decoder decoder, Encoder encoder) {

        /**
         * 构建可以有faceback的类
         */
        this.hystClient = HystrixFeign.builder()
                .client(new ApacheHttpClient(HttpClients.createDefault()))
                .encoder(encoder)
                .decoder(decoder)
                .target(UserClient.class, "http://eureka:8010", new UserClientFallBack());

        /**
         * 构建普通的类
         */
        this.fooClient = Feign.builder().client(new ApacheHttpClient(HttpClients.createDefault()))
                .encoder(encoder)
                .decoder(decoder)
                .target(UserClient.class, "http://eureka:8010");

    }

    public UserClient getFooClient() {
        return fooClient;
    }

    public void setFooClient(UserClient fooClient) {
        this.fooClient = fooClient;
    }

    public UserClient getHystClient() {
        return hystClient;
    }

    public void setHystClient(UserClient hystClient) {
        this.hystClient = hystClient;
    }
}