package com.coupon.repo;

import com.coupon.entities.Coupon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouponRepo extends JpaRepository<Coupon, Integer> {
	public Coupon findByCouponCode(String couponCode);
}