package com.yeta.tophistory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class TophistoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(TophistoryApplication.class, args);
	}
}
