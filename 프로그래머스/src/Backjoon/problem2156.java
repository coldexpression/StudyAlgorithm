package Backjoon;

import java.util.Scanner;

public class problem2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = 0;
        int[] table = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1;i<=n;i++) table[i] = sc.nextInt();

        dp[1] = table[1];
        answer = dp[1];
        if (n >= 2) {
            dp[2] = table[1] + table[2];
            answer = Math.max(answer, dp[2]);
        }

        for(int i=3;i<=n;i++) {
            dp[i] = Math.max(dp[i-1],Math.max(table[i] + dp[i-2], table[i] + table[i-1] + dp[i-3]));
            answer = Math.max(answer, dp[i]);
        }

        System.out.println(answer);
    }
}
