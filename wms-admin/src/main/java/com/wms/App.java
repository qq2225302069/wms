package com.wms;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Created by cyh on 2019/3/26.
 */
@EnableAutoConfiguration
@ComponentScan(basePackages = "com.wms")
@MapperScan(basePackages = "com.wms.mapper")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
