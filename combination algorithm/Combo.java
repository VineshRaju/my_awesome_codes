/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * Computes all combinations possible with the given word
 **/
import java.io.*;
import java.util.Scanner;
class Combo{
	public static void compute(String s1,String s2){
		if(s2.length()<=1){
			System.out.println(s1+s2);
		}else{
			for(int i=0;i<s2.length();i++){
				String newString=s2.substring(0,i)+s2.substring(i+1);
				compute(s1+s2.charAt(i),newString);
			}

		}
	}
	public static void main(String a[]){
		Scanner in=new Scanner(System.in);
		System.out.println("Enter Word:");
		String name=in.nextLine();
		compute("",name);

	}
}