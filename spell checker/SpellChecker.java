/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * Very primitive and inefficient Spell Checker
 **/

import java.io.*;
import java.util.Scanner;

public class SpellChecker {

//dict is a 2d String array it holds each word in the dictonary file
//dict[index of line][index of word]
	private String dict[][];
	Word word=new Word();
// Constructor to load the dictionary into dict
	SpellChecker() {
		try {
			File wordlist = new File("words.txt");
			dict = word.splitWords(wordlist);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean isCorrect(String word) {

		for(int i=0;i<dict.length;i++)
			for(int j=0;j<dict[i].length;j++)
				if (dict[i][j].equals(word.toLowerCase())) {
					return true;
				} 
		return false;
	}
	

}