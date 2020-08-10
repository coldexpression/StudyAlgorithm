import java.util.*;
import java.io.*;
public class Baekjoon_7568 {
    static boolean[] check;
    public static void main(String[] args)
    {
        int i,we_index;
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        if((n>=2 && n<=50) == false) return ;
        int[] weight = new int[n];
        int[] height = new int[n];
        int[] score = new int[n];
        check = new boolean[n];
        for(i=0;i<n;i++)
        {
            weight[i] = sc.nextInt();
            height[i] = sc.nextInt();
            check[i] = false;
            if((weight[i]>=10 && weight[i]<=200)==false || (height[i]>=10 && height[i]<=200)==false)
                return ;
        }
        we_index = 51;
        for(i=0;i<weight.length;i++)
        {
            we_index = min_weight(weight,we_index);
            score[we_index] = Compare_data(weight,height,we_index);
        }
        for(i=0;i<score.length;i++)
        {
            System.out.print(score[i]+" ");
        }
    }
    public static int Compare_data(int[] weight,int[] height,int except_index)
    {
        int i,cnt=0;
        for(i=0;i<weight.length;i++)
        {
            if(except_index != i)
            {
                if(weight[i] > weight[except_index] && height[i] > height[except_index])
                {
                    cnt++;
                }
            }
        }
        return cnt+1;
    }
    public static int min_weight(int[] weight,int except_index)
    {
        int i,we_min=201,we_index=0,find_index;
        for(i=0;i< weight.length;i++) {
            if (except_index != i && check[i] ==false) {
                if (weight[i] < we_min) {
                    we_min = weight[i];
                    we_index = i;
                }
            }
        }
        find_index = we_index;
        check[find_index] = true;
        return find_index;
    }
}
