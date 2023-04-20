package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem9370 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(st.nextToken());

        for(int test=0;test<T;test++) {
            st = new StringTokenizer(bf.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());

            int[][] map = new int[n][n];
            boolean[] target = new boolean[n];
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int g = Integer.parseInt(st.nextToken()) - 1;
            int h = Integer.parseInt(st.nextToken()) - 1;

            for(int i=0;i<m;i++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;
                int d = Integer.parseInt(st.nextToken());
                map[a][b] = map[b][a] = d;
            }

            int[] destination = new int[t];
            for(int i=0;i<t;i++) {
                st = new StringTokenizer(bf.readLine());
                destination[i] = Integer.parseInt(st.nextToken()) - 1;
                target[destination[i]] = true;
            }
            PriorityQueue<long[]> ansQ = new PriorityQueue<long[]>((o1, o2) -> (int)o1[0] - (int)o2[0]);

            long dstA = 0;
            // [1] s -> g , g -> h , h -> 목적지 후보 까지의 최단 거리 구하기
            long[] dst = new long[n];
            long[] originDst = new long[n];
            initDstArr(dst, s);
            dst = dijk(map, dst, s);
            originDst = dst.clone();
            System.out.println("최단 거리 : " + Arrays.toString(originDst));

            int middleSt = 0;
            int middleEd = 0;
            if (dst[g] > dst[h]) {
                middleSt = h;
                middleEd = g;
            } else {
                middleSt = g;
                middleEd = h;
            }

            System.out.println("middle ST : " + middleSt);
            System.out.println("middle ED : " + middleEd);
            dstA += dst[middleSt] + map[middleSt][middleEd];
            System.out.println("dstA : " + dstA);

            initDstArr(dst, middleEd);
            dst = dijk(map, dst, middleEd);
            System.out.println(Arrays.toString(dst));

            for(int i=0;i<t;i++) ansQ.add(new long[] {destination[i], dstA + dst[destination[i]]});

            while(!ansQ.isEmpty()) {
                long[] info = ansQ.poll();
                if (originDst[(int)info[0]] == info[1])
                    sb.append(info[0]+1).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb.toString());
    }

    public static void initDstArr(long[] dst, int s) {
        Arrays.fill(dst, Long.MAX_VALUE);
        dst[s] = 0;
    }

    public static long[] dijk(int[][] map, long[] dst, int start) {
        int n = map.length;
        boolean[] visited = new boolean[n];
        visited[start] = true;

        PriorityQueue<long[]> pq = new PriorityQueue<long[]>((o1 ,o2) -> (int)o1[1] - (int)o2[1]);
        pq.add(new long[] {start, 0});

        while(!pq.isEmpty()) {
            long[] info = pq.poll();
            int sPoint = (int)info[0]; long val = info[1];

            if (dst[sPoint] < val) continue;

            for(int i=0;i<n;i++) {
                if (i != sPoint && map[sPoint][i] != 0 && dst[sPoint] + map[sPoint][i] < dst[i]) {
                    dst[i] = dst[sPoint] + map[sPoint][i];
                    pq.add(new long[] {i, dst[i]});
                }
            }
        }
        return dst;
    }
}