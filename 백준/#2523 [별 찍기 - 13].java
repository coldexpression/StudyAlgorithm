import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,j;
        int n = sc.nextInt();
        if(n<1 && n>100) return ;
        for(i=0;i<(2*n-1);i++)
        {
            if(i<n)
            {
                for(j=0;j<=i;j++)
                    System.out.print("*");
                System.out.println();
            }
            else
            {
                for(j=(2*n-1);j>i;j--)
                    System.out.print("*");
                System.out.println();
            }
        }

    }
}