package com.shown.shownapiclient;

import com.shown.shownapiclient.client.ShownApiClient;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("application.properties")
@ComponentScan
public class ShownApiClientConfig {
    private String accessKey;
    private String secretKey;

    public ShownApiClient shownApiClient(String accessKey,String secretKey){
        return new ShownApiClient(accessKey,secretKey);
    }
}
