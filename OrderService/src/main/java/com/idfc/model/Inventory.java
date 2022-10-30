package com.idfc.model;

public class Inventory {

	private int id;
	
	private String title;
	
	private int qty;

	public Inventory() {
		super();
		//TODO Auto-generated constructor stub
	}

	public Inventory(int id, String title, int qty) {
		super();
		this.id = id;
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
