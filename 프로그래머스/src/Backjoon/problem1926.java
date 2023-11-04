package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1926 {
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int count = 0;
        int answer = 0;
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        boolean[][] vis = new boolean[n][m];

        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    count++;
                    answer = Math.max(answer, bfs(vis, map, i, j, n, m));
                }
            }
        }
        System.out.println(count);
        System.out.println(answer);
    }

    public static int bfs(boolean[][] vis, int[][] map, int r, int c, int n, int m) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{r,c});
        int count = 1;
        vis[r][c] = true;

        while(!q.isEmpty()) {
            int[] info = q.poll();
            int cr = info[0]; int cc = info[1];

            for(int i=0;i<4;i++) {
                int nr = cr + move[i][0];
                int nc = cc + move[i][1];
                if (isCheck(nr, nc, n, m) && !vis[nr][nc] && map[nr][nc] == 1) {
                    q.add(new int[]{nr, nc});
                    vis[nr][nc] = true;
                    count++;
                }
            }
        }
        return count;
    }

    public static boolean isCheck(int r, int c, int n, int m) {
        return r>=0 && r<n && c>=0 && c<m;
    }
}
