package com.tony.futuretask;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class FuturetaskApplication {

    public static void main(String[] args) {
        SpringApplication.run(FuturetaskApplication.class, args);
    }

}
