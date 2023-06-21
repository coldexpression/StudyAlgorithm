package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2667 {
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    static int count;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        boolean[][] vis = new boolean[n][n];

        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            for(int j=0;j<n;j++) map[i][j] = Character.getNumericValue(input.charAt(j));
        }

        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if (map[i][j] == 1 && !vis[i][j]) {
                    count = 1;
                    vis[i][j] = true;
                    dfs(map, vis, i, j, n);
                    pq.add(count);
                }
            }
        }

        System.out.println(pq.size());
        while(!pq.isEmpty()) System.out.println(pq.poll());
    }

    public static void dfs(int[][] map, boolean[][] vis, int r, int c, int n) {
        for(int i=0;i<4;i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if (isCheck(nr, nc, n) && map[nr][nc] == 1 && !vis[nr][nc]) {
                vis[nr][nc] = true;
                count++;
                dfs(map, vis, nr, nc, n);
            }
        }
    }

    public static boolean isCheck(int r, int c, int n) {
        return r>=0 && r< n && c >= 0 && c < n;
    }
}
