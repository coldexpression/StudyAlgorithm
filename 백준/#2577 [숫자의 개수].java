import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a,b,c,i,j,k;
        String num;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if((a<100 && a>1000) || (b<100 && b>1000) || (c<100 && c>1000)) return;
        num = Integer.toString(a*b*c);
        String[] real = num.split("");
        String fakei;
        for(i=0;i<=9;i++)
        {
            k=0;
            for(j=0;j<real.length;j++)
            {
                fakei = Integer.toString(i);
                if(fakei.equals(real[j]))
                {
                    k++;
                }
            }
            System.out.println(k);
        }
    }
}