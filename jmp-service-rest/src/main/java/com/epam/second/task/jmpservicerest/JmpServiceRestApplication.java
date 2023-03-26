package com.epam.second.task.jmpservicerest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.PathSelectors.regex;

@SpringBootApplication(scanBasePackages = "com.epam.second.task")
public class JmpServiceRestApplication {

	public static void main(String[] args) {
		SpringApplication.run(JmpServiceRestApplication.class, args);
	}
//	@Bean
//	public Docket productApi() {
//		return new Docket(DocumentationType.SWAGGER_2)
//				.select()
//				.apis(RequestHandlerSelectors.basePackage("com.epam.second.task.jmpservicerest.controller"))
//				.paths(regex("/api.*"))
//				.build();
//	}
}
