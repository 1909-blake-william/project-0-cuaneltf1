package com.fdesign.darksouls.prompts;

import java.util.Scanner;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.util.AuthUtil;

public class UpdateCharacterPrompt implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	DarksoulDao darksoulDao = DarksoulDao.currentImplementation;
	AuthUtil authUtil = AuthUtil.instance;

	@Override
	public Prompt run() {
		System.out.println("Enter character to imbue with darkness: ");
		String name = scan.nextLine();
		
		System.out.println("Enter new vitality count");
		int vitality = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new endurance count");
		int endurance = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new strength count");
		int strength = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new dexterity count");
		int dexterity = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new intelligence count");
		int intelligence = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter new level count");
		int level = scan.nextInt();
		scan.nextLine();
		
		Darksoul r = new Darksoul(name, authUtil.getCurrentUser());
		System.out.println(r);
		Darksoul up = new Darksoul(vitality, endurance, strength, dexterity, intelligence, level);
		System.out.println(up);
		return new MainMenuPrompt();
	}

}
