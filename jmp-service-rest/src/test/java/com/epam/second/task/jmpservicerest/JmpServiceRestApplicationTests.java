package com.epam.second.task.jmpservicerest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootTest
@ComponentScan(lazyInit = true, basePackages = "com.epam.second.task")
class JmpServiceRestApplicationTests {

	@Test
	void contextLoads() {
	}

}
