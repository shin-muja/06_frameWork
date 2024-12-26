package edu.kh.data;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class PublicDataApplication {

	public static void main(String[] args) {
		SpringApplication.run(PublicDataApplication.class, args);
	}

}
