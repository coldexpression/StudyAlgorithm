package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class problem1018 {
    static char[] stone = {'W','B'};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int ans = Integer.MAX_VALUE;

        char[][] map = new char[n][m];

        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            for(int j=0;j<m;j++) {
                map[i][j] = input.charAt(j);
            }
        }

        for(int i=0;i<=n-8;i++) {
            for(int j=0;j<=m-8;j++) {
                ans = Math.min(search(1, i, j, map), ans);
                ans = Math.min(search(2, i, j, map), ans);
            }
        }

        System.out.println(ans);
    }

    public static int search(int color, int r, int c, char[][] map) {
        // color = 1 : 첫 칸이 흰색
        // color = 2 : 첫 칸이 검정색
        int count = 0;
        int index = color == 1 ? 0 : 1;

        for(int i=r;i<r+8;i++) {
            for(int j=c;j<c+8;j++) {
                count = map[i][j] != stone[index] ? count + 1: count;
                index = index == 0 ? 1 : 0;
            }
            index = index == 0 ? 1 : 0;
        }
        return count;
    }
}
