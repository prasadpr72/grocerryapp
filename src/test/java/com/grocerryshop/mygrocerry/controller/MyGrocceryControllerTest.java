package com.grocerryshop.mygrocerry.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.grocerryshop.mygrocerry.entity.GroceeryUser;
import com.grocerryshop.mygrocerry.entity.MyGrocerry;
import com.grocerryshop.mygrocerry.service.MyGroceeryService;


@RunWith(MockitoJUnitRunner.class)
public class MyGrocceryControllerTest {

	@Mock
	private MyGroceeryService service;
	
	@InjectMocks
	private MyGrocceryController controller; 
	
	@Test
	public void testFetchBill(){
		MyGrocerry grocerry = new MyGrocerry();
		grocerry.setCustId(444l);
		grocerry.setPrice(4343.55d);
		GroceeryUser groceeryUser = new GroceeryUser();
		groceeryUser.setCustomerType('E');
		Mockito.when(service.getBill(Matchers.anyObject())).thenReturn(
				grocerry);
		grocerry.setPrice(3040d);
		
		Assert.assertTrue(3040d == controller.fetchBill(grocerry).getPrice());
		
	}
	
}