import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,max,min;
        int n = sc.nextInt();
        if(n<1 && n>1000000) return ;
        int[] a = new int[n];
        for(i=0;i<n;i++) {
            a[i] = sc.nextInt();
            if(a[i]< -1000000 && a[i]> 1000000) return ;
        }
        max = a[0];
        min = a[0];
        for(i=0;i<n;i++)
        {
            if(max<a[i]) max = a[i];
            if(min>a[i]) min = a[i];
        }
        System.out.println(min+" "+max);
    }
}