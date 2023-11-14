package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1707 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        for(int i=0;i<k;i++) {
            HashMap<Integer, List<Integer>> graph = new HashMap<>();
            HashSet<Integer> left = new HashSet<>();
            HashSet<Integer> right = new HashSet<>();
            st = new StringTokenizer(bf.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            boolean check = true;
            for(int j=1;j<=v;j++) graph.put(j, new ArrayList<>());
            for(int j=0;j<e;j++) {
                st = new StringTokenizer(bf.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }

            Queue<int[]> q = new LinkedList<>();
            // [정점번호, flag (left = 0, right = 1)]
            for(int startPoint = 1;startPoint<=v;startPoint++) {
                if (!check) break;
                if (left.contains(startPoint) || right.contains(startPoint)) continue;

                q.add(new int[]{startPoint, 0});
                left.add(startPoint);
                HashSet<Integer> set;
                HashSet<Integer> reverseSet;

                while (!q.isEmpty()) {
                    int[] info = q.poll();
                    int point = info[0];
                    int flag = info[1];
                    set = flag == 0 ? right : left;
                    reverseSet = flag == 0 ? left : right;

                    for (int nextPoint : graph.get(point)) {
                        if (reverseSet.contains(nextPoint)) {
                            check = false;
                            break;
                        }
                        if (!set.contains(nextPoint)) {
                            set.add(nextPoint);
                            q.add(new int[]{nextPoint, flag == 0 ? 1 : 0});
                        }
                    }
                }
            }
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            sb.append(!check ? "NO" : "YES").append("\n");
        }
        System.out.println(sb);
    }
}
