package com.example.bootdemoazappconfig;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories("com.example.bootdemoazappconfig.repository")
@EntityScan("com.example.bootdemoazappconfig.model")
@EnableConfigurationProperties(MessageProperties.class)
@SpringBootApplication
public class BootDemoAzAppConfigApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootDemoAzAppConfigApplication.class, args);
	}

}
