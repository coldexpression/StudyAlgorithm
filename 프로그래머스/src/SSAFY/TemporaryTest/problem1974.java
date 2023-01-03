package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem1974 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();
        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int[][] map = new int[9][9];

            for(int j=0;j<9;j++)
                for(int k=0;k<9;k++)
                    map[j][k] = sc.nextInt();

            boolean[][] check = new boolean[3][3];
            boolean squareCheck = true;
            boolean colCheck = true;
            boolean rowCheck = true;

            /* 사각형 구역 유효성 검증*/
            for (int row = 0; row <= 6; row += 3) {
                for (int col = 0; col <= 6; col += 3) {
                    squareValid(check, map, row, col);
                }
            }

            for (int row = 0; row < check.length; row++) {
                for (int col = 0; col < check.length; col++) {
                    if (!check[row][col]) {
                        squareCheck = false;
                        break;
                    }

                    if (!squareCheck) break;
                }
            }

            sb.append("#").append(i).append(" ");

            if (!squareCheck) {
                sb.append(0);
            } else {
                colCheck = lineValid(map, true);
                rowCheck = lineValid(map, false);

                sb.append(colCheck && rowCheck ? 1 : 0);
            }

            sb.append("\n");
        }

        System.out.println(sb.toString());
    }

    static boolean lineValid(int[][] map, boolean divide) {
        int num = 0;
        /* divide = true [가로], false [세로] */
        if (divide) {
            for(int row=0;row<9;row++) {
                num = 45;
                for(int col=0;col<9;col++) num -= map[row][col];
                if (num != 0) return false;
            }
        } else {
            for(int col=0;col<9;col++) {
                num = 45;
                for(int row=0;row<9;row++) num -= map[row][col];
                if (num != 0) return false;
            }
        }

        return true;
    }

    static void squareValid(boolean[][] check, int[][] map, int r1, int c1) {
        int num = 45;
        for(int i=r1;i<r1+3;i++) {
            for(int j=c1;j<c1+3;j++) {
                num -= map[i][j];
            }
        }

        check[r1/3][c1/3] = num == 0;
    }
}
