import java.util.Scanner;
public class Main
{
    public static void main (String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double a,b;
        a = sc.nextDouble();
        b = sc.nextDouble();
        if(a>0 && b<10)
        {
            System.out.println((a/b));
        }
    }
}