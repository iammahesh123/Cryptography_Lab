import java.util.Scanner;

class HillCipher2
{
    int[][]keym;
    public void calkeyMatrix(String key,int len)
    {
        keym=new int[len][len];
        int k=0;
        for(int i=0;i<len;i++)
        {
            for(int j=0;j<len;j++)
            {
                keym[i][j]=((int)key.charAt(k))-97;
                k++;
            }
        }
    }
    public int calDeterminant(int A[][],int N)
    {
        int resultofDet;
        switch(N)
        {
            case 1:
            resultofDet=A[0][0];
            break;
            case 2:
            resultofDet=A[0][0]*A[1][1]-A[1][0]*A[0][1];
            break;
            default:
            resultofDet=0;
            for(int j1=0;j1<N;j1++)
            {
                int m[][]=new int[N-1][N-1];
                for(int i=1;i<N;i++)
                {
                    int j2=0;
                    for(int j=0;j<N;j++)
                    {
                        if(j==j1)
                        continue;
                        m[i-1][j2]=A[i][j];
                        j2++;
                    }
                }
                resultofDet += Math.pow(-1.0, 1.0 + j1 + 1.0) * A[0][j1]
                * calDeterminant(m, N - 1);      
    }break;
}
return resultofDet;


    }
    public boolean check(String key,int len)
    {
        calkeyMatrix(key,len);
        int d=calDeterminant(keym,len);
        d=d%26;
        if(d==0)
        {
            System.out.println("Key is not invertible");
            return false;
        }
        else if(d%2==0||d%13==0)
        {
            System.out.println("key is not invertible");
            return false;
        }
        else {return true;}
    }
    public void cofact(int num[][],int f)
    {
        int b[][],fac[][];
        b=new int[f][f];
        fac=new int[f][f];
        int p,q,m,n,i,j;
        for(q=0;q<f;q++)
        {
            for(p=0;p<f;p++)
            {
            m=0;
            n=0;
            for(i=0;i<f;i++)
            {
                for(j=0;j<f;j++)
                {
                    b[i][j]=0;
                    if(i != q && j != p)
                    {
                        b[m][n]=num[i][j];
                        if(n<(f-2))
                        n++;
                        else
                        {
                            n=0;
                            m++;
                        }
                    }
                }
            }
            fac[q][p]=(int)Math.pow(-1, q + p) * calDeterminant(b, f - 1);
        }
        }
        trans(fac,f);

    }
    public void trans(int fac[][],int r)
    {
        int i, j;
        int b[][], inv[][];
        b = new int[r][r];
        inv = new int[r][r];
        int d = calDeterminant(keym, r);
        int mi = mi(d % 26);
        mi %= 26;
        if (mi < 0)
            mi += 26;
        for (i = 0; i < r; i++)
        {
            for (j = 0; j < r; j++)
            {
                b[i][j] = fac[j][i];
            }
        }
        for (i = 0; i < r; i++)
        {
            for (j = 0; j < r; j++)
            {
                inv[i][j] = b[i][j] % 26;
                if (inv[i][j] < 0)
                    inv[i][j] += 26;
                inv[i][j] *= mi;
                inv[i][j] %= 26;
            }
        }
    }
    public void performDivision(String Temp,int s)
    {

    }
    public static void main(String args[]) {
        HillCipher2 obj=new HillCipher2();
        Scanner in=new Scanner(System.in);
        System.out.print("Choose the option: \n1.Encryption\n2.Decryption\n");
        int choice=in.nextInt();
        System.out.println("Enter the string:");
        String line=in.nextLine();
        System.out.println("enter the key:");
        String key=in.nextLine();
        double sq=Math.sqrt(key.length());
        if(sq!=(long)sq)
        System.out.println("cannot the square matrix");
        else{
            int size=(int)sq;
            if(obj.check(key,size))
            {
                System.out.println("result:");
                obj.cofact(obj.keym,size);
                obj.performDivision(line,size);
            }
        }  
    }
}