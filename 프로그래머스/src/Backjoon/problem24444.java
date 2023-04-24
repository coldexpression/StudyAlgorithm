package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem24444 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());
        List<Integer>[] graph = new ArrayList[n+1];
        int[] visited = new int[n+1];
        int index = 1;

        for(int i=1;i<=n;i++) graph[i] = new ArrayList<Integer>();

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            graph[start].add(end);
            graph[end].add(start);
        }

        for(int i=1;i<=n;i++) Collections.sort(graph[i]);

        Queue<Integer> queue = new LinkedList<Integer>();
        queue.add(r);
        visited[r] = index++;
        while(!queue.isEmpty()) {
            int num = queue.poll();

            for(int next: graph[num]) {
                if (visited[next] == 0) {
                    visited[next] = index++;
                    queue.add(next);
                }
            }
        }

        for(int i=1;i<=n;i++) System.out.println(visited[i]);
    }
}