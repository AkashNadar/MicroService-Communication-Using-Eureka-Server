package com.idfc.service;

import java.util.List;

import com.idfc.dao.InventoryRepository;
import com.idfc.model.Inventory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InventoryServiceImple implements InventoryService {

	@Autowired
	private InventoryRepository repo;
	
	@Override
	public Inventory getInventory(String title, int qty) {
		// TODO Auto-generated method stub
		List<Inventory> inventorys = this.repo.findAll();
		for(Inventory inventory : inventorys) {
			if(inventory.getTitle().equals(title)) {
				if(inventory.getQty() >= qty) {
					return this.setInventoryQty(inventory.getId(), inventory.getQty()-qty);
				}
				return inventory;
			}
		}
		
		return null;
	}
	
	
	public Inventory setInventoryQty(int id, int qty) {
		Inventory inventory = this.repo.findById(id).get();
		inventory.setQty(qty);
		return this.repo.save(inventory);
	}

}
