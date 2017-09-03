/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * The server part of a echo server
 **/
#include<stdio.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<string.h>
#include<unistd.h>
#include<arpa/inet.h>

#define PORT 8080

int main(int argc, char *argv[]){
	
	int sockfd,connfd;
	struct sockaddr_in seraddr,cliaddr;

	unsigned int len;
	
	char buffer[1024];
	
	sockfd = socket(AF_INET,SOCK_STREAM,0);
	
	if(sockfd == -1){
		printf("Error: SOCKET CREATION FAILED\n");
		return 1;
	}
	
	//bzero(&seraddr,sizeof(seraddr));

	seraddr.sin_family = AF_INET;
	seraddr.sin_port = htons(PORT);
	seraddr.sin_addr.s_addr = htonl(INADDR_ANY);
	
	bind(sockfd,(struct sockaddr*) &seraddr,sizeof(seraddr));
	
	if(listen(sockfd,5)!=0){
		printf("Error: CANNOT LISTEN");
	}
	
	len = sizeof(cliaddr);
	connfd = accept(sockfd,(struct sockaddr *) &cliaddr,&len);

	do{
		
		strcpy(buffer," ");
		
		read(connfd,buffer,1024);
		
		printf("Echoing: %s \n",buffer);
		
		write(connfd,buffer,sizeof(buffer));
	} while(strcmp(buffer,"exit")!=0);
	
	close(sockfd);
	
	return 0;
}
		