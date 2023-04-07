package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1135 {
    static HashMap<Integer, List<Integer>> graph;
    static int[] dp;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        graph = new HashMap<Integer, List<Integer>>();
        n = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(bf.readLine());
        st.nextToken();

        for (int i = 1; i < n; i++) {
            int index = Integer.parseInt(st.nextToken());
            List<Integer> list = graph.getOrDefault(index, new ArrayList<Integer>());
            list.add(i);
            graph.put(index, list);
        }

        dp = new int[n];
        Arrays.fill(dp, Integer.MIN_VALUE);

        for (int index = n - 1; index >= 0; index--) {
            // 자식이 없으면 값은 1
            if (!graph.containsKey(index))
                dp[index] = 0;
            else
            // 자식이 있으면 로직 실행
            {
                List<Integer> list = graph.get(index);
                PriorityQueue<Integer> queue = new PriorityQueue<Integer>((o1, o2) -> o2 - o1);
                int scoreBox = list.size();
                int weight = 1;
                for(int child: list) queue.add(dp[child]);
                while(!queue.isEmpty()) {
                    dp[index] = Math.max(dp[index], queue.poll()+(weight++));
                }
            }
        }
        System.out.println(dp[0]);
    }

}