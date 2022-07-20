package com.pobs.database_testing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.pobs.database_testing")
@EnableAutoConfiguration
public class DatabaseTestingApplication {

	public static void main(String[] args) {
		SpringApplication.run(DatabaseTestingApplication.class, args);
	}

}
