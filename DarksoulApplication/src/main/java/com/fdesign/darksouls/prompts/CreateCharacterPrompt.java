package com.fdesign.darksouls.prompts;

import java.util.List;
import java.util.Scanner;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.daos.DarksoulTypeDao;
import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.models.DarksoulType;
import com.fdesign.darksouls.util.AuthUtil;

public class CreateCharacterPrompt implements Prompt {
	
	private Scanner scan = new Scanner(System.in);
	private DarksoulTypeDao darksoulTypesDao = DarksoulTypeDao.currentImplementation;
	private DarksoulDao darksoulDao = DarksoulDao.currentImplementation;
	private AuthUtil authUtil = AuthUtil.instance;

	@Override
	public Prompt run() {
		List<DarksoulType> types = darksoulTypesDao.findAll();
		System.out.println("Name your character: ");
		String name = scan.nextLine();
		System.out.println("Select character type from the following: ");
		for(int i = 0; i< types.size(); i++) {
			System.out.println("Enter " + i + " for " + types.get(i).getName());
		}
		int typeSelection = scan.nextInt();
		DarksoulType type = types.get(typeSelection);
		scan.nextLine();
		
		System.out.println("Enter vitality count");
		int vitality = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter endurance count");
		int endurance = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter strength count");
		int strength = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter dexterity count");
		int dexterity = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter intelligence count");
		int intelligence = scan.nextInt();
		scan.nextLine();
		
		System.out.println("Enter level count");
		int level = scan.nextInt();
		scan.nextLine();
		
		Darksoul d = new Darksoul(0, name, vitality, endurance, strength, dexterity, intelligence, level, type, authUtil.getCurrentUser());
		darksoulDao.save(d);
		return new MainMenuPrompt();
	}

}
