package com.hhwy.device;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author 王阳
 * @create 2020-07-13-9:29
 */
@SpringBootApplication
@ServletComponentScan
@ComponentScan({"com.hhwy"})
public class TestApplication {
    public static void main(String[] args) {
        SpringApplication.run(TestApplication.class,args);
    }
}
