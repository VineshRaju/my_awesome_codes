import java.io.*;

public class Queue{

	public String msg,from,to;
	private Queue next,head=null,current;
	public Queue(){
		next=current=null;
	}
	private Queue(String msg,String from,String to){
		this.msg=msg;
		this.from=from;
		this.to=to;
		next=null;

	}
	public void insert(String msg,String from,String to){
		Queue newnode=new Queue(msg,from,to);
		if(head==null){
			head=newnode;
		}else{
			current.next=newnode;
		}
		current=newnode;
		
	}
	public Queue pop(){
		if(head!=null){
			Queue temp=head;
			head=head.next;
			return temp;
		}else
			return null;
		
	}
	public boolean isEmpty(){
		return head==null?true:false;
	}



}
