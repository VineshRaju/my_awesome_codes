/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * Client side of a client server chat program
 **/
import java.net.*;
import java.io.*;
import java.util.*;

public class MagCli{
	private static DataInputStream incomming;
	private static DataOutputStream outgoing;
	private static String send=new String(" ");
	private static String recieve=new String(" ");
	public static void main(String args[]) throws IOException{
		Scanner in=new Scanner(System.in);
		System.out.println("Enter port no:");
		int port=in.nextInt();
		Socket client=new Socket("192.168.1.3",port);
		System.out.println("Connected!");
		Thread income=new Thread(){
			public void run(){
				while(!recieve.equals("END")){
				try{
					incomming=new DataInputStream(client.getInputStream());
					recieve=incomming.readUTF();
					System.out.println("\t\t\t"+recieve);
					sleep(100);
				}catch(Exception e){
					System.out.println("Incomming error");
					break;
				}
				}
				System.out.println("Host logged out");
			}
		};
		Thread outgo=new Thread(){
			public void run(){
				while(!send.equals("END")){
				try{

					outgoing=new DataOutputStream(client.getOutputStream());
					send=in.nextLine();
					outgoing.writeUTF(send);
					sleep(100);
				}catch(Exception e){
					System.out.println("Outgoing error");
					break;
				}
				}
				System.out.println("You Logged out");
				
			}
		};

		income.start();
		outgo.start();
	}

}