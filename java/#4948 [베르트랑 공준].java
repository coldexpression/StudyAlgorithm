import java.util.*;
public class Baekjoon_4948 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int i,j,n,count;
        boolean check = false;
        while(true)
        {

            count = 0;
            n=sc.nextInt();
            if(n==0) return;
            if(n<0 || n>123456) return;
            for(i=n+1;i<=2*n;i++)
            {
                check = false;
                for(j=2;j<=Math.round(Math.sqrt(i));j++)
                {
                    if(i%j==0) {
                        check = false;

                        break;
                    }
                    else if(i%j!=0)
                    {
                        check = true;

                    }
                }
                if(i==2) count++;
                if(check == true) {
                    count++;
                }
            }
                System.out.println(count);
        }
    }
}
