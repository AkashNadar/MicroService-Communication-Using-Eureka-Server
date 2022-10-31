package com.idfc.controller;

import com.idfc.model.Inventory;
import com.idfc.service.InventoryServiceImple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
	
	@Autowired
	private InventoryServiceImple service;
	
	@GetMapping("/get/{title}/{qty}")
	public ResponseEntity<Object> getInventory(@PathVariable String title, @PathVariable int qty){
		Inventory res = this.service.getInventory(title, qty);
		System.out.println(res);
		if(res.getQty() <= qty || res==null) {
			System.out.println("less qty so order can not be completed");
			   res.setQty(-1);
			//ResponseEntity<Inventory> entity = new ResponseEntity<Inventory>(new Inventory(res.getId(), title, -1), )
			
				//	return new ResponseEntity<Object>(res, HttpStatus.NOT_FOUND);
		}
		
		
		
		
		return new ResponseEntity<Object>(res, HttpStatus.OK);
	}
}
