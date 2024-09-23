package com.bankapp;
//SB=spring-infra bean(conn pool)

import java.math.BigDecimal;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

import com.bankapp.repo.Account;
import com.bankapp.repo.AccountRepo;
@ComponentScan(basePackages = {"com.bankapp"})
@SpringBootApplication
public class Bankappv1Application implements CommandLineRunner{

	@Autowired
	private AccountRepo accountRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(Bankappv1Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		accountRepo.save(new Account("raj",
				BigDecimal.valueOf(1000.00)));
		accountRepo.save(new Account("ekta",
				BigDecimal.valueOf(1000.00)));
	}

}
