package com.example.announcement_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.boot.autoconfigure.domain.EntityScan;
// import org.springframework.context.annotation.ComponentScan;


@SpringBootApplication(scanBasePackages = "com.example")
@EnableJpaRepositories("com.example.repository")
@EntityScan("com.example.entity")  // ✅ 強制 Spring Boot 掃描 `entity`
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
