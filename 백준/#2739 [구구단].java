import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        if(n>=1 && n<=9)
        {
            for(int i=1;i<10;i++)
            {
                System.out.println(n + " * " + i + " = "+n*i);
            }
        }
    }
}