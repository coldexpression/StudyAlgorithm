package Level3;

public class problem12900 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for(int i=2;i<n;i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        answer = dp[n-1];
        return answer;
    }
}
