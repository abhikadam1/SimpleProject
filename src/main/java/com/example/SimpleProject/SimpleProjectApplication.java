package com.example.SimpleProject;

//import org.apache.catalina.core.ApplicationContext;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SimpleProjectApplication {

	public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(SimpleProjectApplication.class, args);
        Environment env = context.getEnvironment();
        String port = env.getProperty("server.port");
        String host = env.getProperty("server.host");
        String basePath = env.getProperty("server.basePath");
        String contextPath = env.getProperty("server.servlet.context-path");
        System.out.println("Port: " + port);
        System.out.println("Host: " + host);
        System.out.println("BasePath: " + basePath);
        System.out.println("ContextPath: " + contextPath);
        System.out.println("Application URI: " + basePath + contextPath);


        String port1 = env.getProperty("server.port", "8080");
        String contextPath1 = env.getProperty("server.servlet.context-path", "");
        System.out.println("   👉 http://localhost:" + port1 + contextPath1);
	}

}
