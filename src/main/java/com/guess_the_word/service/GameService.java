package com.guess_the_word.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameService {

	private String randomlyChoosenWord = null;

	private String[] words = { "father", "mother", "hello", "world", "java", "mysql", "python", "oracle" };

	private char[] allCharactersOfTheword;

	Random random = new Random();

	public GameService() {

		randomlyChoosenWord = words[random.nextInt(words.length)];
		System.out.println("Random Word is : " + randomlyChoosenWord);
		allCharactersOfTheword = new char[randomlyChoosenWord.length()];
	}

	@Override
	public String toString() {

		String ret = "";

		for (char c : allCharactersOfTheword) {
			if (c == '\u0000') {
				ret = ret + "_";
			}
			else {
				ret = ret + c;
			}
			
			ret = ret + ' ';
		}
		return ret;

	}

	public boolean addGuess(char guessedChar) {

		boolean isGuessCorrect = false; 
		
		for (int i = 0; i < randomlyChoosenWord.length(); i++) {
		
			if(guessedChar == randomlyChoosenWord.charAt(i)) {
				
				allCharactersOfTheword[i] = guessedChar;
				isGuessCorrect = true;
			}
		}
		return isGuessCorrect;
	}
}
