package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem5557 {
    static final int MAX_NUM = 9*99*2+1;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];
        long[][] dp = new long[MAX_NUM][n+1];
        st = new StringTokenizer(bf.readLine());
        for(int i=1;i<=n;i++) arr[i] = Integer.parseInt(st.nextToken());

        int div = (MAX_NUM-1)/2;
        dp[arr[1]+div][1] = 1;

        for(int i=2;i<n;i++) {
            int num = arr[i];
            for(int j=0;j<MAX_NUM;j++) {
                if (dp[j][i - 1] != 0) {
                    int rs = j - div;
                    if (rs + num >= 0 && rs + num <= 20) dp[j + num][i] += dp[j][i - 1];
                    if (rs - num >= 0 && rs - num <= 20) dp[j - num][i] += dp[j][i - 1];
                }
            }
        }
        System.out.println(dp[arr[n]+div][n-1]);
    }
}
