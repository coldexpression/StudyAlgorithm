package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.*;

public class problem16681 {
    static HashMap<Integer, List<int[]>> map;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        map = new HashMap<>();
        long[] height = new long[n];
        long[] w = new long[n];
        long[] rw = new long[n];
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<n;i++) {
            height[i] = Integer.parseInt(st.nextToken());
            map.put(i, new ArrayList<>());
        }


        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int n1 = Integer.parseInt(st.nextToken()) - 1;
            int n2 = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            map.get(n1).add(new int[]{n2, weight});
            map.get(n2).add(new int[]{n1, weight});
        }

        dijk(0, d, height, w);
        dijk(n-1, d, height, rw);

        System.out.println("정방향 : " + Arrays.toString(w));
        System.out.println("역방향 : " + Arrays.toString(rw));
        long ans = Long.MIN_VALUE;
        boolean check = false;
        for(int i=1;i<n;i++) {
            if (w[i] == Long.MAX_VALUE || rw[i] == Long.MAX_VALUE) continue;
            check = true;
            System.out.println("통과 인덱스 : " + i);
            System.out.println(height[i]*e - (w[i] + rw[i]));
            ans = Math.max(ans, (height[i]*e) - (w[i] + rw[i]));
        }

        System.out.println(check ? ans : "Impossible");
    }

    public static void dijk(int start, int d, long[] height, long[] weight) {
        Arrays.fill(weight, Long.MAX_VALUE);
        weight[start] = 0;
        long maxHeight = height[start];
        long[] currentHeight = new long[height.length];
        currentHeight[start] = 1;
        System.out.println("출발 지점 : " + start);

        PriorityQueue<long[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[1] == o2[2]) return (int)o2[2] - (int)o1[2];
            return (int)o1[1] - (int)o2[1];
        });
        pq.add(new long[]{start, 0, maxHeight});

        while(!pq.isEmpty()) {
            long[] info = pq.poll();
            int cur = (int)info[0]; long val = info[1]; long cHeight = info[2];
            System.out.println("현재 지점 => " + cur);
            if (weight[cur] < val) continue;

            for(int[] nInfo: map.get(cur)) {
                int next = nInfo[0]; int dist = nInfo[1];
                long nVal = val + (long) dist *d;
                if (currentHeight[next] > height[next] || nVal > weight[next] || height[cur] > height[next]) continue;
                if (height[cur] < height[next]) {
                    weight[next] = nVal;
                    currentHeight[next] = height[next];
                    System.out.println("다음 지점 ["+next+"] => " + nVal);
                    pq.add(new long[]{next, weight[next], Math.max(cHeight, height[next])});
                }
            }
        }
    }
}
