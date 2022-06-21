package Backjoon;

import java.util.*;

public class problem11054 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] A = new int[N];
        int[] dp = new int[N];
        int[] reverseDp = new int[N];
        int maxNum = 0;
        int max = 0;
        int answer = 1;

        for(int i=0;i<N;i++) {
            A[i] = sc.nextInt();
            maxNum = Math.max(maxNum, A[i]);
        }

        for(int i=0;i<N;i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            reverseDp[i] = dp[i];

            max = 0;
            answer = Math.max(answer, reverseDp[i]);
            for (int j = i + 1; j < N; j++) {
                reverseDp[j] = 1;
                for (int k = 0; k < j; k++) {
                    if (A[j] < A[k]) {
                        reverseDp[j] = Math.max(reverseDp[j], reverseDp[k] + 1);
                    }
                }
                max = Math.max(reverseDp[j], max);
            }
            answer = Math.max(answer, max);
        }

        System.out.println(answer);


    }
}
