package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem25195 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        boolean check = false;
        HashMap<Integer, List<Integer>> map = new HashMap<>();
        boolean[] vis = new boolean[n];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            List<Integer> list = map.getOrDefault(start, new ArrayList<>());
            list.add(end);
            map.put(start, list);
        }
        st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(bf.readLine());
        for(int i=0;i<s;i++) {
            int idx = Integer.parseInt(st.nextToken()) - 1;
            vis[idx] = true;
        }

        if (vis[0]) {
            check = false;
        } else {
            Queue<Integer> queue = new LinkedList<>();
            queue.add(0);
            vis[0] = true;
            while (!queue.isEmpty()) {
                int current = queue.poll();
                List<Integer> list = map.getOrDefault(current, new ArrayList<>());
                if (list.isEmpty()) {
                    check = true;
                    break;
                }
                for (int next : list) {
                    if (!vis[next]) {
                        vis[next] = true;
                        queue.add(next);
                    }
                }
            }
        }
        System.out.println(check ? "yes" : "Yes");
    }
}
