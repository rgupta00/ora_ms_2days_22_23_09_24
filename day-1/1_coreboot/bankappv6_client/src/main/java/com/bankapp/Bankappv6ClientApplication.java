package com.bankapp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableFeignClients("com.bankapp.clientproxy")
public class Bankappv6ClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(Bankappv6ClientApplication.class, args);
	}
	//i will configure a bean of rest template
	@Bean
	 RestTemplate restTemplate() {
		return new RestTemplate();
	}

}
