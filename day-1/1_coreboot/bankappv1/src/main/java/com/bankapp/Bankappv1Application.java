package com.bankapp;
//SB=spring-infra bean(conn pool)

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
@ComponentScan(basePackages = {"com.bankapp"})
@SpringBootApplication
public class Bankappv1Application implements CommandLineRunner{

	@Autowired
	private DataSource dataSource;
	
	public static void main(String[] args) {
		SpringApplication.run(Bankappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		if(dataSource!=null) {
			System.out.println(dataSource.getClass());
			System.out.println("ds is configured--------------------------");
		}
	}

}
