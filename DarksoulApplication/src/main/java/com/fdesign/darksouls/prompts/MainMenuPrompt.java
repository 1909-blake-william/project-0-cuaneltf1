package com.fdesign.darksouls.prompts;

import java.util.Scanner;

public class MainMenuPrompt implements Prompt {
	
	private Scanner scan = new Scanner(System.in);

	@Override
	public Prompt run() {
			//Can login
			//Can register
			System.out.println("Greetings Bearer of the Curse, what path do you seek");
			System.out.println("Enter 1 to view character");
			System.out.println("Enter 2 to arise character");
			System.out.println("Enter 3 to slumber character");
			System.out.println("Enter 4 to update character");
			System.out.println("Enter 5 to view archieved changes");
			System.out.println("Enter 6 to depart");
			
			String selection = scan.nextLine();
			
			switch (selection) {
			case "1":
				return new ViewCharacterPrompt();
				//currently views all characters
			case "2":
				return new CreateCharacterPrompt();
				//can create new character
			case "3":
				return new DeleteCharacterPrompt();
				//can delete by name and id
			case "4":
				return new UpdateCharacterPrompt();
				//update works but now need to add a archives
			case "5":
//				return new ViewArchievesPrompt();
			case "6":
				return new DepartPrompt();
				//logs out
			default:
				System.out.println("Your judgment falters, gain clarity and take the plunge");
				break;
			}
			return this;
	}

}
