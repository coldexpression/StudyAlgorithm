package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2169 {
    static int[][] map;
    static int[][] dp;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        dp = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = map[0][0];
        // 가장 첫번째 줄은 왼쪽으로만 이동이 가능하다.
        for(int i=1;i<m;i++) dp[0][i] = dp[0][i-1] + map[0][i];
        for(int i=1;i<n;i++) {
            int[][] innerDp = new int[2][m];
            // 오 -> 왼쪽으로만 이동 하는 경우
            for(int j=0;j<m;j++) {
                if (j==0) innerDp[0][j] = dp[i-1][j] + map[i][j];
                else innerDp[0][j] = Math.max(innerDp[0][j-1], dp[i-1][j]) + map[i][j];
            }
            // 왼 -> 오른쪽으로만 이동 하는 경우
            for(int j=m-1;j>=0;j--) {
                if (j==m-1) innerDp[1][j] = dp[i-1][j] + map[i][j];
                else innerDp[1][j] = Math.max(innerDp[1][j+1], dp[i-1][j]) + map[i][j];
            }

            for(int j=0;j<m;j++) dp[i][j] = Math.max(innerDp[0][j], innerDp[1][j]);
        }

        System.out.println(dp[n-1][m-1]);
    }

}
