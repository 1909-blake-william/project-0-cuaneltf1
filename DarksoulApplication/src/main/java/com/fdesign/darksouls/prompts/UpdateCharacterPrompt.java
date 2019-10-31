package com.fdesign.darksouls.prompts;

import java.util.Scanner;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.models.User;
import com.fdesign.darksouls.util.AuthUtil;

public class UpdateCharacterPrompt implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	DarksoulDao darksoulDao = DarksoulDao.currentImplementation;
	AuthUtil authUtil = AuthUtil.instance;

	@Override
	public Prompt run() {
		System.out.println("Enter character to imbue with darkness: ");
		String h = scan.nextLine();
		
		System.out.println("Enter new vitality count");
		int a = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new endurance count");
		int b = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new strength count");
		int cc = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new dexterity count");
		int d = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new intelligence count");
		int ee = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new level count");
		int g = scan.nextInt();
		scan.nextLine();
		
		User x = authUtil.getCurrentUser();
		int i = x.getId();
		
		darksoulDao.updateForm(a, b, cc, d, ee, g, h, i);

		return new MainMenuPrompt();
	}

}
