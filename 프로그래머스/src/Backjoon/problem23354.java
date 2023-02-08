package Backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem23354 {

    static int[] moveRow = { -1, 1, 0, 0 };
    static int[] moveCol = { 0, 0, -1, 1 };
    static long ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        int n = sc.nextInt();

        int[][] map = new int[n][n];
        int[][] runnerMap = new int[n][n];
        int idx = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                map[i][j] = sc.nextInt();

                if (map[i][j] == -1 || map[i][j] == 0) {
                    runnerMap[i][j] = map[i][j] == 0 ? ++idx : 0;

                    if (map[i][j] == -1)
                        map[i][j] = 0;

                    queue.add(new int[] { i, j, runnerMap[i][j] });
                } else {
                    runnerMap[i][j] = -1;
                }
            }
        }

        ans = Long.MAX_VALUE;

        long[][] dst = new long[idx + 1][idx + 1];
        int count = idx + 1;

        for (int i = 0; i < dst.length; i++)
            Arrays.fill(dst[i], Long.MAX_VALUE);

        boolean[] visited = new boolean[idx + 1];

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            visited[runnerMap[pos[0]][pos[1]]] = true;
            dijk(dst, map, runnerMap, visited, pos[0], pos[1], n, n, runnerMap[pos[0]][pos[1]], --count);
        }

        int maxNum = (int) Math.pow(2, dst.length);
        long[][] scoreBox = new long[idx + 1][maxNum];

        nextDijk(dst, scoreBox);

        System.out.println(ans == Long.MAX_VALUE ? 0 : ans);

    }

    public static void nextDijk(long[][] dst, long[][] scoreBox) {

        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                // TODO Auto-generated method stub

                return (int) (o1[1] - o2[1]);
            }
        });

        int maxNum = (int) Math.pow(2, dst.length) - 2;

        for (int i = 0; i < scoreBox.length; i++) {
            Arrays.fill(scoreBox[i], Long.MAX_VALUE);
            scoreBox[i][i] = 0;
        }
        // [탈영병 위치, 톨비, 방문했던 곳]
        for (int i = 1; i < dst.length; i++) {
            queue.add(new long[] { i, dst[i][0], 1 << i });
        }


        while (!queue.isEmpty()) {
            long[] info = queue.poll();
            int index = (int) info[0];

            if ((info[2] & maxNum) == maxNum) {
                // 모든 지점을 방문 한 경우
                ans = Math.min(ans, info[1] + dst[index][0]);
                continue;
            }

            for (int i = 1; i < dst.length; i++) {
                long val = dst[index][i];
                if (i != info[0] && (info[2] & 1 << i) == 0) {
                    queue.add(new long[] { i, info[1] + val, info[2] | 1 << i });
                }
            }
        }
    }

    public static void dijk(long[][] dst, int[][] map, int[][] runnerMap, boolean[] vs, int sRow, int sCol, int eRow,
                            int eCol, int start, int pivot) {
        boolean[][] visited = new boolean[map.length][map.length];
        int cnt = 0;

        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            @Override
            public int compare(long[] o1, long[] o2) {
                // TODO Auto-generated method stub
                return (int) (o1[2] - o2[2]);
            }
        });

        queue.add(new long[] { sRow, sCol, 0 });
        visited[sRow][sCol] = true;

        while (!queue.isEmpty()) {
            long[] pos = queue.poll();
            int row = (int) pos[0];
            int col = (int) pos[1];
            long val = pos[2];


            for (int i = 0; i < 4; i++) {
                int nRow = row + moveRow[i];
                int nCol = col + moveCol[i];

                if (nRow >= 0 && nRow < eRow && nCol >= 0 && nCol < eCol && !visited[nRow][nCol]) {
                    int runner = runnerMap[nRow][nCol];
                    queue.add(new long[] { nRow, nCol, val + map[nRow][nCol] });
                    visited[nRow][nCol] = true;

                    if (runner != -1 && dst[runner][start] > val + map[nRow][nCol]) {
                        dst[start][runner] = dst[runner][start] = val + map[nRow][nCol];
                    }
                }
            }

        }

    }


}