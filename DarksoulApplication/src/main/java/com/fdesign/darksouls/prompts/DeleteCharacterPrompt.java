package com.fdesign.darksouls.prompts;

import java.util.Scanner;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.models.User;
import com.fdesign.darksouls.util.AuthUtil;

public class DeleteCharacterPrompt implements Prompt {
	
	Scanner scan = new Scanner(System.in);
	private DarksoulDao darksoulDao = DarksoulDao.currentImplementation;
	AuthUtil authUtil = AuthUtil.instance;

	@Override
	public Prompt run() {

		System.out.println("Enter character name: ");
		String r = scan.nextLine();
		
		User x = authUtil.getCurrentUser();
		int f = x.getId();
		System.out.println(f);
		
		darksoulDao.releaseForm(r, f);
		return new MainMenuPrompt();
	}

}
