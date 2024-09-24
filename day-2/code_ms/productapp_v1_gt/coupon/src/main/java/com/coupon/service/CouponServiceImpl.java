package com.coupon.service;

import com.coupon.dto.CouponDto;
import com.coupon.exceptions.CouponNotFoundException;
import com.coupon.entities.Coupon;
import com.coupon.repo.CouponRepo;
import com.coupon.utl.CouponConverter;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class CouponServiceImpl implements CouponService{

	@Autowired
	private CouponRepo couponRepo;

	@Override
	public List<CouponDto> getAll() {
		return couponRepo.findAll().stream()
				.map(CouponConverter::entityToDto).collect(Collectors.toList());
	}

	@Override
	public CouponDto getCouponById(int id) {
		return couponRepo.findById(id)
				.map(CouponConverter::entityToDto).orElseThrow(CouponNotFoundException:: new);
	}

	@Override
	public CouponDto addCoupon(CouponDto couponDto) {
		Coupon couponToAdd=CouponConverter.dtoToEntity(couponDto);
		couponRepo.save(couponToAdd);
		return CouponConverter.entityToDto(couponToAdd);
	}

	@Override
	public CouponDto getCouponByCouponCode(String couponCode) {
		return CouponConverter.entityToDto(couponRepo.findByCouponCode(couponCode));
	}

}