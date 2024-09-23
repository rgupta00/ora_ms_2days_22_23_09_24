package com.coupon.service;

import com.coupon.dto.CouponDto;
import com.coupon.entities.Coupon;

import java.util.List;

public interface CouponService {
	public List<CouponDto> getAll();
	public CouponDto getCouponById(int id);
	public CouponDto getCouponByCouponCode(String couponCode);
	public CouponDto addCoupon(CouponDto couponDto);
}