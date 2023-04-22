package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem17404 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int[][] score = new int[n][3];
        int[][] dp = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            score[i][0] = Integer.parseInt(st.nextToken());
            score[i][1] = Integer.parseInt(st.nextToken());
            score[i][2] = Integer.parseInt(st.nextToken());
        }
        dp[0][0] = Integer.MAX_VALUE;
        dp[0][1] = Integer.MAX_VALUE;
        dp[0][2] = Integer.MAX_VALUE;
        int ans = Integer.MAX_VALUE;

        for (int pick = 0; pick < 3; pick++) {
            init(dp);
            dp[0][pick] = score[0][pick];
            for (int i = 1; i < n; i++) {
                for (int j = 0; j < 3; j++) {
                    if (j == 0) {
                        if (dp[i - 1][j + 1] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + score[i][j]);
                        if (dp[i - 1][j + 2] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 2] + score[i][j]);
                    } else if (j == 1) {
                        if (dp[i - 1][j - 1] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + score[i][j]);
                        if (dp[i - 1][j + 1] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j + 1] + score[i][j]);
                    } else {
                        if (dp[i - 1][j - 2] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 2] + score[i][j]);
                        if (dp[i - 1][j - 1] != Integer.MAX_VALUE)
                            dp[i][j] = Math.min(dp[i][j], dp[i - 1][j - 1] + score[i][j]);
                    }
                }
            }

            for (int i = 0; i < 3; i++)
                if (i != pick) ans = Math.min(ans, dp[n - 1][i]);
        }
        System.out.println(ans);
    }

    public static void init(int[][] dp) {
        for (int i = 0; i < dp.length; i++)
            Arrays.fill(dp[i], Integer.MAX_VALUE);
    }
}
