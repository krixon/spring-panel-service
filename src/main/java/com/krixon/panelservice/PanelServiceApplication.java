package com.krixon.panelservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.resource.ResourceServerProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.provider.token.ResourceServerTokenServices;

@SpringBootApplication
@EnableResourceServer
public class PanelServiceApplication {

    @Autowired
    private ResourceServerProperties sso;

    public static void main(String[] args) {
        SpringApplication.run(PanelServiceApplication.class, args);
    }

    @Bean
    public ResourceServerTokenServices userInfoTokenServices() {
        return new CustomUserInfoTokenServices(sso.getUserInfoUri(), sso.getClientId());
    }
}
