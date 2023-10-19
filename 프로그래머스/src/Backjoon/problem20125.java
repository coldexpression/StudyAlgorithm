package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Queue;

public class problem20125 {
    static int[][] move = {{0,-1},{0,1},{1,0},{-1,0}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(bf.readLine());
        char[][] map = new char[n][n];
        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            for(int j=0;j<n;j++) map[i][j] = input.charAt(j);
        }

        int[] heartPos = findHeart(map, n);
        sb.append(heartPos[0] + 1).append(" ").append(heartPos[1] + 1).append("\n");
        int[] centerPos = findCenter(map, heartPos, n);
        for(int i=0;i<5;i++) sb.append(start(map, i <= 2 ? heartPos : centerPos, i, n)).append(" ");
        System.out.print(sb);
    }
    public static int start(char[][] map, int[] pos, int index, int n) {
        int r = 0; int c = 0;
        int count = 0;
        if (index >= 0 && index < 3) {
            r = pos[0]; c = pos[1];
            while(true) {
                int nr = r + move[index][0];
                int nc = c + move[index][1];
                if (!isCheck(nr, nc, n) || map[nr][nc] == '_') break;
                r = nr;
                c = nc;
                count++;
            }
        } else {
            count++;
            r = pos[0] + 1; c = index == 3 ? pos[1] - 1 : pos[1] + 1;
            while(true) {
                r++;
                if (!isCheck(r, c, n) || map[r][c] == '_') break;
                count++;
            }
        }
        return count;
    }
    public static int[] findCenter(char[][] map, int[] pos, int n) {
        int r = pos[0]; int c = pos[1];
        int nr = 0;
        for(int i=r;i<n;i++) {
            if (map[i][c] != '*') break;
            nr = i;
        }
        return new int[]{nr, c};
    }

    public static int[] findHeart(char[][] map, int n) {
        for(int r=0;r<n;r++) {
            for(int c=0;c<n;c++) {
                int count = 0;
                if (map[r][c] != '*') continue;
                for(int i=0;i<4;i++) {
                    int nr = r + move[i][0];
                    int nc = c + move[i][1];
                    if (isCheck(nr, nc, n) && map[nr][nc] == '*') count++;
                }

                if (count == 4) return new int[]{r, c};
            }
        }
        return new int[]{-1, -1};
    }

    public static boolean isCheck(int r, int c, int n){
        return r>= 0 && r < n && c >= 0 && c < n;
    }
}
