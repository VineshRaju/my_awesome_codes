/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * 
 * X) This was used to duplicate document numbers back when a friend and me where organising a ton of documents
 **/
import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;

class DupeWarn{
	public static void main(String args[]){
		Scanner in = new Scanner(System.in);
		ArrayList<String> list = new ArrayList<String>();
		String temp = new String();
		do{
			temp= in.nextLine();
			if(list.contains(temp)){
				System.out.println("DUPLICATE!");
			}else{
				list.add(temp);
			}

		}while(!temp.equals("END"));
	}
}