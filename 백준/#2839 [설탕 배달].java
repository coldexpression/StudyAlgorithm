import java.util.*;
public class Baekjoon_2839 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j,k,num_5=0,num_3=0,mini=5000;
        ArrayList sum = new ArrayList();
        if(n<3 && n>5000) return;
        for(i=0;;i++)
        {
            num_5 = 5*i;
            if(num_5 > n) break;
            for(j=0;;j++)
            {
                num_3 = 3*j;
                if(num_3 > n) break;
                if((num_5)+(num_3)== n)
                {
                    if(mini > i+j)
                    {
                        mini = i+j;
                    }
                    break;
                }
            }
        }
        if(mini == 5000) System.out.println("-1");
        else System.out.println(mini);
    }
}
