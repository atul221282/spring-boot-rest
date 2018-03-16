package io.javabrains.sbs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApiApp {

	public static void main(String[] args) {
		// run method sets up the default configuration
		// Springboot create servlet container and host that container in servlet
		SpringApplication.run(CourseApiApp.class, args);
	}

}
