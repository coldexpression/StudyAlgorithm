package SWEA;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem2105 {
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int[] mr = {1, 1, -1, -1};
    static int[] mc = {1, -1, -1, 1};
    static int ans;
    static HashSet<Integer> set;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(st.nextToken());

        for (int t = 1; t <= T; t++) {
            st = new StringTokenizer(bf.readLine());
            n = Integer.parseInt(st.nextToken());
            ans = -1;
            map = new int[n][n];
            visited = new boolean[n][n];
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(bf.readLine());
                for (int j = 0; j < n; j++) map[i][j] = Integer.parseInt(st.nextToken());
            }

            for (int i = 0; i < n-1 ; i++) {
                for (int j = 1; j < n-1 ; j++) {
                    set = new HashSet<>();
                    set.add(map[i][j]);
                    visited[i][j] = true;
//                    System.out.println("시작 좌표 [" + i + ", " + j + "]");
                    if (isCheck(i + mr[0], j + mc[0]) && !visited[i+mr[0]][j+mc[0]])
                        dfs(i, j, i, j, 0);
                }
            }
            sb.append("#").append(t).append(" ").append(ans).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int sr, int sc, int er, int ec, int idx) {
        if (idx > 3) return;
        if (set.size() > 3 && sr - 1  == er && sc + 1 == ec) {
            ans = Math.max(set.size() ,ans);
            return;
        }

        for(int i=idx;i<4;i++) {
            if (isCheck(sr + mr[i], sc + mc[i]) && !set.contains(map[sr+mr[i]][sc+mc[i]])) {
                set.add(map[sr+mr[i]][sc+mc[i]]);
                visited[sr+mr[i]][sc+mc[i]] = true;
                dfs(sr + mr[i], sc + mc[i], er, ec, i);
                visited[sr+mr[i]][sc+mc[i]] = false;
                set.remove(map[sr+mr[i]][sc+mc[i]]);
            }
        }

    }

    public static boolean isCheck(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}
