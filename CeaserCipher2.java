import java.util.Scanner;
class CeaserCipher2
{
    public static String Encrypt(String text,int value)
    {
        StringBuffer TempResult=new StringBuffer();
        for(int i=0;i<text.length();i++)
        {
            char temp=(char)(((int)text.charAt(i)+value-97)%26+97);
}
            return TempResult.toString();
    }
    public static String Decrpyt(String text,int value)
    {
        StringBuffer TempResult2=new StringBuffer();
        for(int i=0;i<text.length();i++)
        {
            char temp2=(char)(((int)text.charAt(i)-value-97)%26+97);
            TempResult2.append(temp2);

        }
        return TempResult2.toString();
    }
    public static void main(String args[])
    {
        String result,result2,input;
        Scanner scan=new Scanner(System.in);
        System.out.print("Enter the Input String:");
        String in=scan.nextLine();
        input=in.toLowerCase();
        System.out.print("Enter the shift:");
        int shift=scan.nextInt();
        result=Encrypt(input,shift);
        System.out.println("Encryption of given text is:"+result);
        result2=Decrpyt(result,shift);
        System.out.println("Decryption of given text is:"+result2);
}
}
