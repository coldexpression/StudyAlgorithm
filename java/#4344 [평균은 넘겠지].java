import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int c = sc.nextInt();
        int i,j,n,k=0;
        double sum=0,avg,dn=0;
        double[] score;
        for(i=0;i<c;i++)
        {
            n = sc.nextInt();
            sum = 0; avg = 0; k =0;
            if(n<1 && n>1000) return ;
            score = new double[n];
            for(j=0;j<n;j++) {
                score[j] = sc.nextDouble();
                if (score[j] > 100 || score[j] < 0) return;
                sum += score[j];
            }
          //  System.out.println("sum >>"+ sum+"n >>"+n);
            avg = sum/n;
         //   System.out.println("avg>> "+avg);
            for(j=0;j<n;j++)
            {
              if(score[j] > avg) k++;
            }
            //System.out.println("k >>"+k);
            dn = n;
            System.out.printf("%.3f",(k/dn*100));
            System.out.print("%\n");
        }

    }
}