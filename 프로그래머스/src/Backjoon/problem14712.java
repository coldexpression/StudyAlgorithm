package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class problem14712 {
    static int ans;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        ans = 0;
        if (n < 2 || m < 2) ans = (int)Math.pow(2, n*m);
        else dfs(map, -1, -1, n, m);
        System.out.println(ans);
    }

    public static void dfs(int[][] map, int r, int c, int n, int m) {
        if (r > 0 && c > 0 && map[r-1][c-1] == 1 && map[r-1][c] == 1 && map[r][c-1] == 1 && map[r][c] == 1) return;


        if (r == n-1 && c == m-1) {
            ans++;
            return;
        }

        r = r == -1 ? 0 : c == m - 1 ? r + 1 : r;
        c = c == -1 ? 0 : c == m - 1 ? 0 : c + 1;

        map[r][c] = 1;
        dfs(map, r, c, n, m);
        map[r][c] = 0;
        dfs(map, r, c, n, m);
    }
}
