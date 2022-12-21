package Backjoon;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class problem1912 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] dp = new int[N+1];
        int[] arr = new int[N+1];

        for(int i=1;i<=N;i++) arr[i] = sc.nextInt();

        dp[1] = arr[1];

        for(int i=2;i<=N;i++) {
            if (i == 2) {
                dp[i] = Math.max(arr[1]+arr[2], arr[2]);
            } else {
                dp[i] = Math.max(dp[i-1]+arr[i], arr[i]);
            }
        }

        int answer = Integer.MIN_VALUE;
        for(int i=1;i<=N;i++) answer = Math.max(answer, dp[i]);
        System.out.println(answer);
    }
}
