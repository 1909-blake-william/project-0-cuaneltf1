package com.fdesign.darksouls.driver;

import org.apache.log4j.Logger;

import com.fdesign.darksouls.prompts.LoginPrompt;
import com.fdesign.darksouls.prompts.Prompt;

public class DarksoulDriver {
	
	private static Logger log = Logger.getRootLogger();
	
	public static void main(String[] args) {
		Prompt p = new LoginPrompt();
		
		while(true) {
			log.debug("starting prompt of type: " + p.getClass());
			p = p.run();
			log.debug("next prompt is of type: " + p.getClass());
		}
	}

}
