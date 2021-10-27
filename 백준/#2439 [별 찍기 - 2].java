import java.util.Scanner;
public class Main{
     public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int n1 = n;
        if(n>=1 && n<=100)
        {
            for(int i=0;i<=n;i++) {
                for (int j = 0; j < i; j++) {
                    if(j==0) {
                        for (int k = 0; k < n1; k++)
                            System.out.print(" ");
                    }
                    System.out.print("*");
                }
                n1--;
                if (i != 0)
                    System.out.println();
            }
        }
    }
}