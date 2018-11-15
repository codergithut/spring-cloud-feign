package com.config;


import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class FeignConfiguration {
    //Contract feign的默认契约
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }


    @Bean
    public Logger.Level logLevel(){
        return Logger.Level.FULL;
    }

}
