package com.coupon.utl;

import com.coupon.dto.CouponDto;
import com.coupon.entities.Coupon;

public class CouponConverter {
    public static CouponDto entityToDto(Coupon coupon){
        CouponDto couponDto = new CouponDto();
        couponDto.setId(coupon.getId());
        couponDto.setCouponCode(coupon.getCouponCode());
        couponDto.setDiscountPercentage(coupon.getDiscountPercentage());
        couponDto.setExpiredOn(coupon.getExpiredOn());
        return couponDto;
    }
    public static  Coupon dtoToEntity(CouponDto couponDto){
        Coupon coupon = new Coupon();
        coupon.setId(couponDto.getId());
        coupon.setCouponCode(couponDto.getCouponCode());
        coupon.setDiscountPercentage(couponDto.getDiscountPercentage());
        coupon.setExpiredOn(couponDto.getExpiredOn());
        return coupon;
    }
}
