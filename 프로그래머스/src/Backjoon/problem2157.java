package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2157 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] dp = new int[m+1][n];
        int[][] score = new int[n][n];

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            if (start > end) continue;

            score[start][end] = Math.max(score[start][end], weight);
        }

        for(int i=0;i<=m;i++) Arrays.fill(dp[i], Integer.MIN_VALUE);
        dp[1][0] = 0;
        for(int current=0;current<n;current++) {
            for(int visCount=1;visCount<m;visCount++) {
                if (dp[visCount][current] == Integer.MIN_VALUE) continue;

                for(int next=current+1;next<n;next++) {
                    if (score[current][next] == 0) continue;

                    dp[visCount+1][next] = Math.max(dp[visCount+1][next], dp[visCount][current] + score[current][next]);
                }
            }
        }
        int ans = 0;
        for(int i=1;i<=m;i++) {
            ans = Math.max(ans, dp[i][n-1]);
        }
        System.out.println(ans);
    }
}
