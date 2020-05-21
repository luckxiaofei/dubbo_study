package com.example;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.config.annotation.NacosProperty;
import com.example.demo.EmbeddedZooKeeper;
import org.springframework.boot.SpringApplication;


import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ServerApplication {


    public static void main(String[] args) {

        // start embedded zookeeper server
        EmbeddedZooKeeper embeddedZooKeeper = new EmbeddedZooKeeper(2181, false);
        if (!embeddedZooKeeper.isRunning()) {
            embeddedZooKeeper.start();
        }
        SpringApplication.run(ServerApplication.class, args);
    }

}
