import java.io.*;
import java.net.*;
import java.util.Scanner;
class MagCli{
	static String serverip="192.168.43.216";
	static Scanner in=new Scanner(System.in);
	public static void submit(String msg,String to){
		try{
			//Connecting to server through pick(7425) port, client picks st 7425 port
			Socket send=new Socket(serverip,7425);

			DataOutputStream out=new DataOutputStream(send.getOutputStream());
			//Sending the to-address and message to the server
			out.writeUTF(to);
			out.writeUTF(msg);
			//closeing connection with server
			send.close();
		}catch(Exception e){
			e.printStackTrace();
		}
		
	}

	public static Thread send=new Thread(){
		public void run(){
			try{
				String message="";
				while(!message.equals("LOGOUT")){
					System.out.println("To?");
					String to=in.nextLine();
					System.out.println("Chat!!");
					while(!message.equals("END")||!message.equals("LOGOUT")){
						message=in.nextLine();
						submit(message,to);
						sleep(100);
					}

				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	};

	public static Thread recieve=new Thread(){
		public void run(){
			try{
				//server sends through send(7363) port, client picks at 7363 port
				ServerSocket pick=new ServerSocket(7363);

				while(true){

					Socket get=pick.accept();
					DataInputStream in=new DataInputStream(get.getInputStream());
					System.out.println(in.readUTF());
					get.close();
					sleep(100);
				}
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	};

	public static void main(String a[]){
		send.start();
		recieve.start();
	}

}