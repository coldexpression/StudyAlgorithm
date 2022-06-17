package Backjoon;

import java.util.*;

public class problem11066 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t= sc.nextInt();
        for(int d=0;d<t;d++) {
            int K = sc.nextInt();
            int[][] dp = new int[K+1][K+1];
            int[] sum = new int[K+1];

            for(int j=1;j<=K;j++) {
                int input = sc.nextInt();
                if (j == 1) sum[j] = input;
                else sum[j] = sum[j-1] + input;
            }

            for(int i=1;i<=K;i++) {
                for(int start=1;start+i<=K;start++) {
                    int end = start + i;
                    dp[start][end] = Integer.MAX_VALUE;
                    for(int middle = start;middle<end;middle++) {
                        dp[start][end] = Math.min(dp[start][end], dp[start][middle] + dp[middle+1][end] + sum[end] - sum[start - 1]);
                    }
                }
            }
            System.out.println(dp[1][K]);

        }
    }
}
