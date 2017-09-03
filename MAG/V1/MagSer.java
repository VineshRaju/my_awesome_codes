/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * Server side of a client server chat program
 **/
import java.net.*;
import java.io.*;
import java.util.*;

public class MagSer{
	private static DataInputStream incomming;
	private static DataOutputStream outgoing;
	private static String send=new String(" ");
	private static String recieve=new String(" ");
	public static void main(String args[]) throws IOException{
		Scanner in=new Scanner(System.in);
		//System.out.println("Enter port num:");
		//int port=in.nextInt();
		ServerSocket server=new ServerSocket(1254);
		System.out.println("Waiting for client on "+server.getLocalPort());
		Socket client=server.accept();
		System.out.println(client.getRemoteSocketAddress()+" Connected");
		Thread income=new Thread(){
			public void run(){
				while(!recieve.equals("END")){
				try{
					//System.out.println("Income");
					incomming=new DataInputStream(client.getInputStream());
					recieve=incomming.readUTF();
					System.out.println("\t\t\t"+recieve);
					sleep(100);
				}catch(Exception e){
					System.out.println("Incomming error");
				}
				}
				System.out.println("Client has logged out");
			}
		};
		Thread outgo=new Thread(){
			public void run(){
				while(!send.equals("END")){
				try{
					//System.out.println("Outgo");

					outgoing=new DataOutputStream(client.getOutputStream());
					send=in.nextLine();
					outgoing.writeUTF(send);
					sleep(100);
				}catch(Exception e){
					System.out.println("Outgoing error");
				}
				}
				System.out.println("You Logged out");
				
			}
		};

		income.start();
		outgo.start();
	}
}