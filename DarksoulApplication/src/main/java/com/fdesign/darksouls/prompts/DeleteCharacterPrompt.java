package com.fdesign.darksouls.prompts;

import java.util.Scanner;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.util.AuthUtil;

public class DeleteCharacterPrompt implements Prompt {
	
	Scanner scan = new Scanner(System.in);
	private DarksoulDao darksoulDao = DarksoulDao.currentImplementation;
	AuthUtil authUtil = AuthUtil.instance;

	@Override
	public Prompt run() {

		System.out.println("Enter character name: ");
		String name = scan.nextLine();
		
		Darksoul r = new Darksoul(name, authUtil.getCurrentUser());
		//getting the wrong constructor
		System.out.println(r);
		darksoulDao.release(r);
		return new MainMenuPrompt();
	}

}
