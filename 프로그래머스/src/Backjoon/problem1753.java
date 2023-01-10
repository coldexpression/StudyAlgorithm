package Backjoon;

import java.util.*;

public class problem1753 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        final int MAX_VAL = Integer.MAX_VALUE;

        int V = sc.nextInt();
        int E = sc.nextInt();

        int[] info = new int[V+1];
        List<int[]> list = new ArrayList<>();
        boolean[] visited = new boolean[V+1];

        int K = sc.nextInt();


        for(int i=1;i<=E;i++) {
            int st = sc.nextInt();
            int ed = sc.nextInt();
            int val = sc.nextInt();

            list.add(new int[]{st, ed, val});
        }

        for(int i=1;i<=V;i++) info[i] = MAX_VAL;

        info[K] = 0;

        queue.add(new int[]{K, info[K]});

        while(!queue.isEmpty()) {
            int[] ints = queue.poll();
            int current = ints[0];

            if (!visited[current]) {
                visited[current] = true;
                for (int[] ele : list) {
                    int st = ele[0];
                    int end = ele[1];
                    int val = ele[2];

                    if (st == current && !visited[end] && info[current] + val < info[end]) {
                        info[end] = info[current] + val;
                        queue.add(new int[]{end, info[end]});
                    }
                }

            }
        }


        for(int i=1;i<=V;i++) sb.append(info[i] == MAX_VAL ? "INF" : info[i]).append("\n");

        System.out.println(sb.toString());
    }
}
