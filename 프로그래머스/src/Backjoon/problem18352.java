package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem18352 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            List<Integer> list = map.getOrDefault(start, new ArrayList<>());
            list.add(end);
            map.put(start, list);
        }

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        pq.add(new int[]{x, 0});
        dist[x] = 0;
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int current = info[0]; int currentDist = info[1];

            for(int next: map.getOrDefault(current, new ArrayList<>())) {
                if (dist[next] > currentDist + 1) {
                    dist[next] = currentDist + 1;
                    pq.add(new int[]{next, dist[next]});
                }
            }
         }
        for(int i=0;i<n;i++) if (dist[i] == k) sb.append(i+1).append("\n");

        if (sb.length() == 0) sb.append("-1");
        System.out.print(sb);
    }
}
