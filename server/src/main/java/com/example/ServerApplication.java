package com.example;

import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.example.demo.EmbeddedZooKeeper;
import org.apache.dubbo.config.spring.context.annotation.EnableDubboConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@EnableDubboConfig
@SpringBootApplication
public class ServerApplication {


    public static void main(String[] args) {

        EmbeddedZooKeeper embeddedZooKeeper = new EmbeddedZooKeeper(2181, false);
        if (!embeddedZooKeeper.isRunning()) {
            embeddedZooKeeper.start();
        }
        SpringApplication.run(ServerApplication.class, args);
    }

}
