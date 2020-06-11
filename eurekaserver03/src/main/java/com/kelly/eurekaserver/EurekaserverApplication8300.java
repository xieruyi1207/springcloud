package com.kelly.eurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaserverApplication8300 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaserverApplication8300.class, args);
    }

}
