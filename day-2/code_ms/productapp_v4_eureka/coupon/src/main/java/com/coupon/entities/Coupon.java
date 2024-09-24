package com.coupon.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@Data
@Entity
@Table(name = "coupon_table")
@NoArgsConstructor
public class Coupon {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String couponCode;
	private int discountPercentage;
	private LocalDate expiredOn;

	public Coupon(String couponCode, int discountPercentage, LocalDate expiredOn) {
		this.couponCode = couponCode;
		this.discountPercentage = discountPercentage;
		this.expiredOn = expiredOn;
	}
}