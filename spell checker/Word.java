import java.util.Scanner;
import java.io.*;
public class Word{
//returns the no of lines in the given file
	public int noOfLines(File ansfile){
		int line=0;
		try{
			 Scanner in=new Scanner(ansfile);

			 while(in.hasNextLine()){
				in.nextLine();
				line++;
			}
		in.close();

		}catch(Exception e){
			e.printStackTrace();
		}
		
		return line;
	}
//returns a 2d array containing the words in the given file in the format [index of line][index of word]
	public String[][] splitWords(File ansfile){

		String words[][]=null;;
		try{
			 Scanner ans=new Scanner(ansfile);
			 //sent is to store each line in the file
			 String sent[]=new String[noOfLines(ansfile)];
			
			//reading each sentence and storing it in sent 
			 for(int i=0;ans.hasNextLine();i++){
			 	sent[i]=ans.nextLine();
			}
			
			words=new String[sent.length][];
			
			for(int i=0;i<sent.length;i++){
				words[i]=sent[i].split("[ ,.!?:/-]");
			}	

		}catch(Exception e){
			e.printStackTrace();
		}

		return words;
	}
}
