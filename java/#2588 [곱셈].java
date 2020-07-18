import java.util.Scanner;
public class Main{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int a,b,c,d,e;
        a = sc.nextInt();
        b = sc.nextInt();
        c = b/100;
        d = (b-(c*100))/10;
        e = (b-(c*100))%10;
        System.out.println(a*e);
        System.out.println(a*d);
        System.out.println(a*c);
        System.out.println(a*b);
    }
}