import java.util.*;
import java.io.*;
public class Baekjoon_2231 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n>=1 && n<=1000000) == false) return ;
        div_sum(n);
    }
    public static void div_sum(int n)
    {
        int i,j,sum;
        String st_num;
        String[] cut_num;
        if(n<=10)
        {
            System.out.println(0);
            return ;
        }
        else
        {
            for(i=10;i<n;i++)
            {
                sum = i;
                st_num = Integer.toString(i);
                cut_num = st_num.split("");
                for(j=0;j< cut_num.length;j++)
                {
                    sum+= Integer.parseInt(cut_num[j]);
                    if(sum > n) break;
                }
                if(sum == n)
                {
                    System.out.println(i);
                    return ;
                }
            }
            System.out.println(0);
        }
    }
}
