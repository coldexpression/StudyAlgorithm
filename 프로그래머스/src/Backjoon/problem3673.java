package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem3673 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int c = Integer.parseInt(st.nextToken());
        int[] countArr = new int[50001];

        countArr[2] = 1;
        for(int i=3;i<countArr.length;i++) {
            countArr[i] = countArr[i-1] + i-1;
        }

        for (int t = 0; t < c; t++) {
            HashMap<Long, Integer> map = new HashMap<>();
            st = new StringTokenizer(bf.readLine());
            int ans = 0;
            int zeroCount = 0;

            int d = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());

            int[] arr = new int[n];
            boolean[] visited = new boolean[n+1];

            st = new StringTokenizer(bf.readLine());

            for (int i = 0; i < n; i++)
                arr[i] = Integer.parseInt(st.nextToken());

            long[] sum = new long[n + 1];
            sum[1] = arr[0] % d;


            for (int i = 1; i < n; i++) {
                sum[i + 1] = (sum[i] + arr[i]) % d;
            }

            for(int i=1;i<=n;i++) {
                map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
            }

            for(long key: map.keySet()) {
                if (key == 0) ans += map.get(key);

                if (map.get(key) >= 2) {
                    ans += countArr[map.get(key)];
                }
            }

            sb.append(ans).append(" ");
        }
        System.out.println(sb.toString());
    }
}