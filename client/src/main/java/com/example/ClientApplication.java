package com.example;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.example.demo.HelloService;
import org.apache.dubbo.config.annotation.Reference;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;

/**
 * @author fei
 */
@EnableDubbo
@EnableNacosConfig
@SpringBootApplication
public class ClientApplication {

    @Reference
    private HelloService demoService;
    @NacosValue(value = "test", autoRefreshed = true)
    private String test;

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
    }

    @PostConstruct
    public void init() {
        String sayHello = demoService.sayHello("world");
        System.err.println(sayHello);
        System.err.println(test);
    }
}
