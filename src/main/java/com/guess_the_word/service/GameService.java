package com.guess_the_word.service;

import java.util.Random;

import org.springframework.stereotype.Service;

@Service
public class GameService {

	private String[] words = { "father", "mother", "hello", "world", "java", "mysql", "python", "oracle" };

	Random random = new Random();
	
	public String toString() {
	
		//System.out.println(words.length);
		
		return words[random.nextInt(words.length)];
		
	}
}
