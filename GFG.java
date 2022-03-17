import java.util.Scanner;

class AffineCipher
{
    static int a=17;
    static int b=20;

    static String encryptMessage(char[] plainText)
    {
        String cipher = "";
        for (int i = 0; i < plainText.length; i++)
        {
            if (plainText[i] != ' ')
            {
                cipher = cipher+ (char) ((((a * (plainText[i] - 'A')) + b) % 26) + 'A');
            } else 
            {
                cipher += plainText[i];
            }
        }
        return cipher;
    }
 
    static String decryptCipher(String cipherText)
    {
        String msg = "";
        int a_inv = 0;
        int flag = 0;
        for (int i = 0; i < 26; i++)
        {
            flag = (a * i) % 26;

            if (flag == 1)
            {
                a_inv = i;
            }
        }
        for (int i = 0; i < cipherText.length(); i++)
        {
            if (cipherText.charAt(i) != ' ')
            {
                msg = msg + (char) (((a_inv * ((cipherText.charAt(i) + 'A' - b)) % 26)) + 'A');
            }
            else 
            {
                msg += cipherText.charAt(i);
            }
        }
        return msg;
    }

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Plan Text: ");
        String plainText =sc.nextLine();
        String cipherText = encryptMessage(plainText.toCharArray());
        System.out.println("Encrypted Message is : " + cipherText);
        System.out.println("Decrypted Message is: " + decryptCipher(cipherText));
 
    }
}