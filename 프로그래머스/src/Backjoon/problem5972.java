package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem5972 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        int ans = Integer.MAX_VALUE;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean[] visited = new boolean[n+1];

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            List<int[]> list = map.getOrDefault(s, new ArrayList<>());
            list.add(new int[]{e, v});
            map.put(s, list);

            list = map.getOrDefault(e, new ArrayList<>());
            list.add(new int[]{s, v});
            map.put(e, list);
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        queue.add(new int[]{1, 0});

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int s = info[0]; int val = info[1];

            if (s == n) {
                ans = Math.min(ans, val);
            }

            visited[s] = true;

            for(int[] next: map.get(s)) {
                if (!visited[next[0]]) {
                    queue.add(new int[]{next[0], val + next[1]});
                }
            }
        }

        System.out.println(ans);
    }
}
