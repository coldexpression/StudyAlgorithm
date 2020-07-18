import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i,sum=0;
        int[] score = new int[5];
        for(i=0;i<5;i++)
        {
            score[i] = sc.nextInt();
            if(score[i]<0 && score[i]>100 && (score[i]%5 != 0))
                return ;
            if(score[i]<40)
                score[i] = 40;
        }
        for(i=0;i<5;i++)
            sum = sum+score[i];
        System.out.println(sum/5);
    }
}