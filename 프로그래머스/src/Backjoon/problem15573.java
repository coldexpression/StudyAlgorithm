package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem15573 {
    static int[][] move = {{0,1},{0,-1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] map = new int[n+1][m+2];
        for(int i=1;i<=n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=1;j<=m;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        int left = 1;
        int right = 1000000;
        int middle = 0;
        int score = 0;
        int ans = Integer.MAX_VALUE;
        while(left <= right) {
            middle = (left + right) / 2;
            score = findScore(map, middle, n+1, m+2);
            if (score < k) {
                left = middle + 1;
            } else {
                right = middle - 1;
                ans = Math.min(ans, middle);
            }
        }
        System.out.println(ans == Integer.MAX_VALUE ? 0 : ans);
    }

    public static int findScore(int[][] map, int power, int n, int m) {
        Queue<int[]> queue = new LinkedList<int[]>();
        boolean[][] visited = new boolean[n][m];
        int ans = 0;

        queue.add(new int[] {0, 0});
        visited[0][0] = true;
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0]; int c = info[1];
            ans = map[r][c] == 0 ? ans : ans + 1;

            for(int i=0;i<4;i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if (isCheck(nr, nc, n, m) && !visited[nr][nc] && power >= map[nr][nc]) {
                    visited[nr][nc] = true;
                    queue.add(new int[] {nr, nc});
                }
            }
        }

        return ans;
    }

    public static boolean isCheck(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}