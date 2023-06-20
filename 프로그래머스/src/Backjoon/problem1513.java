package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1513 {
    static final int MOD = 1000007;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        long[][][][] dp = new long[n][m][c+1][c+1];
        int flag = 0;
        for(int i=0;i<c;i++) {
            st = new StringTokenizer(bf.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            map[row][col] = i + 1;
            if (row == 0 && col == 0) flag = i + 1;
        }
        // [row, col, 오락실의 번호, 오락실을 방문한 순서]
        dp[0][0][flag][flag == 0 ? 0 : 1] = 1;
        for(int i=1;i<m;i++) {
            flag = map[0][i];
            if (flag == 0) {
                for(int j=0;j<c+1;j++)
                    for(int k=0;k<c+1;k++) dp[0][i][j][k] = dp[0][i-1][j][k] % MOD;
            } else {
                for(int j=1;j<=flag;j++) {
                    if (j == 1) dp[0][i][flag][j] = dp[0][i-1][0][0] % MOD;
                    else for(int k=0;k<flag;k++) dp[0][i][flag][j] += dp[0][i-1][k][j-1] % MOD;

                }
            }
        }

        for(int i=1;i<n;i++) {
            flag = map[i][0];
            if (flag == 0) {
                for(int j=0;j<c+1;j++)
                    for(int k=0;k<c+1;k++) dp[i][0][j][k] = dp[i-1][0][j][k] % MOD;
            } else {
                for(int j=1;j<=flag;j++) {
                    if (j == 1) dp[i][0][flag][j] = dp[i-1][0][0][0] % MOD;
                    else for(int k=0;k<flag;k++) dp[i][0][flag][j] += dp[i-1][0][k][j-1] % MOD;

                }
            }
        }

        for(int i=1;i<n;i++) {
            for(int j=1;j<m;j++) {
                flag = map[i][j];
                if (flag == 0) {
                    for(int h=0;h<c+1;h++)
                        for(int k=0;k<c+1;k++) dp[i][j][h][k] = dp[i-1][j][h][k] % MOD + dp[i][j-1][h][k] % MOD;
                } else {
                    for(int h=1;h<=flag;h++) {
                        if (h == 1) dp[i][j][flag][h] = dp[i-1][j][0][0] % MOD + dp[i][j-1][0][0] % MOD;
                        else for(int k=0;k<flag;k++) dp[i][j][flag][h] += dp[i-1][j][k][h-1] % MOD + dp[i][j-1][k][h-1] % MOD;
                    }
                }
            }
        }


        for(int i=0;i<=c;i++) {
            long count = 0;
            for(int j=0;j<=c;j++) count += dp[n-1][m-1][j][i] % MOD;
            sb.append(count).append(" ");
        }
        System.out.println(sb);
    }
}
