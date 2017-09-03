/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 * The client part of a echo server
 **/
#include<stdio.h>
#include<sys/socket.h>
#include<netinet/in.h>
#include<string.h>
#include<unistd.h>
#include<arpa/inet.h>

#define PORT 8080

int main(int argc, char *argv[]){
	
	int sockfd;
	struct sockaddr_in seraddr;
	
	char buffer[1024];
	
	sockfd = socket(AF_INET,SOCK_STREAM,0);
	
	if(sockfd == -1){
		printf("Error: SOCKET CREATION FAILED\n");
		return 1;
	}

	//memset(&seraddr,0,sizeof(seraddr));

	seraddr.sin_family = AF_INET;
	seraddr.sin_port = htons(PORT);
	seraddr.sin_addr.s_addr = htonl(INADDR_ANY);

	
	if(connect(sockfd,(struct sockaddr*) &seraddr,sizeof(seraddr))<0){
		printf("Error: CANNOT CONNECT TO SERVER");
		return -1;
	}
	
	printf("Enter a Strings(exit to EXIT):");

	do{				
		scanf("%s",buffer);
	
		write(sockfd,buffer,sizeof(buffer));

		read(sockfd,buffer,sizeof(buffer));
		printf("Echo:%s \n",buffer);
	} while(strcmp(buffer,"exit")!=0);
	
	close(sockfd);
	
	return 0;
}
		