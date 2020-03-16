package com.framework.hanason;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author sorata
 * 启动类
 */
@SpringBootApplication
@MapperScan(basePackages = "com.framework.hanason.dao")
public class HanasonAppApplication {

    public static void main(String[] args) {
        SpringApplication.run(HanasonAppApplication.class, args);
    }

}
