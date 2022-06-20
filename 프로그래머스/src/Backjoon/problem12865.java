package Backjoon;

import java.util.*;

public class problem12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();
        int[][] dp = new int[N+1][K+1];
        int[] weight = new int[N+1];
        int[] values = new int[N+1];
        int min = Integer.MAX_VALUE;
        int max = 0;

        for(int i=1;i<=N;i++) {
            weight[i] = sc.nextInt();
            values[i] = sc.nextInt();
            min = Math.min(min, weight[i]);
        }


        for(int i=min;i<=K;i++) {
            max = 0;
            for(int j=1;j<=N;j++) {
                if (i - weight[j] >= 0) {
                    dp[j][i] = Math.max(dp[j-1][i - weight[j]] + values[j], Math.max(max, dp[j-1][i]));
                } else {
                    dp[j][i] = max;
                }
                max = Math.max(max, dp[j][i]);
            }
        }

        for(int i=0;i<dp.length;i++) {
            for(int j=0;j<dp[i].length;j++) {
                System.out.print("["+dp[i][j]+"]");
            }
            System.out.println();
        }

        System.out.println(dp[N][K]);
    }
}
