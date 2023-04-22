package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem24479 {
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        HashMap<Integer, List<Integer>> map = new HashMap<>();

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken()) - 1;

        int[] visited = new int[n];
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int s = Integer.parseInt(st.nextToken()) - 1;
            int e = Integer.parseInt(st.nextToken()) - 1;
            List<Integer> list =  map.getOrDefault(s, new ArrayList<>());
            list.add(e);
            map.put(s, list);

            list = map.getOrDefault(e, new ArrayList<>());
            list.add(s);
            map.put(e, list);
        }

        for (List<Integer> value : map.values()) Collections.sort(value);

        count = 1;
        visited[r] = count++;
        dfs(map, visited, r);

        Arrays.stream(visited).forEach(x -> sb.append(x).append("\n"));
        System.out.println(sb);
    }

    public static void dfs(HashMap<Integer, List<Integer>> map, int[] visited, int index) {

        for(int ele: map.getOrDefault(index, new ArrayList<>())) {
            if (visited[ele] == 0) {
                visited[ele] = count++;
                dfs(map, visited, ele);
            }
        }
    }
}
