package com.idfc.service;

import com.idfc.model.Inventory;

public interface InventoryService {
	
	public Inventory getInventory(String title, int qty);
}
