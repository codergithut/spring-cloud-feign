package com.client;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="feign-service")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getuser", consumes="application/json")
    String getuserinfo();

}

