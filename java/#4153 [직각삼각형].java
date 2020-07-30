import java.util.*;
public class Baekjoon_4153 {
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int[] x= new int[3];
        int i,max,max_index,sum,exit;
        while(true) {
            max = 0;
            max_index = 0;
            sum = 0;
            exit = 0;
            for(i=0;i<x.length;i++)
            {
                x[i] = sc.nextInt();
                if((x[i]>0 && x[i]<30000)==false) return ;
                if(max<x[i])
                {
                    max = x[i];
                    max_index = i;
                }
            }
            for(i=0;i<x.length;i++)
            {
                exit += x[i];
            }
            if(exit == 0) return;
            for(i=0;i<x.length;i++)
            {
                if(i != max_index)
                {
                    sum += x[i]*x[i];
                }
            }
            if(sum == (x[max_index]*x[max_index])) System.out.println("right");
            else System.out.println("wrong");
        }
    }
}
