package com.idfc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity(name = "ProductOrders")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String description;
	
	private int qty;
	
	private String clientName;

	public Order() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Order(String description, int qty, String clientName) {
		super();
		this.description = description;
		this.qty = qty;
		this.clientName = clientName;
	}

	public int getId() {
		return id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	public String getClientName() {
		return clientName;
	}

	public void setClientName(String clientName) {
		this.clientName = clientName;
	}

	@Override
	public String toString() {
		return "Order [id=" + id + ", description=" + description + ", qty=" + qty + ", clientName=" + clientName + "]";
	}
	
	
}
