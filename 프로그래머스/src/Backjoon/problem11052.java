package Backjoon;

import java.util.Scanner;

public class problem11052 {

    public static void main(String[] args) {
        problem11052 problem11052 = new problem11052();
        problem11052.solution(4, new int[]{3,5,15,16});
    }

    public int solution(int n, int[] prevStore) {
        int answer = 0;
        int[] dp = new int[n+1];
        int[] store = new int[n+1];
        for(int i=1;i<=n;i++) store[i] = prevStore[i-1];
        dp[1] = store[1];
        dp[2] = Math.max(store[1]*2, store[2]);
        dp[3] = Math.max(dp[2]+store[1], store[3]);

        for(int i=3;i<=n;i++) {
            dp[i] = store[i];
            for(int j=1;;j++) {
                if (i-j < j) break;
                dp[i] = Math.max(dp[i], dp[i-j] + dp[j]);
            }
        }
        answer = dp[n];
        for (int i : dp) {
            System.out.println(i);
        }
        return answer;
    }
}
