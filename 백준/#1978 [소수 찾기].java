import java.util.*;
public class Baekjoon_1978 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int k,j,i,input,count=0,realcnt=0;
        int n = sc.nextInt();
        if(n<0 && n>100) return ;
        for(i=0;i<n;i++)
        {
            count=0;
            input = sc.nextInt();
            if(input<1 && input>1000) return ;
            for(j=1;j<=input;j++)
            {
                for(k=1;k<=input;k++)
                {
                    if(input == 1) break;
                    else if(input == j*k)
                    {
                        count++;
                    }
                }
            }
            if(count==2) realcnt++;
        }
        System.out.println(realcnt);
    }
}
