package com.fdesign.darksouls.prompts;

import java.util.Scanner;

import com.fdesign.darksouls.daos.UserDao;
import com.fdesign.darksouls.models.User;
import com.fdesign.darksouls.util.AuthUtil;

public class LoginPrompt implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	private UserDao userDao = UserDao.currentImplementation;
	private AuthUtil authUtil = AuthUtil.instance;

	@Override
	public Prompt run() {
		System.out.println("Enter 1 to login");
		System.out.println("Enter 2 to register");
		String choice = scan.nextLine();
		switch(choice) {
		case "1":{
			System.out.println("Enter username: ");
			String username = scan.nextLine();
			System.out.println("Enter password");
			String password = scan.nextLine();
		
		User u = authUtil.login(username, password);
		if(u == null) {
			System.out.println("Invalid Credentials");
			break;
		} else {
			return new MainMenuPrompt();
		}
		}
		case "2": {
			System.out.println("Enter new username: ");
			String username = scan.nextLine();
			scan.nextLine();
			System.out.println("Enter new password");
			String password = scan.nextLine();
			
			User u = new User(1, username, password, "SoulBearer");
			userDao.save(u);
		}
		default:
			System.out.println("clouded judgement, attmept once more");
			break;
		}
		return this;
	}

}
