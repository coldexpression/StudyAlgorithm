package Level3;

import java.util.*;

public class problem42898 {

    public static void main(String[] args) {
        problem42898 problem42898 = new problem42898();
        problem42898.solution(4, 3, new int[][]{{2,2}});
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++)
            for(int j=0;j<m;j++)
                dp[i][j] = -1;
        for(int i=0;i<n;i++) dp[i][0] = 1;
        for(int i=0;i<m;i++) dp[0][i] = 1;
        System.out.println("최대 X : " + m + " 최대 Y : " + n);
        for(int i=0;i<puddles.length;i++) {
            int col = puddles[i][0] - 1;
            int row = puddles[i][1] - 1;
            System.out.println("col : " + col + " row : " + row);
            if (row == 0) {
                for(int j=col;j<m;j++) dp[row][j] = 0;
            } else if (col == 0) {
                for(int j=row;j<n;j++) dp[j][col] = 0;
            } else dp[row][col] = 0;
        }

        if (m == 1) {
            for(int i=0;i<n;i++) {
                if (dp[i][0] == 0) return 0;
                else answer = 1;
            }
        } else if (n == 1) {
            for(int i=0;i<m;i++) {
                if (dp[0][i] == 0) return 0;
                else answer = 1;
            }
        } else {
            for (int i = 1; i < n; i++) {
                for (int j = 1; j < m; j++) {
                    if (dp[i][j] != 0) {
                        dp[i][j] = (dp[i - 1][j] + dp[i][j - 1]) % 1000000007;
                    }
                }
            }
        }

        for(int i=0;i<n;i++) {
            System.out.println();
            for (int j = 0; j < m; j++) {
                System.out.print("["+dp[i][j]+"]");
            }
        }
        System.out.println();
        System.out.println(dp[n-1][m-1]);
        return answer;
    }

}
