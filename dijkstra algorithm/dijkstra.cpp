/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 *
 * DIJKSTRA ALGORITHM
 **/
#include <iostream>
using namespace std;

#define MAX 10
#define INFINITY 9999
#define TRUE 1
#define FALSE 0

//Defining a queue data structure (this is necessary to analyse the adjacent nodes one by one)
class Queue{
	int data;
	Queue *next;
public:
	Queue(){
		next=NULL;
	}
	Queue(int value){
		data=value;
		next=NULL;
	}
	void enqueue(int value);
	int dequeue();
	int isEmpty();
}*front=NULL,*rear=NULL;

void Queue :: enqueue(int value){
	Queue *temp=new Queue(value);
	if(front==NULL)
		front=temp;
	else
		rear->next=temp;
	rear=temp;
}
int Queue :: dequeue(){
	Queue *temp=new Queue();
	int val=-1;
	if(front!=NULL){
		temp=front;
		val=temp->data;
		front=front->next;
		delete temp;
	}

	return val;
}

int Queue :: isEmpty(){
	return (front==NULL)?TRUE:FALSE;
}
//here comes the head ache...
class Dijkstra{
	//cost stores the weight of vertices,distance stores the distance of vertices from initial node
	//turn to page no 371 on weiss book for more info
	int cost[MAX][MAX],known[MAX],distance[MAX],path[MAX],nodes;
public:
	Dijkstra(int n){
		nodes=n;
	}
	void compute();
	void createGraph();
	void printPath();
};
//this function gets the input from user
void Dijkstra :: createGraph(){
	char ch;
	int source, destination;

	//this loop is to initilize the values as specified in the book
	//the above class and this function is the answer for ADJACENT MATRIX REPRESENTATION OF GRAPH if the following loop is ignored
	for(int i=0;i<nodes;i++){
		for(int j=0;j<nodes;j++)
			cost[i][j]=-1;
		known[i]=FALSE;
		distance[i]=INFINITY;
		path[i]=-1;
	}
	do{
		cout<<"Enter source node:";
		cin>>source;
		cout<<"Enter destination node:";
		cin>>destination;
		cout<<"Enter weight:";
		cin>>cost[source][destination];
		cout<<"Continue(Y/N):";
		cin>>ch;
	}while(ch=='y'||ch=='Y');

}

void Dijkstra :: compute(){
	Queue queue;
	int initial;
	cout<<"Enter initial node:";
	cin>>initial;


	// STEP 1:
	// set the distance and path column of initial node to 0
	distance[initial]=path[initial]=0;
	//STEP 2:
	//enqueue the initial node
	queue.enqueue(initial);
	//cout<<"The shortest path:"<<endl;
	//cout<<initial<<"-> ";

	//STEP 3:

	while(!queue.isEmpty()){
		//For each node in the queue
		int node=queue.dequeue();
		known[node]=TRUE;
		//find the adjacent nodes
		int adj[MAX],acost[MAX];
		int n=0;
		for(int i=0;i<MAX;i++)
			if(cost[node][i]!=-1){
				adj[n]=i;
				acost[n]=cost[node][i];
				n++;
			}
		//sort those nodes according to their weights in acending order
		int temp;
		for(int i=0;i<n;i++)
			for(int j=i+1;j<n;j++)
				if(acost[i]>acost[j]){
					temp=adj[i];
					adj[i]=adj[j];
					adj[j]=temp;

					temp=acost[i];
					acost[i]=acost[j];
					acost[j]=temp;
				}

		//STEP 4:
		for(int i=0;i<n;i++){
			//If the distance between the nodes is infinity
			if(distance[adj[i]]==INFINITY){
				//then distance on the adjacent node is (distance of parent node+ weight of the path connecting the nodes)
				distance[adj[i]]=distance[node]+cost[node][adj[i]];
				//setting path, (this is unnecessary... but still the book says to do so)
				path[adj[i]]=node;
				//enqueue the adjacent nodes for further analysis
				queue.enqueue(adj[i]);
				//cout<<adj[i]<<", ";
			}
		}
	}

}
void Dijkstra :: printPath(){
	for(int i=0;i<nodes;i++){
		if(path[i]!=-1)
			cout<<"Vertex "<< path[i] <<"to Vertix "<<i<<endl; 
	}
}

//																THE END


int main(){
	Dijkstra graph(7);
	graph.createGraph();
	graph.compute();
	graph.printPath();
}