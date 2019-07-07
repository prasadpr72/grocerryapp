package com.grocerryshop.mygrocerry.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerryshop.mygrocerry.GroccerryException;
import com.grocerryshop.mygrocerry.constants.GrocerryConstats;
import com.grocerryshop.mygrocerry.dao.MyGroceeryDao;
import com.grocerryshop.mygrocerry.dao.UserDao;
import com.grocerryshop.mygrocerry.entity.GroceeryUser;
import com.grocerryshop.mygrocerry.entity.MyGrocerry;
import com.grocerryshop.mygrocerry.service.MyGroceeryService;

@Service
public class MyGroceeryServiceImpl implements MyGroceeryService {

	@Autowired
	private MyGroceeryDao dao;

	@Autowired
	private UserDao userDao;

	@Override
	public MyGrocerry getBill(MyGrocerry grocerry) {
		GroceeryUser groceeryUser = userDao.findOne(grocerry.getCustId());
		if (groceeryUser == null) {
			throw new GroccerryException("UserDoesnt exist");
		} else {
			switch (groceeryUser.getCustomerType()) {
			case 'E':
				Double price1 = grocerry.getPrice()
						- (grocerry.getPrice() * GrocerryConstats.discounts
								.get('E')) / 100;
				grocerry.setPrice(price1);
				break;
			case 'A':
				Double price2 = grocerry.getPrice()
						- (grocerry.getPrice() * GrocerryConstats.discounts
								.get('A') )/ 100;
				grocerry.setPrice(price2);
				break;
			default:
				LocalDate date1 = new Date().toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate();
				Calendar cal = Calendar.getInstance();
				cal.setTime(groceeryUser.getDateOfReg());
				LocalDate date2 = cal.getTime().toInstant()
						.atZone(ZoneId.systemDefault()).toLocalDate();
				if (Period.between(date2, date1).getYears() >= 2) {
					Double count = ((grocerry.getPrice() / 100) * 5);
					Double price3 = grocerry.getPrice() - count;
					grocerry.setPrice(price3);
				}
				break;
			}
		}

		return dao.save(grocerry);
	}

}
