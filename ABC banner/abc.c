/**
 * Author:    Vinesh Raju R
 * 
 * Copyright (c) 2017 Vinesh Raju R
 *
 * This prints out the entered word with #, (Only Upper case letters word :P)
 **/
#include<stdio.h>
#include<string.h>
int main(){
	int i;
	char str[32],pattern[][20]={" # \n# #\n###\n# #","#\n###\n# #\n###"," ##\n#\n#\n ##","##\n# #\n# #\n##","##\n###\n#\n###","###\n#\n##\n#"," ##\n#\n# #\n ##","# #\n###\n# #\n# #","###\n #\n #\n###"," ##\n  #\n# #\n #","# #\n##\n##\n# #","#\n#\n#\n###","# #\n###\n# #\n# #","#\n###\n# #\n# #"," #\n# #\n# #\n #","##\n# #\n##\n#"," ##\n# #\n ##\n  #","###\n# #\n#\n#"," ##\n#\n ##\n###","###\n #\n #\n #","# #\n# #\n# #\n###","# #\n# #\n# #\n #","# #\n# #\n###\n# #","# #\n #\n #\n# #","# #\n# #\n #\n #","###\n  #\n #\n###"};
    printf("Enter a Name:");
    scanf("%s",str);
    for(i=0;i<strlen(str);i++){
        
        printf("%s\n\n",pattern[(int)str[i]%65]);
    }
	return 0;
}
