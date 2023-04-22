package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem2698 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(st.nextToken());
        int[][][] dp = new int[101][101][2];

//        for(int i=2;i<=100;i++) {
//            dp[i][i-1][0] = 0;
//            dp[i][i-1][1] = 1;
//        }

        dp[1][0][0] = dp[1][0][1] = 1;

        for(int i=1;i<=100;i++)
            for(int j=1;j<=100;j++) {
                if (dp[i][j][1] == 1) System.out.println("["+i+","+j+"]");
            }

        for(int j=0;j<=100;j++) {
            for (int i = 2; i <= 100; i++) {
                if (j == 0) dp[i][j][1] = dp[i-1][j][0];
                else dp[i][j][1] = dp[i - 1][j][0] + dp[i - 1][j - 1][1];
                dp[i][j][0] = dp[i - 1][j][0] + dp[i - 1][j][1];
            }
        }
        for(int i=0;i<t;i++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            sb.append(dp[n][k][0] + dp[n][k][1]).append("\n");
        }
        System.out.println(sb);
    }
}
