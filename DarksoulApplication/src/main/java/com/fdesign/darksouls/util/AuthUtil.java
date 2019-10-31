package com.fdesign.darksouls.util;

import com.fdesign.darksouls.daos.UserDao;
import com.fdesign.darksouls.models.User;

public class AuthUtil {
	public static final AuthUtil instance = new AuthUtil();

	private UserDao userDao = UserDao.currentImplementation;
	private User currentUser = null;
	
	
	public AuthUtil() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public User login(String username, String password) {
		User u = userDao.findByUsernameAndPassword(username, password);
		currentUser = u;
		return u;
	}
	
	public User getCurrentUser() {
		return currentUser;
	}

}
