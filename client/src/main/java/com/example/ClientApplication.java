package com.example;

import com.example.demo.HelloService;
import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;

import javax.annotation.PostConstruct;

import com.alibaba.dubbo.config.annotation.Reference;

import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@SpringBootApplication
public class ClientApplication {

    @Reference(version = "1.0.0")
    private HelloService demoService;

    public static void main(String[] args) {

        SpringApplication.run(ClientApplication.class, args);
    }

    @PostConstruct
    public void init() {
        String sayHello = demoService.sayHello("world");
        System.err.println(sayHello);
    }
}
