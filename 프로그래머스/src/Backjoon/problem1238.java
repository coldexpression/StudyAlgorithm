package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1238 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        HashMap<Integer, List<int[]>> graph = new HashMap<>();
        HashMap<Integer, List<int[]>> reverseGraph = new HashMap<>();
        for(int i=1;i<=n;i++) {
            graph.put(i, new ArrayList<>());
            reverseGraph.put(i, new ArrayList<>());
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(start).add(new int[]{end, weight});
            reverseGraph.get(end).add(new int[]{start, weight});
        }

        int[] arr = dijk(graph, x);
        int[] brr = dijk(reverseGraph, x);
        int ans = 0;

        for(int i=1;i<=n;i++) {
            if (arr[i] != Integer.MAX_VALUE || brr[i] != Integer.MAX_VALUE) {
                ans = Math.max(ans, arr[i] + brr[i]);
            }
        }
        System.out.println(ans);
    }

    public static int[] dijk(HashMap<Integer, List<int[]>> graph, int point) {
        int[] arr = new int[graph.size()+1];
        Arrays.fill(arr, Integer.MAX_VALUE);
        arr[point] = 0;
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);
        queue.add(new int[]{point, 0});

        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int current = info[0]; int weight = info[1];

            for(int[] nextInfo: graph.get(current)) {
                int next = nextInfo[0]; int nextWeight = nextInfo[1];
                if (arr[current] + nextWeight < arr[next]) {
                    arr[next] = arr[current] + nextWeight;
                    queue.add(new int[]{next, weight + nextWeight});
                }
            }
        }
        return arr;
    }
}
