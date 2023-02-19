package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem14503 {

    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,-1,1};

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String word = bf.readLine();
        String[] input = word.split(" ");

        int n = Integer.parseInt(input[0]);
        int m = Integer.parseInt(input[1]);

        int[][] map = new int[n][m];
        int count = 0;

        word = bf.readLine();
        input = word.split(" ");

        int row = Integer.parseInt(input[0]);
        int col = Integer.parseInt(input[1]);
        int dir = Integer.parseInt(input[2]);

        for(int i=0;i<n;i++) {
            word = bf.readLine();
            input = word.split(" ");
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(input[j]);
            }
        }

        while(true) {
            if (map[row][col] == 1) break;

            if (map[row][col] == 0) {
                map[row][col] = 2;
                count++;
            }

            if (isClean(map, row, col, n, m)) {

                while(true) {
                    // 0 -> 3 [북 -> 서] 1 -> 0 [동 -> 북] 2 -> 1 [남 -> 동] 3 -> 2 [서 -> 남]
                    dir = (dir+3) % 4;
                    int[] nextPos = move(row, col, dir, -1);

                    if (nextPos[0] < 0 || nextPos[0] >= n || nextPos[1] < 0 || nextPos[1] >= m) break;

                    if (map[nextPos[0]][nextPos[1]] == 0) {
                        row = nextPos[0];
                        col = nextPos[1];
                        break;
                    }
                }
            } else {
                int[] nextPos = move(row, col, dir, 1);

                if (nextPos[0] < 0 || nextPos[0] >= n || nextPos[1] < 0 || nextPos[1] >= m) break;

                row = nextPos[0];
                col = nextPos[1];
            }
        }

        System.out.println(count);

    }

    public static int[] move(int row, int col, int type,int dir) {
        switch (type) {
            case 0: return new int[] {row+(1*dir), col};
            case 1: return new int[] {row, col-(1*dir)};
            case 2: return new int[] {row-(1*dir), col};
            default: return new int[] {row, col+(1*dir)};
        }
    }

    public static boolean isClean(int[][] map , int row, int col, int n, int m) {

        for(int i=0;i<4;i++) {
            int nRow = row + moveRow[i];
            int nCol = col + moveCol[i];

            if (nRow >= 0 && nRow <n && nCol >= 0 && nCol < m) {
                if (map[nRow][nCol] == 0) return true;
            }
        }

        return false;
    }




}
