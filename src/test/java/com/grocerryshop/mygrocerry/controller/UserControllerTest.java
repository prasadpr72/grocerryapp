package com.grocerryshop.mygrocerry.controller;

import java.util.Date;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.grocerryshop.mygrocerry.entity.GroceeryUser;
import com.grocerryshop.mygrocerry.service.UserService;

@RunWith(MockitoJUnitRunner.class)
public class UserControllerTest {
	@Mock
	private UserService service;
	
	@InjectMocks
	private UserController controller;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	@Test
	public void testAddUser(){
		GroceeryUser groceeryUser1 = new GroceeryUser("Customer1",new Date(),'A');
		GroceeryUser groceeryUser2 = new GroceeryUser("Customer1",new Date(),'A');
		groceeryUser2.setCustId(232321l);
		Mockito.when(service.addUser(groceeryUser1)).thenReturn(groceeryUser2);
		Assert.assertTrue(232321l== controller.addUser(groceeryUser1).getCustId());
		
	}
}
