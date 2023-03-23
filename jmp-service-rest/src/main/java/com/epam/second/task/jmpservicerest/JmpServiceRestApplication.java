package com.epam.second.task.jmpservicerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.epam.second.task")
@EnableJpaRepositories(basePackages = "com.epam.second.task")
@EntityScan(basePackages = "com.epam.second.task")
public class JmpServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmpServiceRestApplication.class, args);
	}

}
