package com.example.SimpleProject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class SimpleProjectApplication {

	public static void main(String[] args) {
        var context =SpringApplication.run(SimpleProjectApplication.class, args);

        // Get environment
        Environment env = context.getEnvironment();

        // Read port (default 8080)
        String port = env.getProperty("server.port", "8080");

        // Print URL
        System.out.println("\n🚀 Application running at: http://localhost:" + port + "\n");
	}

}
