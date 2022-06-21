package Backjoon;

import java.util.*;

public class problem11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] dp = new int[N];
        int[] map = new int[N];
        int max = Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            map[i] = sc.nextInt();
        }

        dp[0] = 1;
        max = dp[0];
        for(int i=1;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if (map[i] > map[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            max = Math.max(max, dp[i]);
        }

        System.out.println(max);
    }
}
