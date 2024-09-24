package com.order.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.dto.CouponDto;
@FeignClient(name="coupons", url ="http://localhost:8085" )
public interface CouponServiceProxy {
	@GetMapping(path="couponbycode/{couponCode}")
	public CouponDto getAnCouponByCode(@PathVariable(name="couponCode") String couponCode);
}
