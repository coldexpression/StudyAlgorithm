import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if(a>=2 && b>=2 && c<=10000)
        {
            System.out.println((a+b)%c);
            System.out.println(((a%c)+(b%c))%c);
            System.out.println((a*b)%c);
            System.out.println(((a%c)*(b%c))%c);
        }
    }
}