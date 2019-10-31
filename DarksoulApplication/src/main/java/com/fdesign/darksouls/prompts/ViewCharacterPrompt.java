package com.fdesign.darksouls.prompts;

import java.util.List;

import com.fdesign.darksouls.daos.DarksoulDao;
import com.fdesign.darksouls.daos.UserDao;
import com.fdesign.darksouls.models.Darksoul;
import com.fdesign.darksouls.models.User;
import com.fdesign.darksouls.util.AuthUtil;

public class ViewCharacterPrompt implements Prompt {
	
	private DarksoulDao darkDao = DarksoulDao.currentImplementation;
	private AuthUtil authUtil = AuthUtil.instance; 

	@Override
	public Prompt run() {
		//How do I call upon the user model to access the get id constructor to use to filter out characters we see
		List<Darksoul> allDarksoul = darkDao.findAll();
		for(Darksoul d: allDarksoul) {
			System.out.println(d);
		}
		return new MainMenuPrompt();
	}

}
