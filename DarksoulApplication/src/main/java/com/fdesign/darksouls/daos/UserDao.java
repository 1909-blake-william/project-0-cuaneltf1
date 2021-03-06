package com.fdesign.darksouls.daos;

import java.util.List;

import com.fdesign.darksouls.models.User;

public interface UserDao {
	
	UserDao currentImplementation = new UserDaoSQL();
	
	int save(User u);
	
	List<User> findAll();
	
	User findById();
	
	User findByUsernameAndPassword(String username, String password);
	
	User findByUsername(String username);

}
