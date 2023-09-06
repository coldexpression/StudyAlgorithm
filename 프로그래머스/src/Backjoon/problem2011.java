package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class problem2011 {
    static int MOD = 1000000;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        int[] arr = new int[input.length()];
        long[][] dp = new long[input.length()][2];

        for(int i=0;i<input.length();i++) arr[i] = Character.getNumericValue(input.charAt(i));
        if (arr[0] == 0) System.out.println(0);
        else {
            dp[0][0] = 1;

            for (int i = 1; i < arr.length; i++) {
                if (arr[i] == 0) {
                    dp[i][1] = arr[i-1] == 1 || arr[i-1] == 2 ? dp[i-1][0] % MOD : 0;
                } else {
                    dp[i][0] = (dp[i-1][0] % MOD) + (dp[i-1][1] % MOD);
                    if ((arr[i-1] == 1 && arr[i] > 0 && arr[i] <= 9) || (arr[i-1] == 2 && arr[i] > 0 && arr[i] <= 6)) {
                        dp[i][1] = (dp[i-1][0] % MOD);
                    }
                }
            }
            System.out.println(((dp[dp.length - 1][0] % MOD) + (dp[dp.length - 1][1] % MOD)) % MOD);
        }
    }
}
