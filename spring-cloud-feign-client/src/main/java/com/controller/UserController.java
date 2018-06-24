package com.controller;

import com.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {


    @Autowired
    FooController fooController;

    @Autowired
    UserClient userClient;


    @RequestMapping(value = "/getuserinfo", method = RequestMethod.GET)
    public String getuserinfo() {
        String ss = userClient.getuserinfo();
        return ss;
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
