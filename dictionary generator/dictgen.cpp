/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 *
 * Looks like I've tried to generate a dictionary of distinct words seperated by blank space
 **/

#include<iostream>
#include<fstream>
#include<string>
using namespace std;
string strlwr(string s){
	string temp;
	for(int i=0;i<s.length();i++){
		temp+=(char)tolower(s[i]);
	}
	return temp;
}
int main(){
	ifstream input;
	input.open("/Users/vineshraju/Desktop/word.txt");
	fstream out("/Users/vineshraju/Desktop/words.txt",ios::app);
	string word[300000];
	for(unsigned int i=0;i<300000;i++){
		input>>word[i];
		word[i]=strlwr(word[i]);
	}
	input.close();
	for(unsigned int i=0;i<300000;i++){
			if(word[i]!=word[i+1])
				out<<word[i]+" ";
		}
		
	}
