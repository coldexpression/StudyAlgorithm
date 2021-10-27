import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int sum,n;
        sum = 0;
        n = sc.nextInt();
        if(n>=1 && n<=10000)
        {
            for(int i=1;i<=n;i++)
            {
                sum = sum+i;
            }
            System.out.println(sum);
        }
    }
}