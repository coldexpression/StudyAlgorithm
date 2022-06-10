package Backjoon;

import java.util.Scanner;

public class problem2294 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] c = new int[k+1];
        int[] dp = new int[k+1];

        for (int i=0;i<=k;i++) {
            dp[i] = 100001;
            c[i] = 100001;
        }

        for(int i=1;i<=n;i++) {
            int input = sc.nextInt();
            if (input <= k) c[input] = 1;
        }

        for(int i=1;i<=k;i++) {
            dp[i] = c[i];
            for(int j=1;;j++) {
                if (i-j < j || i-j <= 0) break;
                dp[i] = Math.min(dp[i-j]+dp[j], dp[i]);
            }
        }

        dp[k] = dp[k] == 100001 ? -1 : dp[k];
        System.out.println(dp[k]);

    }
}
