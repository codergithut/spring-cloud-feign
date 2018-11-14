package com.client;

import feign.RequestLine;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value="feign-server")
public interface UserClient {

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    @RequestLine("GET /getuser")
    public String getuserinfo();

    @RequestLine("GET /getuserinfo")
    public String getuserinfostr();

    @RequestLine("GET /info")
    public  String  info();

}

