import java.util.*;
public class Baekjoon_2775 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int i,j,h,n,k,people=0;
        int[] num; int[] real;
        for(i=0;i<t;i++)
        {
            k = sc.nextInt(); //호수
            n = sc.nextInt(); //층수
            num = new int[n+1];
            real = new int[n+1];
            for(j=1;j<=n;j++)
                num[j] = j;
            if(k>=1 && k<=14 && n>=1 && n<=14)
            {
                if(n==1) {
                    System.out.println(1);
                }
                else if(n != 1 && k != 0){
                    for (h = 1; h <= k; h++) {
                        real[1] = 1;
                        for (j = 2; j <= n; j++)
                            real[j] = plus(num, j);
                      for(j=0;j<real.length;j++)
                          num[j] = real[j];
                    }
                    System.out.println(real[n]);
                }

            } else
                return ;


        }
    }
    public static int plus(int[] input,int j)
    {
        int i,sum=0;
        for(i=1;i<=j;i++) {
            sum += input[i];
           // System.out.println("sum >> "+sum+" input >> "+input[i]);
        }
        return sum;
    }
}
