package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1939 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] dist = new int[n];
        HashMap<Integer, HashMap<Integer, Integer>> map = new HashMap<>();
        HashMap<Integer, Integer> innerMap = new HashMap<>();
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken());
            innerMap = map.getOrDefault(a, new HashMap<>());
            innerMap.put(b, Math.max(c, innerMap.getOrDefault(b, 0)));
            map.put(a, innerMap);

            innerMap = map.getOrDefault(b, new HashMap<>());
            innerMap.put(a, Math.max(c, innerMap.getOrDefault(a, 0)));
            map.put(b, innerMap);
        }

        st = new StringTokenizer(bf.readLine());
        int start = Integer.parseInt(st.nextToken()) - 1;
        int end = Integer.parseInt(st.nextToken()) - 1;

        System.out.println(map);

//        Arrays.fill(dist, 1000000000);

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o2[1] - o1[1]);
        for (int cur : map.get(start).keySet()) {
            int val = map.get(start).get(cur);
            pq.add(new int[]{cur, val});
            dist[cur] = val;
        }

        dist[start] = 1000000000;
        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int cur = info[0]; int val = info[1];
            System.out.println("현재 위치 : " + cur + ", 여태까지 최대 값 : " + val);
            if (cur == end) break;
            for (int next : map.get(cur).keySet()) {
                int nVal = Math.min(val, map.get(cur).get(next));
                if (dist[next] < nVal) {
                    System.out.println("다음 위치 : " + next + ", 여태까지 최대 값 : " + nVal);
                    dist[next] = nVal;
                    pq.add(new int[]{next, nVal});
                }
            }
        }

        System.out.println(Arrays.toString(dist));
        System.out.println(dist[end]);
    }
}
