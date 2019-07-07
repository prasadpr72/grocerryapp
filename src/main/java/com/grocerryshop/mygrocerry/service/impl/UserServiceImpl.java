package com.grocerryshop.mygrocerry.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerryshop.mygrocerry.dao.UserDao;
import com.grocerryshop.mygrocerry.entity.GroceeryUser;
import com.grocerryshop.mygrocerry.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao dao;

	@Override
	public GroceeryUser addUser(GroceeryUser groceeryUser) {
		return dao.save(groceeryUser);
	}

}
