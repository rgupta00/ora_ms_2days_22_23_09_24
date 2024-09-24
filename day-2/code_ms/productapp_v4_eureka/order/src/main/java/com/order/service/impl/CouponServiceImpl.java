package com.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.order.dto.CouponDto;
import com.order.feignproxy.CouponServiceProxy;
import com.order.service.CouponService;
@Service
public class CouponServiceImpl implements CouponService {

	@Autowired
	private CouponServiceProxy couponServiceProxy;
	
	@Override
	public CouponDto getCouponDto(String couponCode) {
		return couponServiceProxy.getAnCouponByCode(couponCode);
	}

}
