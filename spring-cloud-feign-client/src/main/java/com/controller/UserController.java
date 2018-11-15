package com.controller;

import com.client.UserClient;
import com.netflix.appinfo.InstanceInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    UserClient userClient;

    @Autowired
    DiscoveryClient discoveryClient;


    @RequestMapping(value = "/getuserinfo", method = RequestMethod.GET)
    public String getuserinfo() {
        String ss = userClient.getuserinfo();
        return ss;
    }

    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String testClient() {
        StringBuffer ips = new StringBuffer();
        RestTemplate restTemplate = new RestTemplate();
        List<ServiceInstance> instances = discoveryClient.getInstances("feign-service");
        instances.stream().forEach( t -> {
            ips.append(t.getUri() + ":");
        });
        String serUri = instances.get(0).getUri() + "/getuser";
        Object o = new Object();
        ResponseEntity<String> restExchange = restTemplate.exchange(serUri, HttpMethod.GET, null, String.class, o);
        return restExchange.getBody();
    }


}
