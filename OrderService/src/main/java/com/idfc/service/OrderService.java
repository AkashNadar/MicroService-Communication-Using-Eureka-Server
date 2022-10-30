package com.idfc.service;

import com.idfc.model.Order;

public interface OrderService {
	
	public Order placeOrder(String title, int qty, String clientName);
}
