package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class problem1987 {

    static char[][] map;

    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,1,-1};

    static int r;
    static int c;
    static HashSet<Character> set;

    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        set = new HashSet<>();

        st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        map = new char[r][c];

        ans = 0;

        char alph = 'A';

        while(alph <= 'Z') {
            set.add(alph++);
        }

        for(int i=0;i<r;i++) {
            String input = bf.readLine();
            for(int j=0;j<input.length();j++) {
                map[i][j] = input.charAt(j);
            }
        }

        set.remove(map[0][0]);
        dfs(1, 0, 0);

        System.out.println(ans);
    }

    public static boolean isCheck(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c;
    }

    public static void dfs(int count, int row, int col) {
        ans = Math.max(ans ,count);

        for(int i=0;i<4;i++) {
            int nr = row + moveRow[i];
            int nc = col + moveCol[i];

            if(isCheck(nr, nc) && set.contains(map[nr][nc])) {
                set.remove(map[nr][nc]);
                dfs(count +1, nr, nc);
                set.add(map[nr][nc]);
            }
        }
    }
}
