package com.jcstool;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @Author : qinjiawang
 * @Date : 2019/09/19
 * @Desoription :
 */
@EnableAspectJAutoProxy(proxyTargetClass = true)
@SpringBootApplication
//@EnableScheduling
public class App {

    public static void main(String[] args) {
        SpringApplication.run(App.class,args);
    }
}
