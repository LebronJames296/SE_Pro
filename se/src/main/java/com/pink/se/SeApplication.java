package com.pink.se;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.pink.se.mapper")
public class SeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SeApplication.class, args);
    }

}
