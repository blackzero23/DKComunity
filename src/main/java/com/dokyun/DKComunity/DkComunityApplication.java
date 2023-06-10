package com.dokyun.DKComunity;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class DkComunityApplication {

	public static void main(String[] args) {
		SpringApplication.run(DkComunityApplication.class, args);
	}

}
