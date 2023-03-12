package Backjoon;

import java.util.Scanner;

public class problem9461 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        for(int i=0;i<T;i++) {
            int N = sc.nextInt();
            long[] dp = new long[N+1];

            for(int j=1;j<=N;j++) {
                if (j >= 1 && j <= 3) dp[j] = 1;
                else if (j >= 4 && j<= 5) dp[j] = 2;
                else if (j == 6) dp[j] = 3;
                else if (j == 7) dp[j] = 4;
                else if (j == 8) dp[j] = 5;
                else if (j == 9) dp[j] = 7;
                else if (j == 10) dp[j] = 9;
                else {
                    dp[j] = dp[j-1] + dp[j-5];
                }
            }

            System.out.println(dp[N]);
        }
    }
}
