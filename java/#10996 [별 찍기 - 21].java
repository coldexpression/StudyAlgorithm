import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if(n<1 && n>100) return ;
        if(n==1) {
            System.out.print("*");
            return ;
        }
        for(int i=1;i<=n*2;i++)
        {
            if(i%2 != 0)
            {
                for(int j=1;j<=n;j++)
                {
                    if(j%2 != 0)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();

            }
            else if (i%2 == 0)
            {
                for(int j=1;j<=n;j++)
                {
                    if(j%2 == 0)
                        System.out.print("*");
                    else
                        System.out.print(" ");
                }
                System.out.println();

            }
        }
    }
}