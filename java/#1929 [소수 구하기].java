import java.util.*;
public class Baekjoon_1929 {
    public static void main(String[] args)
    {
        int i,j,cnt=0;
        boolean check=false;
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        if((m>=1 && m<=n && n<= 1000000) == false) return ;
        for(i=m;i<=n;i++)
        {
            check = false;
          //  System.out.println("come in");
            for(j=2;j<=Math.round(Math.sqrt(i));j++)
            {
             //   System.out.println("i >> "+i+" sqrt >> "+Math.round(Math.sqrt(i)));

             //   System.out.println("j >> "+j);
                if(i==2)
                {
                    cnt++;
                    System.out.println(i);
                    break;
                }
                if(i%j==0) {
                    check = false;
                    if(cnt>=1) {
                        cnt--;
                    }
                    break;
                }
                else if(i%j!=0)
                {
                    check = true;
                    cnt++;
                }
            }
            if(i==2) System.out.println("2");
            if(check == true) {
                 System.out.println(i);
            }
        }
        if(cnt==0) return;
    }
}
