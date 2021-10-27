import java.util.Scanner;

public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int a,b;
        a = sc.nextInt();
        b = sc.nextInt();
        if(a>= -10000 && b<= 10000)
        {
            if(a>b)
                System.out.println(">");
            if(a<b)
                System.out.println("<");
            if(a==b)
                System.out.println("==");
        }
    }
}