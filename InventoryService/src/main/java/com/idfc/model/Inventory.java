package com.idfc.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Inventory {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	
	private String title;
	
	private int qty;

	public Inventory() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Inventory(String title, int qty) {
		super();
		this.title = title;
		this.qty = qty;
	}

	public int getId() {
		return id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getQty() {
		return qty;
	}

	public void setQty(int qty) {
		this.qty = qty;
	}

	@Override
	public String toString() {
		return "Inventory [id=" + id + ", title=" + title + ", qty=" + qty + "]";
	}
	
	
}
