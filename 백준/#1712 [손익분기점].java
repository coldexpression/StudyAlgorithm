import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        long a,b,c;
        long i=1;
        long product=0; long realproduct=0;
        a = sc.nextLong();
        b = sc.nextLong();
        c = sc.nextLong();
        if(a<0 && a>2100000000 || b<0 && b>2100000000 || c<0 && c>2100000000) return ;
        product = a;
        while(true)
        {
            if (b>=c) {
                System.out.println("-1");
                break;
            }
            product = product+b;
            realproduct = c*i;
            if(realproduct >product)
            {
                System.out.println(i);
                break;
            } 
            i++;
        }
    }
}