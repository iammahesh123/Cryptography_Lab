#include<stdio.h>
#include<string.h>
void main()
{
	char sample[]="hello world",output[20];
	int i,length;
	length=strlen(sample);
	printf("XOR operation:\n");
	for(i=0;i<length;i++)
	{
		output[i]=sample[i]^127;
		printf("%d\t",output[i]);
	}
	printf("\nAfter AND operation:\n");
	for(i=0;i<length;i++)
	{
		output[i]=sample[i]&127;
		printf("%d\t",output[i]);
	}
	printf("\nAfter the OR operation:\n");
	for(i=0;i<length;i++)
	{
		output[i]=sample[i]|127;
		printf("%c",output[i]);
	}


}
