package Backjoon;

import java.util.Scanner;

public class problem1992 {

    static StringBuilder sb;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[][] map = new int[N][N];

        for(int i=0;i<N;i++) {
            String line = sc.next();
            for (int j = 0; j < N; j++) {
                map[i][j] = Character.getNumericValue(line.charAt(j));
            }
        }

        sb = new StringBuilder();
        partition(map, 0, 0, N);

        System.out.println(sb.toString());
    }

    static void partition(int[][] map, int row, int col, int size) {
        if (check(map, row, col, size)) {
            sb.append(map[row][col]);
            return;
        }

        int nSize = size / 2;

        sb.append("(");
        partition(map, row, col, nSize);
        partition(map, row, col + nSize, nSize);
        partition(map, row+nSize, col, nSize);
        partition(map, row+nSize, col+nSize, nSize);
        sb.append(")");
    }

    static boolean check(int[][] map, int row, int col, int size) {
        int pivot = map[row][col];

        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if (map[i][j] != pivot) return false;
            }
        }

        return true;
    }
}
