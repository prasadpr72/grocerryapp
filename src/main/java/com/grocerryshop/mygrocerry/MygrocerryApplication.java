package com.grocerryshop.mygrocerry;

import java.util.Calendar;
import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.grocerryshop.mygrocerry.dao.UserDao;
import com.grocerryshop.mygrocerry.entity.GroceeryUser;

@SpringBootApplication
public class MygrocerryApplication {

	public static void main(String[] args) {
		SpringApplication.run(MygrocerryApplication.class, args);
	}

	@Bean
	CommandLineRunner getCommandLineRunner(UserDao dao) {
		{
			return args -> {
				Calendar calendar = Calendar.getInstance();
				calendar.set(2010, 05, 11);
				Date d1 = calendar.getTime();
				calendar.set(2011, 05, 11);
				Date d2 = calendar.getTime();
				calendar.set(2014, 05, 11);
				Date d3 = calendar.getTime();
				calendar.set(2018, 05, 11);
				Date d4 = calendar.getTime();
				dao.save(new GroceeryUser("Customer1", d1, 'A'));
				dao.save(new GroceeryUser("Customer2", d2, 'E'));
				dao.save(new GroceeryUser("Customer3", d3, 'N'));
				dao.save(new GroceeryUser("Customer4", d4, 'E'));
				dao.findAll().stream().forEach(e->System.out.println(e.getCustId()+"::"+e.getDateOfReg()));
			};
		}

	}

}
