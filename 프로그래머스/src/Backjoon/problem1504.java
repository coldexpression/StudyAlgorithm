package Backjoon;

import java.io.IOException;
import java.util.*;

public class problem1504 {

    static int max;

    public static void main(String[] args) throws NumberFormatException, IOException {
        Scanner sc = new Scanner(System.in);

        /*
         * 1. 출발 정점과 각각 두개의 정점 u 와 v 까지의 최단 거리를 구한다. 2. 정점 u -> v 최단거리와 정점 v -> u 최단 거리를
         * 구한다. 3. 정점 u -> N 최단거리와 정점 v -> N 최단 거리를 구한다. 4. 출발 정점 -> u -> v -> N 와 출발 정점
         * -> v -> u -> N 거리 중 최소 값이 정답이 된다.
         */

        int n = sc.nextInt();
        int e = sc.nextInt();

        max = 0;

        int[][] board = new int[n][n];
        HashMap<Integer, List<int[]>> map = new HashMap<>();

        for (int count = 0; count < e; count++) {
            int p1 = sc.nextInt() - 1;
            int p2 = sc.nextInt() - 1;
            int val = sc.nextInt();

            max += val;

            List<int[]> listA = map.getOrDefault(p1, new ArrayList<>());
            listA.add(new int[] { p2, val });
            map.put(p1, listA);

            List<int[]> listB = map.getOrDefault(p2, new ArrayList<>());
            listB.add(new int[] { p1, val });
            map.put(p2, listB);
        }

        int u = sc.nextInt();
        int v = sc.nextInt();

        long sumA = Long.MAX_VALUE;
        long sumB = Long.MAX_VALUE;
        long ans = 0;

        sumA = dijk(map, 0, u - 1, n) + dijk(map, u - 1, v - 1, n) + dijk(map, v - 1, n - 1, n);
        sumB = dijk(map, 0, v - 1, n) + dijk(map, v - 1, u - 1, n) + dijk(map, u - 1, n - 1, n);

        sumA = sumA <= 0 ? 0 : sumA;
        sumB = sumB <= 0 ? 0 : sumB;

        if (sumA > 0 && sumB > 0) ans = Math.min(sumA, sumB);
        else if (sumA > 0 || sumB > 0) ans = Math.max(sumA, sumB);
        else ans = -1;

        System.out.println(ans);
    }

    static int dijk(HashMap<Integer, List<int[]>> map, int sP, int eP, int n) {

        PriorityQueue<int[]> q = new PriorityQueue<>(new Comparator<int[]>() {

            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[1] - o2[1];
            }
        });
        int[] score = new int[n];

        Arrays.fill(score, Integer.MAX_VALUE);

        score[sP] = 0;
        q.add(new int[] { sP, 0 });

        while (!q.isEmpty()) {
            int[] info = q.poll();

            int start = info[0];
            int val = info[1];

            List<int[]> list = map.getOrDefault(start, new ArrayList<>());

            for (int[] nextInfo : list) {
                int next = nextInfo[0];
                int nVal = nextInfo[1];

                if (score[start] + nVal <= score[next]) {
                    score[next] = score[start] + nVal;
                    q.add(new int[] { next, score[start] + nVal });
                }
            }
        }

        return score[eP] == Integer.MAX_VALUE ? Integer.MIN_VALUE : score[eP];
    }

}
