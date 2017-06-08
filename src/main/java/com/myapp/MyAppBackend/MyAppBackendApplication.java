package com.myapp.MyAppBackend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.web.WebApplicationInitializer;

@SpringBootApplication
public class MyAppBackendApplication extends SpringBootServletInitializer
	implements WebApplicationInitializer {

	public static void main(String[] args) {
		SpringApplication.run(MyAppBackendApplication.class, args);
	}
}
