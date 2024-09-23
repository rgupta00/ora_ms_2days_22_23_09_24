package com.bankapp.repo;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//DTO
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Account {
    private int id;
    private String name;
    private BigDecimal balance;

}
