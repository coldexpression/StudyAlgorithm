package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem1149 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] score = new int[N][3];
        int[][] dp = new int[N][3];

        for(int i=0;i<N;i++) {
            for(int j=0;j<3;j++) {
                score[i][j] = sc.nextInt();
            }
        }

        for(int i=0;i<3;i++) dp[0][i] = score[0][i];

        for(int i=1;i<N;i++) {
            for(int j=0;j<3;j++) {
                if (j==0) {
                    dp[i][j] = Math.min(dp[i-1][j+1], dp[i-1][j+2]) + score[i][j];
                } else if (j==1) {
                    dp[i][j] = Math.min(dp[i-1][j-1], dp[i-1][j+1]) + score[i][j];
                } else {
                    dp[i][j] = Math.min(dp[i-1][j-2], dp[i-1][j-1]) + score[i][j];
                }
            }
        }

        int ans = Arrays.stream(dp[N-1]).min().getAsInt();

        System.out.println(ans);




    }
}
