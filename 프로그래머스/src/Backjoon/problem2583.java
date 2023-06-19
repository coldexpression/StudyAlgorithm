package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem2583 {
    static PriorityQueue<Integer> pq = new PriorityQueue<>();
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[m][n];
        boolean[][] vis = new boolean[m][n];

        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            int c1 = Integer.parseInt(st.nextToken());
            int r1 = Integer.parseInt(st.nextToken());
            int c2 = Integer.parseInt(st.nextToken());
            int r2 = Integer.parseInt(st.nextToken());

            for(int j=r1;j<r2;j++) {
                for(int h=c1;h<c2;h++) {
                    map[j][h] = -1;
                }
            }
        }
        int flag = 0;

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (map[i][j] == 0) {
                    cnt = 1;
                    flag++;
                    map[i][j] = flag;
                    dfs(i, j, 0, map, flag, m, n);
                    pq.add(cnt);
                }
            }
        }

        System.out.println(flag);
        while(!pq.isEmpty()) System.out.print(pq.poll()+" ");
    }

    public static void dfs(int r, int c, int count, int[][] map, int flag, int m, int n) {
        for(int i=0;i<4;i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if (isCheck(nr, nc, m, n) && map[nr][nc] == 0) {
                map[nr][nc] = flag;
                cnt++;
                dfs(nr, nc, count + 1, map, flag, m, n);
            }
        }
    }
    public static boolean isCheck(int r, int c, int mr, int mc) {
        return r >= 0 && r < mr && c >= 0 && c < mc;
    }
}
