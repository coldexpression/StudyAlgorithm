package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class problem5653 {

    static int[][] map;
    static boolean[][] visited;
    static int n;
    static int m;
    static int k;
    final static int SIZE = 1001;

    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                if (o1[4] == o2[4]) {
                    if (o1[5] == o2[5]) {
                        if (o1[2] == o2[2]) {
                            return o2[3] - o1[3];
                        }
                        return o1[2] - o2[2];
                    }
                    return o2[5] - o1[5];
                }
                return o1[4] - o2[4];
            }
        });
        int T = Integer.parseInt(st.nextToken());
        for (int t = 1; t <= T; t++) {
            map = new int[SIZE][SIZE];
            visited = new boolean[SIZE][SIZE];
            int ans = 0;
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            m = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < m; j++) {
                    int r = (SIZE / 2) + i;
                    int c = (SIZE / 2) + j;
                    map[r][c] = Integer.parseInt(st.nextToken());
                    if (map[r][c] != 0) {
                        queue.add(new int[]{r, c, map[r][c], map[r][c], 0, 0});
                    }
                }
            }

            while (!queue.isEmpty()) {
                int[] info = queue.poll(); int r = info[0]; int c = info[1];
                int waitTime = info[2]; int lifeTime = info[3]; int time = info[4]; int check = info[5];
                if (check == 0) {
                    if (time < k) {
                        // 비활성 상태 -> 활성 상태가 되는 경우
                        if (waitTime == 0) {
                            queue.add(new int[]{r, c, lifeTime, lifeTime, time, 1});
                            for (int i = 0; i < 4; i++) {
                                int nr = r + moveRow[i];
                                int nc = c + moveCol[i];

                                if (isCheck(nr, nc)) {
                                    // 처음으로 번식된 줄기 세포일 경우
                                    if (map[nr][nc] == 0) {
                                        map[nr][nc] = lifeTime;
                                        queue.add(new int[]{nr, nc, lifeTime, lifeTime, time + 1, 0});
                                    }
                                }
                            }
                        }
                        // 비활성 상태인 경우
                        else queue.add(new int[]{r, c, waitTime - 1, lifeTime, time + 1, 0});

                    }
                } else {
                    if (time <= k) {
                        if (waitTime == 0) visited[r][c] = true;
                        else queue.add(new int[]{r, c, waitTime - 1, lifeTime, time + 1, 1});
                    }
                }
            }
            for (int i = 0; i < SIZE; i++)
                for (int j = 0; j < SIZE; j++)
                    ans = !visited[i][j] && map[i][j] != 0 ? ans + 1 : ans;

            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static boolean isCheck(int r, int c) {
        return r >= 0 && r < SIZE && c >= 0 && c < SIZE;
    }
}