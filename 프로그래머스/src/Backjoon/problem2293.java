package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2293 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");

        int n = Integer.parseInt(word[0]);
        int k = Integer.parseInt(word[1]);

        int[] coin = new int[n];
        int[] dp = new int[k+1];

        for(int i=0;i<n;i++) coin[i] = Integer.parseInt(bf.readLine());

        Arrays.sort(coin);
        dp[0] = 1;

        for(int i=0;i<coin.length;i++) {
            int value = coin[i];

            for(int j=1;j<dp.length;j++) {
                if (j-value >= 0) dp[j] = dp[j] + dp[j-value];
            }
        }

        System.out.println(dp[dp.length-1]);


    }



}