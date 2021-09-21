package com.group18.cosc4351project;

import com.group18.controllers.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@SpringBootApplication(scanBasePackages={
		"com.group18.service", "com.group18.controllers", "com.group18.config", "com.group18.security"})
@EntityScan("com.group18.entities")
@EnableJpaRepositories("com.group18.repository")
public class Cosc4351projectApplication {

	public static void main(String[] args) {
		SpringApplication.run(Cosc4351projectApplication.class, args);
	}

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.group18.controllers")).build();
	}
}
