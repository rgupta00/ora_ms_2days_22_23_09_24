package com.bankapp.repo;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "account_table")
public class Account {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private BigDecimal balance;
    
	public Account(String name, BigDecimal balance) {
		this.name = name;
		this.balance = balance;
	}
    
    

}
