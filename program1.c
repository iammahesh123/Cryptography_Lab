#include<stdio.h>
#include<string.h>
void main()
{
	char a[]="hello world",output[20];
	int i,length;
	length=strlen(a);
	printf("the ASCII values of XOR operation of string:\n");
	for(i=0;i<length;i++)
	{
		output[i]=a[i]^0;
		printf("%d\t",output[i]);
	
	}
}
