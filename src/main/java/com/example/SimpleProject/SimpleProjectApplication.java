package com.example.SimpleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SimpleProjectApplication {

	public static void main(String[] args) {
//		SpringApplication.run(SimpleProjectApplication.class, args);

        ConfigurableApplicationContext context = SpringApplication.run(SimpleProjectApplication.class, args);
        Environment environment = context.getEnvironment();

        String serverPort = environment.getProperty("local.server.port", "8080");
        String host = "localhost"; // Default host for local development

        // You can also retrieve the context path if configured
        String contextPath = environment.getProperty("server.servlet.context-path", "");

        String applicationUrl = String.format("http://%s:%s%s", host, serverPort, contextPath);
        System.out.println("Spring Boot application is running at: " + applicationUrl);


    }

}
