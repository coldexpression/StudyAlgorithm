package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class problem2342 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int ans = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        list.add(0);
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num == 0) break;
            list.add(num);
        }
        int[][][] dp = new int[list.size()][5][5];

        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < 5; j++) Arrays.fill(dp[i][j], 100000000);
        }

        dp[0][0][0] = 0;
        for (int i = 0; i < list.size() - 1; i++) {
            int nextNum = list.get(i+1);
            // 왼발 순회
            for (int j = 0; j < 5; j++) {
                // 오른발 순회
                for (int k = 0; k < 5; k++) {

                    // 고정할 오른발과 돌릴 왼발이 같은 칸에 있으면 안되므로 nextNum != j
                    if (nextNum != j) {
                        // 오른발을 다음에 이동할 번호로 고정
                        dp[i + 1][j][nextNum] = Math.min(dp[i + 1][j][nextNum], dp[i][j][k] + calc(k, nextNum));
                    }

                    // 고정할 왼발과 돌릴 오른발이 같은 칸에 있으면 안되므로 nextNum != k
                    if (nextNum != k) {
                        // 왼발을 다음에 이동할 번호로 고정
                        dp[i + 1][nextNum][k] = Math.min(dp[i + 1][nextNum][k], dp[i][j][k] + calc(j, nextNum));
                    }
                }
            }
        }

        for (int i = 0; i < 5; i++)
            for (int j = 0; j < 5; j++)
                ans = Math.min(ans, dp[list.size()-1][i][j]);
        System.out.println(ans);
    }

    public static int calc(int n1, int n2) {
        if (n1 - n2 == 0) return 1;
        if (n1 == 0) return 2;
        if (Math.abs(n1 - n2) == 2) return 4;
        return 3;
    }
}