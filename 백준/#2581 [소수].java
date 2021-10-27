import java.util.*;
public class Baekjoon_2581 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j,sum=0,cnt=0,min=0;
        boolean check=false;
        int m = sc.nextInt();
        int n = sc.nextInt();
        if(((m<1 && m>10000) || (n<1 && n>10000)) || (m>n)) return;
        min = 10000;
        for(i=m;i<=n;i++)
        {
            check = false;
            for(j=2;j<=i;j++)
            {
                if(i==2)
                {
                   // System.out.println("접근");
                    cnt++;
                    sum +=i;
                    min = i;
                    break;
                }
                if(i%j==0)
                {
                    break;
                }
                else if(i%j!=0 && j ==(i-1))
                    check = true;
            }
            if(check == true)
            {
                    sum+=i;
                    cnt++;
                    if(min > i) min = i;
            }
        }
        if(cnt == 0)
        {
            System.out.println("-1");
        }
        else {
            System.out.println(sum);
            System.out.println(min);
        }
    }
}
