package com.guess_the_word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.guess_the_word.service.GameService;
import com.guess_the_word.utils.GameUtils;

@Controller
public class GameController {

	@Autowired
	private GameService service;

	@Autowired
	private GameUtils utils;

	@GetMapping("/homepage")
	public String showHomePage(@RequestParam(value = "guessedChar", required = false) String guessedChar, Model model) {

		String randomWord = service.toString();

		if (guessedChar != null) {
			
			boolean isGuessCorrect = service.addGuess(guessedChar.charAt(0));

			randomWord = service.toString();

			if (isGuessCorrect == false) {
				utils.reduceTry();
			}
		}

		//System.out.println("Number of Tries Remaining : "+utils.getTriesRemaining());
		
		model.addAttribute("wordToDisplay", randomWord);
		
		model.addAttribute("triesLeft",utils.getTriesRemaining());
		
		return "home-page";
	}
}
