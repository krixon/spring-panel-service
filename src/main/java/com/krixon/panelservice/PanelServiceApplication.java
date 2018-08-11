package com.krixon.panelservice;

import com.krixon.resourceserver.security.MethodSecurityConfig;
import com.krixon.resourceserver.security.WebSecurityConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;

@Configuration
@SpringBootApplication
@EnableResourceServer
@EnableEurekaClient
@Import({WebSecurityConfig.class, MethodSecurityConfig.class})
public class PanelServiceApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(PanelServiceApplication.class, args);
    }
}
