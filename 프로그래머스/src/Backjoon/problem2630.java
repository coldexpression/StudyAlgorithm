package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem2630 {

    static int whiteStone;
    static int blueStone;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][N];
        boolean[][] visited = new boolean[N][N];

        whiteStone = 0;
        blueStone = 0;

        for (int i = 0; i < N; i++)
            for (int j = 0; j < N; j++)
                map[i][j] = sc.nextInt();

        for (int length = 1; length <= N; length = length * 2) {
            int p = N / length;
            System.out.println("p >> " + p);
            for (int row = 0; row < N; row += p) {
                for (int col = 0; col < N; col += p) {
//                    System.out.println("sRow >> " + row);
//                    System.out.println("sCol >> " + col);
//                    System.out.println("eRow >> " + (row + p - 1));
//                    System.out.println("eCol >> " + (col + p - 1));
                    if (!visited[row][col] && validCheck(map, visited, row, col, row + p - 1, col + p - 1))
                        passFill(visited, row, col, row + p - 1, col + p - 1);
                }
            }
            System.out.println("파란 돌 : " + blueStone);
            System.out.println("하얀 돌 : " + whiteStone);
        }

        System.out.println(whiteStone);
        System.out.println(blueStone);
    }

    static void passFill(boolean[][] visited, int sRow, int sCol, int eRow, int eCol) {
        for (int i = sRow; i <= eRow; i++)
            for (int j = sCol; j <= eCol; j++)
                visited[i][j] = true;
    }

    static boolean validCheck(int[][] map, boolean[][] visited, int sRow, int sCol, int eRow, int eCol) {

        int pivot = map[sRow][sCol];

        for (int i = sRow; i <= eRow; i++)
            for (int j = sCol; j <= eCol; j++)
                if (map[i][j] != pivot || visited[i][j]) return false;


        if (pivot == 1) blueStone++;
        else whiteStone++;

        return true;
    }
}
