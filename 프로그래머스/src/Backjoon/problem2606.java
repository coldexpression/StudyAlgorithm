package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem2606 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        boolean[] vis = new boolean[n];
        int[][] map = new int[n][n];
        st = new StringTokenizer(bf.readLine());
        int m = Integer.parseInt(st.nextToken());
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int start = Integer.parseInt(st.nextToken()) - 1;
            int end = Integer.parseInt(st.nextToken()) - 1;
            map[start][end] = map[end][start] = 1;
        }
        ans = 0;
        vis[0] = true;
        dfs(map, vis, 0, n);
        System.out.println(ans);
    }
    public static void dfs(int[][] map, boolean[] vis, int computer, int n) {

        for(int i=0;i<n;i++) {
            if (!vis[i] && map[computer][i] == 1) {
                vis[i] = true;
                ans++;
                dfs(map, vis, i, n);
            }
        }
    }
}
