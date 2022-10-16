package Level3;

import java.util.HashMap;

public class problem131129 {
    public static void main(String[] args) {
        problem131129 problem131129 = new problem131129();
        problem131129.solution(2023);
    }

    public int[] solution(int target) {
        int[][] dp = new int[target+1][target+1];
        int[] answer = new int[2];

        for(int i=1;i<=target;i++) {
            if (i <= 20 || i == 50) {
                dp[i][0] = 1;
                dp[i][1] = 1;
            } else if (i <= 60 && i % 3 == 0) {
                dp[i][0] = 1;
                dp[i][1] = 0;
            } else if (i <= 40 && i % 2 == 0) {
                dp[i][0] = 1;
                dp[i][1] = 0;
            } else if (i >= 51 && i <= 70) {
                dp[i][0] = 2;
                dp[i][1] = 2;
            } else if (i < 70) {
              if (i < 40) {
                  dp[i][0] = 2;
                  dp[i][1] = 2;
              } else {
                  dp[i][0] = 2;
                  dp[i][1] = 1;
              }
            } else {
                int a1 = dp[i-50][0];
                int a2 = dp[i-50][1];
                int b1 = dp[i-60][0];
                int b2 = dp[i-60][1];
                if (a1 < b1) {
                    dp[i][0] = a1 + 1;
                    dp[i][1] = a2 + 1;
                } else if (a1 > b1) {
                    dp[i][0] = b1 + 1;
                    dp[i][1] = b2;
                } else {
                    dp[i][0] = a1+1;
                    dp[i][1] = Math.max(a2+1,b2);
                }
            }
        }
        answer[0] = dp[target][0];
        answer[1] = dp[target][1];
        System.out.println("["+answer[0]+","+answer[1]+"]");
        return answer;
    }
}
