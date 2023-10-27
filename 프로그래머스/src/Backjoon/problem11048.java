package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem11048 {
    static int[][] move = {{-1, 0},{-1,-1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = map[0][0];
        for(int i=1;i<n;i++) dp[i][0] = dp[i-1][0] + map[i][0];
        for(int i=1;i<m;i++) dp[0][i] = dp[0][i-1] + map[0][i];

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                for(int k=0;k<3;k++) dp[i][j] = Math.max(dp[i][j], map[i][j] + dp[i+move[k][0]][j+move[k][1]]);
            }
        }
        System.out.println(dp[n-1][m-1]);
    }
}
