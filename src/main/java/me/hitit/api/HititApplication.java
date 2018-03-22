package me.hitit.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
public class HititApplication {
    public static void main(String[] args) {
        SpringApplication.run(HititApplication.class, args);
    }
}
