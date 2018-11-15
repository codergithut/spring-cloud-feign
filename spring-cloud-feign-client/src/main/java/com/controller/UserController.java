package com.controller;

import com.client.UserClient;
import com.netflix.appinfo.InstanceInfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class UserController {


    @Autowired
    FooController fooController;

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
        return ips.toString();
    }

    @RequestMapping(value = "/getuserinfo1", method = RequestMethod.GET)
    public String getuserinfostr() {
        String ss = fooController.getFooClient().getuserinfo();
        return ss;
    }

    @RequestMapping(value = "/getuserinfo3", method = RequestMethod.GET)
    public String getuserinfostr1() {
        String ss = fooController.getHystClient().getuserinfo();
        return ss;
    }


}
