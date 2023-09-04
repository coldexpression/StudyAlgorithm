package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class problem1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(bf.readLine());
        StringBuilder sb = new StringBuilder();
        long[][] dp = new long[2][41];
        dp[0][0] = 1;
        dp[1][1]= 1;
        dp[0][2] = 1;
        dp[1][2] = 1;
        for(int i=3;i<=40;i++) {
            dp[0][i] = dp[0][i-2] + dp[0][i-1];
            dp[1][i] = dp[1][i-2] + dp[1][i-1];
        }

        for(int i=0;i<t;i++) {
            int n = Integer.parseInt(bf.readLine());
            sb.append(dp[0][n]).append(" ").append(dp[1][n]).append("\n");
        }
        System.out.print(sb);
    }

}
