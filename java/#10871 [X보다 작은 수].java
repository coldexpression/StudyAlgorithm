import java.util.Scanner;
public class Main{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n,x,i;
        n = sc.nextInt();
        x = sc.nextInt();
        if(n>=1 && x<=10000)
        {
            int[] a = new int[n];
            for(i=0;i<n;i++)
            {
                a[i] = sc.nextInt();
                if(a[i]<1 && a[i]>10000)
                    return ;
            }
            for(i=0;i<n;i++)
            {
                if(a[i]<x)
                    System.out.print(a[i]+" ");
            }
        }
    }
}