package com.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

//　FIXME Spring Securityを利用する時にここも見直す
@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class InfoBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(InfoBoardApplication.class, args);
	}

}
