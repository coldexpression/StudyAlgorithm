package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.StringTokenizer;

public class problem1005 {
    static HashMap<Integer, List<Integer>> edgeMap;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int T = Integer.parseInt(st.nextToken());
        for(int t=1;t<=T;t++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] times = new int[n+1];
            int[] dp = new int[n+1];
            boolean[] visited = new boolean[n+1];
            edgeMap = new HashMap<>();
            st = new StringTokenizer(bf.readLine());
            for(int i=1;i<=n;i++) times[i] = Integer.parseInt(st.nextToken());
            for(int i=0;i<k;i++) {
                st = new StringTokenizer(bf.readLine());
                int start = Integer.parseInt(st.nextToken());
                int end = Integer.parseInt(st.nextToken());

                List<Integer> list = edgeMap.getOrDefault(end, new ArrayList<>());
                list.add(start);
                edgeMap.put(end, list);
            }
            st = new StringTokenizer(bf.readLine());
            int w = Integer.parseInt(st.nextToken());
            dfs(visited, dp, times, w, w, times[w]);
            sb.append(dp[w]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(boolean[] visited, int[] dp, int[] times, int prev, int current, int sum) {
        if (!edgeMap.containsKey(current)) {
            System.out.println("끝점 도달 => " + current);
            dp[current] = Math.max(dp[current], times[current]);
            System.out.println("끝점 값 : " + dp[current]);
            return;
        }

        for(int next: edgeMap.get(current)) {
            if (!visited[next]) {
                visited[next] = true;
                dfs(visited, dp, times, current, next, sum + times[next]);
                dp[current] = Math.max(dp[next] + times[current], dp[current]);
            } else {
                dp[current] = Math.max(dp[next] + times[current], dp[current]);
            }
            System.out.println("prev : " + prev + ", current : " + current + ", next : " + next);
            System.out.println("바깥 값 : " + dp[current]);
        }
    }
}
