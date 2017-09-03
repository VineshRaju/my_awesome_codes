import java.io.*;
import java.net.*;
import java.util.Scanner;

class MagSer{
	static boolean serveron=true;
	static Queue messages=new Queue();
	public static Thread send=new Thread(){
		public void run(){
			try{
				Queue newmessage=new Queue();
				while(serveron){
					while(!messages.isEmpty()){
						newmessage=messages.pop();
						System.out.println("Connecting to "+newmessage.to);
						//TODO
						//if not online enqueuing it back;
						Socket client=new Socket(newmessage.to,7363);
						System.out.println("Sending "+ newmessage.msg +" to "+newmessage.to);
						DataOutputStream out=new DataOutputStream(client.getOutputStream());
						out.writeUTF(newmessage.from +": "+newmessage.msg);
						System.out.println("Sent!, Closing");
						client.close();
						System.out.println("Done");
						sleep(100);
					}
					sleep(150);
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				System.out.println("thread send ended");
			}
		}
	};
	public static Thread pick =new Thread(){
		public void run(){
			try{
				ServerSocket server=new ServerSocket(7363);
				while(serveron){
					System.out.println("Ready to pick...");
					Socket get=server.accept();
					System.out.println("Connected to "+get.getRemoteSocketAddress());
					DataInputStream in=new DataInputStream(get.getInputStream());
					System.out.println("Reading from client");
					String from=""+get.getRemoteSocketAddress();
					String to=in.readUTF();
					String msg=in.readUTF();
					System.out.println("Read, Closing");
					get.close();
					System.out.println("Enqueing...");
					messages.insert(msg,from,to);
					System.out.println("Enqueued!");
				}
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				System.out.println("Thread pick ended");
			}
		}
	};
	public static void main(String a[]){
		pick.start();
		send.start();
		
	}
}