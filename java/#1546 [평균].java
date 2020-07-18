import java.util.Scanner;
public class Main{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i,j;
        double max,newscore=0;
        if(n>1000) return;
        double[] score = new double[n];
        for(i=0;i<n;i++)
        {
            score[i] = sc.nextDouble();
            if(score[i] >100 && score[i]<0) return;
        }
        max = score[0];
        for(i=0;i<n;i++)
        {
            if(max<score[i]) max = score[i];
        }
        for(i=0;i<n;i++)
        {
            score[i] = score[i]/max*100;
            newscore += score[i];
        }
        System.out.println(newscore/n);
    }
}