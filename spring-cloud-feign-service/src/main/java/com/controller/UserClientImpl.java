package com.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserClientImpl {

    @RequestMapping(method = RequestMethod.GET, value = "/getuser")
    public String getuserinfo() throws Exception {
        boolean flag = true;
        if(flag) {
            throw new Exception("tst");
        }
        return "userinfo";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getuserinfo")
    public String getuserinfostr() {
        return "user";
    }

    @RequestMapping(method = RequestMethod.GET, value = "/info")
    public  String  info() {
        return "info";
    }
}
