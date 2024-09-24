package com.order.service;

import com.order.dto.OrderRequest;
import com.order.dto.OrderResponse;

public interface BookOrderService {

	public OrderResponse bookAnOrder(OrderRequest orderRequest);
}
