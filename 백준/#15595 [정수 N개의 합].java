import java.util.Scanner;
public class Baekjoon_15596 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i;
        long sumnum = 0;
        int n = sc.nextInt();
        if(n<1 && n>3000000) return ;
        int[] a = new int[n];
        for(i=0;i<n;i++)
        {
            a[i] = sc.nextInt();
            if(a[i] <0 && a[i] > 1000000) return;
        }
        sumnum = sum(a);
        System.out.println(sumnum);


    }
    public static long sum(int[] a)
    {
        int j;
        long realsum=0;
        for(j=0;j<a.length;j++)
        {
            realsum += a[j];
        }
        return realsum;

    }
}
