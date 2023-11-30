package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1405 {
    static int[][] move ={{0,1},{0,-1},{1,0},{-1,0}};
    static double ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[][] vis = new boolean[30][30];
        double[] waysPercent = new double[4];
        for(int i=0;i<4;i++) waysPercent[i] = Integer.parseInt(st.nextToken()) * 0.01;
        ans = 0;
        vis[15][15] = true;
        dfs(n, 0, vis, waysPercent, 15, 15, 1, 30);
        System.out.println(ans);
    }

    public static void dfs(int n, int count, boolean[][] vis, double[] wayPercent, int r, int c, double percent, int size) {
        System.out.println("현재 좌표 ["+r+", "+c+"]");
        if (count == n) {
            System.out.println("percent : " + percent);
            ans += percent;
            return;
        }

        for(int i=0;i<4;i++) {
            int nr = r + move[i][0];
            int nc = c + move[i][1];
            if (isCheck(nr, nc, size) && !vis[nr][nc]) {
                vis[nr][nc] = true;
                dfs(n, count + 1, vis, wayPercent, nr, nc, percent * wayPercent[i], size);
                vis[nr][nc] = false;
            }
        }
    }

    public static boolean isCheck(int r, int c, int n) {
        return r>= 0 && r<n && c>=0 && c<n;
    }
}
