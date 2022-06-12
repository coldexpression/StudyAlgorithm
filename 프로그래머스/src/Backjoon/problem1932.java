package Backjoon;

import java.util.*;

public class problem1932 {

    public static void main(String[] args) {
        problem1932 problem1932 = new problem1932();
        problem1932.solution(5, new int[]{7,3,8,8,1,0,2,7,4,4,15,15,20,25,27});
    }

    public int solution(int n, int[] number) {
        int answer = Integer.MIN_VALUE;
        int start = 3;
        int end = 5;
        int dst = 4;
        int line = 2;
        int middle = 3;
        int[] dp = new int[number.length];
        dp[0] = 0;
        dp[1] = number[0]+number[1];
        dp[2] = number[0]+number[2];
        n *= 3;

        for(int i=3;i<n;i++) {
            if (i > start && i < end) {
                dp[i] = Math.max(dp[i-middle] + number[i], dp[i-middle+1] + number[i]);
            } else {
                if (start == i) dp[i] = dp[i-line] + number[i];
                else if (end == i) {
                    dp[i] = dp[i-(line+1)] + number[i];
                    line++;
                    middle++;
                    start = end + 1;
                    end += dst++;
                }
            }
            answer = Math.max(dp[i], answer);
        }

        for(int i=0;i<n;i++) System.out.print(dp[i] + " ");

        System.out.println(answer);
        return answer;
    }
}
