package com.epam.second.task.jmpservicerest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@SpringBootTest
@ComponentScan(lazyInit = true, basePackages = "com.epam.second.task")
class JmpServiceRestApplicationTests {

	@Test
	void contextLoads() {
	}

}
