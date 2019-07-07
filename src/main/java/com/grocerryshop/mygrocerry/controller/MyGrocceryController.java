package com.grocerryshop.mygrocerry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocerryshop.mygrocerry.entity.MyGrocerry;
import com.grocerryshop.mygrocerry.service.MyGroceeryService;

@RestController
public class MyGrocceryController {

	@Autowired
	private MyGroceeryService service;
	@PostMapping("/addBill")
	public MyGrocerry fetchBill(@RequestBody MyGrocerry grocerry){
		return service.getBill(grocerry);
		
	}
	
}
