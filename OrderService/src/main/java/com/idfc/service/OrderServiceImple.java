package com.idfc.service;

import java.util.HashMap;
import java.util.Map;

import com.idfc.dao.OrderRepository;
import com.idfc.model.Inventory;
import com.idfc.model.Order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImple implements OrderService {

	@Autowired
	private DiscoveryClient client;
	@Autowired
	private OrderRepository repo;
	
	@Override
	public Order placeOrder(String title, int qty, String clientName) {
		ServiceInstance instance = this.client.getInstances("inventory-service").get(0);
		String baseUrl = instance.getUri().toString();
		baseUrl += "/inventory/get/{title}/{qty}";
		Map<String, Object> pathVariables = new HashMap<String, Object>();
		pathVariables.put("title", title);
		pathVariables.put("qty", qty);
		System.out.println("inside the place Order");
		ResponseEntity<Inventory> entity = new RestTemplate()
				.exchange(baseUrl, HttpMethod.GET, null, Inventory.class, pathVariables);
		Inventory res = entity.getBody();
		
		System.out.println("inside the order service :-" + res);
		int qtys = res.getQty();
		if(qtys == -1) {
			System.out.println("inside the inventory res " + res);
			return null;
		}
			
		
		Order newOrder = new Order(res.getTitle(), qty, clientName);
		return this.addOrder(newOrder);
	}
	
	public Order addOrder(Order order) {
		return this.repo.save(order);
	}

}
