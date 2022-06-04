package Level3;

public class problem12907 {

    public static void main(String[] args) {
        problem12907 problem12907 = new problem12907();
        problem12907.solution(5, new int[]{1,2,5});
    }

    public int solution(int n, int[] money) {
        int answer = 0;
        int[] dp = new int[n+1];

        dp[0] = 1;

        for(int i=0;i<money.length;i++) {
            int useMoney = money[i];
            for(int j=1;j<dp.length;j++) {
                if (j >= useMoney) {
                    dp[j] += dp[j - useMoney];
                }
            }
        }

        answer = dp[n];
        System.out.println(answer);
        return answer;
    }
}
