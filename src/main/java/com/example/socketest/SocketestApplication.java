package com.example.socketest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:application.properties")
public class SocketestApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(SocketestApplication.class, args);
    }

}
