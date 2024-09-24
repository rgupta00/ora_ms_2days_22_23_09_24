package com.order.feignproxy.fallbackresponse;

import java.time.LocalDate;

import org.springframework.stereotype.Service;

import com.order.dto.CouponDto;
import com.order.feignproxy.CouponServiceProxy;
@Service
public class CouponServiceProxyFallBack implements CouponServiceProxy{

	@Override
	public CouponDto getAnCouponByCode(String couponCode) {
		//cached response
		
		CouponDto couponDto= new CouponDto();
		couponDto.setCouponCode("SUP02");
		couponDto.setDiscountPercentage(2);
		couponDto.setExpiredOn(LocalDate.now());
		couponDto.setId(10);
		return couponDto;
	}

}
