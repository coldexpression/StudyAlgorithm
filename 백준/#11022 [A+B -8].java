import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i;
        int t = sc.nextInt();
        int[] a = new int[t];
        int[] b = new int[t];
        for(i=0;i<t;i++)
        {
            a[i] = sc.nextInt();
            b[i] = sc.nextInt();
        }
        for(i=0;i<t;i++)
        {
            if(a[i]>0 && b[i]<10)
            {
                System.out.println("Case #"+(i+1)+": "+a[i]+" + "+b[i]+" = "+(a[i]+b[i]));
            }
        }
    }
}