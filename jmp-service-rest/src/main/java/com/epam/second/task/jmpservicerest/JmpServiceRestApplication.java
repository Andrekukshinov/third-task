package com.epam.second.task.jmpservicerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "com.epam.second.task")
public class JmpServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmpServiceRestApplication.class, args);
	}

}
