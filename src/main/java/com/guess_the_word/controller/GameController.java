package com.guess_the_word.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.guess_the_word.service.GameService;

@Controller
public class GameController {

	@Autowired
	GameService service;

	@GetMapping("/homepage")
	public String showHomePage(Model model) {

		String randomWord = service.toString();

		model.addAttribute("wordToDisplay", randomWord);

		return "home-page";
	}
}
