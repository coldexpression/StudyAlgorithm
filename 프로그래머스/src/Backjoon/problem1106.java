package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1106 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        int c = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int size = 1101;
        long[] dp = new long[size];
        Arrays.fill(dp, Integer.MAX_VALUE);
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            int price = Integer.parseInt(st.nextToken());
            int human = Integer.parseInt(st.nextToken());
            map.put(human, price);
            for(int j=1;human*j<size;j++) {
                dp[human*j] = Math.min(dp[human*j], price*j);
            }
        }

        System.out.println(Arrays.toString(dp));
        for(int i=1;i<size;i++) {
            for(int j=1;j<i;j++) {
                dp[i] = Math.min(dp[i], dp[i-j] + dp[i]);
            }
            for (int human : map.keySet()) {
                int price = map.get(human);
                if (i - human > 0) {
                    dp[i] = Math.min(dp[i], dp[i-human]+price);
                }
            }
//            System.out.println("[" + i + "] :" + Arrays.toString(dp));
        }
        long ans = Long.MAX_VALUE;
        for(int i=size-1;i>=c;i--) ans = Math.min(ans, dp[i]);
        System.out.println(ans);
    }
}
