import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] num = new int[10];
        int[] sum = new int[10];
        int[] real = new int[10];
        int i,j,k=0;
        for(i=0;i<10;i++) sum[i] = -1;
        for(i=0;i<10;i++)
        {
            num[i] = sc.nextInt();
            if(num[i] >1000 && num[i] <0) return;
            sum[i] = num[i]%42;
            for(j=0;j<i;j++)
            {
                if(sum[j] == sum[i]) 
                {
                    sum[i] = -1;
                    break;
                }
            }
        }
        for(i=0;i<10;i++)
        {
            if(sum[i] != -1)
            {
                k++;
            }
        }
        System.out.println(k);
    }
}