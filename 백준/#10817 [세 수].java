import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a,b,c;
        a = sc.nextInt();
        b = sc.nextInt();
        c = sc.nextInt();
        if((a<1 && a>100) || (b<1 && b>100) || (c<1 && c>100)) return;
        if((b<=a && a<=c) || (c<=a && a<=b))
            System.out.println(a);
        else if ((a<=b && b<=c) || (c<=b && b<=a))
            System.out.println(b);
        else
            System.out.println(c);

    }
}