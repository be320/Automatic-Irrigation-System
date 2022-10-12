package com.farm.irregation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class IrregationApplication {

	public static void main(String[] args) {
		SpringApplication.run(IrregationApplication.class, args);
	}

}
