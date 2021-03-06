package com.assign.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

/**
 * Hello world!
 *
 */

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan("com.assign.test")
public class Application extends SpringBootServletInitializer 
{
    public static void main( String[] args )
    {
       SpringApplication.run(Application.class, args);
    }
}
