import java.util.Scanner;

class HillCipher
{
    public static void HillciperMethod(String plainText,int[][] keymatrix)
    {
        int [][]message = new int[3][1];
        for (int i = 0; i < 3; i++)
        message[i][0] = (plainText.charAt(i)) % 65;
        int [][]cipherMatrix = new int[3][1];
        encrypt(cipherMatrix, keymatrix, message);
        String CipherText="";
    for (int i = 0; i < 3; i++)
    {
        CipherText += (char)(cipherMatrix[i][0] + 65);
    }
    System.out.print("Ciphertext:" + CipherText);

    }
    private static void encrypt(int[][] cipherMatrix, int[][] keymatrix, int[][] message) {
        int x, i, j;
        for (i = 0; i < 3; i++)
        {
            for (j = 0; j < 1; j++)
            {
                cipherMatrix[i][j] = 0;
             
                for (x = 0; x < 3; x++)
                {
                    cipherMatrix[i][j] +=
                        keymatrix[i][x] * message[x][j];
                }
             
                cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
            }
        }
    }
    public static void main(String args[]) {
        Scanner in=new Scanner(System.in);
        System.out.println("Enter the plainText:");
        String text=in.nextLine();
        System.out.print("enter the no.of rows:");
        int m=in.nextInt();
        System.out.print("enter the no.of columns:");
        int n=in.nextInt();
        int key[][] =new int[m][n];
        System.out.print("Enter the key:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                key[i][j]=in.nextInt();
            }
            
        }
        System.out.print("Plain Text:"+text);
        System.out.println("Matrics:");
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<n;j++)
            {
                System.out.print(key[i][j]+" ");
            }
            System.out.println();
        }
        HillciperMethod(text,key);
        
    }
}