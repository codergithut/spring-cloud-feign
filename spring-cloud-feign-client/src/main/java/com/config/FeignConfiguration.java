package com.config;

import feign.Contract;
import feign.httpclient.ApacheHttpClient;
import org.apache.http.client.HttpClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfiguration {
    //Contract feign的默认契约
    @Bean
    public Contract feignContract() {
        return new Contract.Default();
    }

    @Autowired(required = false)
    private HttpClient httpClient;

    @ConditionalOnMissingBean
    @Bean
    public ApacheHttpClient feignClient() {
        if (this.httpClient != null) {
            return new ApacheHttpClient(this.httpClient);
        }
        return new ApacheHttpClient();
    }

}
