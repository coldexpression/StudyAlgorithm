package Level2;

public class problem12902 {

    public static void main(String[] args) {

    }

    public int solution(int n) {
        int answer = 0;
        int[] dp = new int[n+1];

        dp[0] = 1;
        dp[2] = 3;
        dp[4] = 11;

        for(int i=6;i<=n;i++) {
            dp[i] = (dp[i-2] * 3) % 1000000007;
            for(int j=i-4;j>=0;j=j-2) {
                dp[i] += (dp[j] * 2) % 1000000007;
            }
        }


        answer = dp[n];
        return answer;
    }
}