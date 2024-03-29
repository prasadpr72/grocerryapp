package com.grocerryshop.mygrocerry.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.grocerryshop.mygrocerry.entity.GroceeryUser;
import com.grocerryshop.mygrocerry.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService service;

	@PostMapping("addUser")
	public GroceeryUser addUser(@RequestBody GroceeryUser user) {
		return service.addUser(user);

	}
}
