import java.util.Scanner;
public class Baekjoon_11720 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n;
        String a = null;
        String[] st;
        int i,sum=0;
        n = sc.nextInt();
        if(n<1 && n>100) return ;
        a = sc.next();
        st = a.split("");
        if(a.length() != n) return ;
        for(i=0;i<n;i++)
        {
            sum += Integer.parseInt(st[i]);
        }
        System.out.println(sum);
    }
}
