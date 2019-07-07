package com.grocerryshop.mygrocerry.service.impl.test;

import java.util.Calendar;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;

import com.grocerryshop.mygrocerry.GroccerryException;
import com.grocerryshop.mygrocerry.dao.MyGroceeryDao;
import com.grocerryshop.mygrocerry.dao.UserDao;
import com.grocerryshop.mygrocerry.entity.GroceeryUser;
import com.grocerryshop.mygrocerry.entity.MyGrocerry;
import com.grocerryshop.mygrocerry.service.impl.MyGroceeryServiceImpl;

@RunWith(MockitoJUnitRunner.class)
public class MyGroceeryServiceImplTest {

	@Mock
	private MyGroceeryDao dao;

	@Mock
	private UserDao userDao;

	@InjectMocks
	private MyGroceeryServiceImpl impl;

	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}

	@Test(expected = GroccerryException.class)
	public void testGetBillException() {
		MyGrocerry grocerry = new MyGrocerry();
		grocerry.setCustId(444l);
		grocerry.setPrice(4343.55d);
		Mockito.when(userDao.findOne(111l)).thenReturn(null);
		impl.getBill(grocerry);
	}

	@Test()
	public void testGetBill() {
		MyGrocerry grocerry = new MyGrocerry();
		grocerry.setCustId(444l);
		grocerry.setPrice(4343.55d);
		GroceeryUser groceeryUser = new GroceeryUser();
		groceeryUser.setCustomerType('E');
		Mockito.when(userDao.findOne(Matchers.anyObject())).thenReturn(
				groceeryUser);
		grocerry.setPrice(3040d);
		Mockito.when(dao.save(grocerry)).thenReturn(grocerry);
		Assert.assertTrue(3040d == impl.getBill(grocerry).getPrice());
	}

	@Test()
	public void testGetBillDate() {
		MyGrocerry grocerry = new MyGrocerry();
		grocerry.setCustId(444l);
		grocerry.setPrice(4343.55d);
		GroceeryUser groceeryUser = new GroceeryUser();
		groceeryUser.setCustomerType('N');
		Calendar calendar = Calendar.getInstance();
		calendar.set(2010, 05, 11);
		groceeryUser.setDateOfReg(calendar.getTime());
		Mockito.when(userDao.findOne(Matchers.anyObject())).thenReturn(
				groceeryUser);
		grocerry.setPrice(3040d);
		Mockito.when(dao.save(grocerry)).thenReturn(grocerry);
		Assert.assertTrue(3040d == impl.getBill(grocerry).getPrice());
	}

}
