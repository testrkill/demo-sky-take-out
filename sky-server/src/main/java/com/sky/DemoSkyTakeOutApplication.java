package com.sky;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.sky.mapper")//扫描Mapper接口所在的包
public class DemoSkyTakeOutApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoSkyTakeOutApplication.class, args);
    }

}
