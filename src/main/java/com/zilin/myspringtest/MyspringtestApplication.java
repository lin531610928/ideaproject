package com.zilin.myspringtest;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@MapperScan("com.zilin.myspringtest.dao")
@EnableCaching
public class MyspringtestApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyspringtestApplication.class, args);
    }

}

