/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * Driver program for the spell checker
 **/
import java.util.Scanner;
import java.io.*;
public class Test {
	public static void main(String a[]) {
		try{		
			File ansfile=new File("input.txt");
			Word word=new Word();
			SpellChecker checker = new SpellChecker();
			String words[][]=word.splitWords(ansfile);
			for(int i=0;i<words.length;i++){
				for(int j=0;j<words[i].length;j++){
					if(!checker.isCorrect(words[i][j]))
					System.out.println(words[i][j] + " is wrong");
				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}

	}
}
