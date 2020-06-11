package com.kelly.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication8100 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication8100.class, args);
    }

}
