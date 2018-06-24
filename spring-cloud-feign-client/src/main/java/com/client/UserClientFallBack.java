package com.client;

import org.springframework.stereotype.Service;

@Service
public class UserClientFallBack implements UserClient{


    @Override
    public String getuserinfo() {
        return "ERROR";
    }

    @Override
    public String getuserinfostr() {
        return "ERROR";
    }

    @Override
    public String info() {
        return "ERROR";
    }
}

