package com.order.feignproxy;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.order.dto.CouponDto;
import com.order.feignproxy.fallbackresponse.CouponServiceProxyFallBack;
@FeignClient(name="COUPONS", fallback = CouponServiceProxyFallBack.class)
public interface CouponServiceProxy {
	@GetMapping(path="couponbycode/{couponCode}")
	public CouponDto 
	getAnCouponByCode(@PathVariable(name="couponCode") String couponCode);
}
