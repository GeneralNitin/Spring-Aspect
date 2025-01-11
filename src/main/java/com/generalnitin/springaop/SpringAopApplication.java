package com.generalnitin.springaop;

import com.generalnitin.springaop.services.HomeService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
public class SpringAopApplication {

    public static void main(String[] args) {
        try (ConfigurableApplicationContext context = SpringApplication.run(SpringAopApplication.class, args)) {
            System.out.println(context.getBean(HomeService.class).sayHello());
        }
    }

}
