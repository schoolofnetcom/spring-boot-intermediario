package com.schoolofnet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class TaskApplication {

	public static void main(String[] args) {

        SpringApplication.run(TaskApplication.class, args);
	}
}
