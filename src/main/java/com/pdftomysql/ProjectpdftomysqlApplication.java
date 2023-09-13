package com.pdftomysql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(BatchConfig.class)
public class ProjectpdftomysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProjectpdftomysqlApplication.class, args);
	}

}
