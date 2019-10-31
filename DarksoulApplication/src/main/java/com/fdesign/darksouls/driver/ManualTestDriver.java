package com.fdesign.darksouls.driver;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.daos.UserDao;

public class ManualTestDriver {
	
	public static void main(String[] args) {
		UserDao userDao = UserDao.currentImplementation;
		DarksoulDao darkDao = DarksoulDao.currentImplementation;
		
		System.out.println("all darksoul");
		
		darkDao.findAll().forEach(darksoul ->{
			System.out.println(darksoul);
		});
		
	}

}
