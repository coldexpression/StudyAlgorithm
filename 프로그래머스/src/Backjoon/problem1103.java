package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1103 {
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    static boolean check;
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        int[][] dp = new int[n][m];
        check = false;
        ans = -1;
        boolean[][] vis = new boolean[n][m];
        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            for(int j=0;j<m;j++) {
                char word = input.charAt(j);
                map[i][j] = word == 'H' ? -1 : Character.getNumericValue(word);
                dp[i][j] = Integer.MIN_VALUE;
            }
        }
        dp[0][0] = 0;
        vis[0][0] = true;
        dfs(dp, map, vis, 0,0,n, m, 0);

         for(int i=0;i<n;i++) System.out.println(Arrays.toString(dp[i]));

        System.out.println(check ? -1 : ans+1);
    }

    public static void dfs(int[][] dp, int[][] map, boolean[][] vis, int r, int c, int n, int m, int weight) {
        if (check) return;
        ans = Math.max(ans, weight);
        dp[r][c] = weight + 1;

        for(int i=0;i<4;i++) {
            int nr = r + move[i][0]*map[r][c];
            int nc = c + move[i][1]*map[r][c];

            if (!isCheck(nr, nc, n, m) || map[nr][nc] == -1) continue;
            if (vis[nr][nc]) {
                check = true;
                return;
            }
            if (weight + 1 < dp[nr][nc]) continue;

            vis[nr][nc] = true;
            dfs(dp, map, vis, nr, nc, n, m, weight+1);
            vis[nr][nc] = false;
        }
    }

    public static boolean isCheck(int r, int c, int n, int m) {
        return r >= 0 && r < n && c >= 0 && c < m;
    }
}