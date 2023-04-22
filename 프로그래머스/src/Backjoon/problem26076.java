package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem26076 {
    static int[][] move = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = 2;

        int[][] map = new int[n + 2][m + 2];

        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(bf.readLine());
            for (int j = 1; j < m + 1; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 1; i < m + 2; i++) map[0][i] = -1;
        for (int i = 0; i < n + 1; i++) map[i][m + 1] = -1;
        for (int i = 0; i < m + 1; i++) map[n + 1][i] = -2;
        for (int i = 1; i < n + 2; i++) map[i][0] = -2;

        if (!checkBfs(map, 1, 1, n, m)) {
            bfs(map, 0, 1, n + 2, m + 2);
            bfs(map, 1, 0, n + 2, m + 2);

            for (int i = 1; i <= n; i++) {
                if (ans == 1) break;
                for (int j = 1; j <= m; j++) {
                    if (map[i][j] != 0 || (i == 1 && j == 1) || (i == n && j == m)) continue;
                    boolean aZone = false;
                    boolean bZone = false;
                    for (int k = 0; k < 8; k++) {
                        int nr = i + move[k][0];
                        int nc = j + move[k][1];
                        if (map[nr][nc] == -1) aZone = true;
                        else if (map[nr][nc] == -2) bZone = true;
                    }

                    if (aZone && bZone) {
                        ans = 1;
                        break;
                    }
                }
            }
        } else ans = 0;
        System.out.println(ans);
    }

    public static boolean checkBfs(int[][] map, int sr, int sc, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n + 2][m + 2];

        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            if (r == n && c == m) return false;

            for (int i = 0; i < 4; i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if (isCheck(nr, nc, n + 2, m + 2) && map[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
        return true;
    }

    public static void bfs(int[][] map, int sr, int sc, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        int pivot = map[sr][sc];
        boolean[][] visited = new boolean[n][m];

        queue.add(new int[]{sr, sc});
        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];

            for (int i = 0; i < 8; i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if (isCheck(nr, nc, n, m) && (map[nr][nc] == pivot || map[nr][nc] == 1) && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = pivot;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }


    public static boolean isCheck(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}