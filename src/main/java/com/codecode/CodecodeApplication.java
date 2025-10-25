package com.codecode;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.codecode")
public class CodecodeApplication {

    public static void main(String[] args) {
        SpringApplication.run(CodecodeApplication.class, args);
    }

}
