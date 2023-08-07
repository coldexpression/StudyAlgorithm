package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1446 {

    static int ans;
    public static void main(String[] args) throws IOException {
        HashMap<Integer, List<int[]>> map = new HashMap<>();
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int[] dp = new int[d+1];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dst = Integer.parseInt(st.nextToken());
            List<int[]> list = map.getOrDefault(start, new ArrayList<>());
            list.add(new int[]{end, dst});
            map.put(start, list);
        }
        for(int i=0;i<=d;i++) dp[i] = i;

        for(int start=0;start<=d;start++) {
            if (d > start && dp[start+1] > dp[start] + 1) {
                dp[start + 1] = dp[start] + 1;
            }
            for (int[] info : map.getOrDefault(start, new ArrayList<>())) {
                if (info[0] > d) continue;
                if (dp[start] + info[1] < dp[info[0]]) {
                    dp[info[0]] = dp[start] + info[1];
                }
            }
        }
        System.out.println(dp[d]);
    }
}
