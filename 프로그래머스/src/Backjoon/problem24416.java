package Backjoon;

import java.util.Scanner;

public class problem24416 {
    static int recurCount = 0;
    static int dpCount = 0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        recur(n);
        dp(n);
        System.out.println(recurCount + " " + dpCount);

    }

    public static int dp(int n) {
        int[] dp = new int[n+1];
        dp[1] = dp[2] = 1;
        for(int i=3;i<=n;i++) {
            dp[i] = dp[i-1] + dp[i-2];
            dpCount++;
        }
        return 0;
    }

    public static int recur(int n) {
        if (n == 1 || n == 2) {
            recurCount++;
            return 1;
        }
        return recur(n-1) + recur(n-2);
    }
}
