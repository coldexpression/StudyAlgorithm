package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class problem15684 {

    static int ans;

    static char[] a = {'L', 0};
    static char[] b = {'R', 0};
    static boolean check;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input = bf.readLine();
        String[] word = input.split(" ");

        int n = Integer.parseInt(word[0]);
        int m = Integer.parseInt(word[1]);
        int h = Integer.parseInt(word[2]);

        int[][] board = new int[h + 1][n + 1];

        for (int i = 0; i < m; i++) {
            input = bf.readLine();
            word = input.split(" ");

            int st = Integer.parseInt(word[0]);
            int ed = Integer.parseInt(word[1]);

            board[st][ed] = 1;
            board[st][ed + 1] = -1;
        }

        ans = Integer.MAX_VALUE;


        dfs(board, 1, 1, h, n, 0);
        ans = ans == Integer.MAX_VALUE ? -1 : ans;

        System.out.println(ans);
    }

    public static boolean start(int[][] board, int n, int maxRow) {

        for (int start = 1; start <= n; start++) {
            int col = start;
            int row = 1;

            for(int h=1;h<=maxRow;h++) {
                if (board[h][col] == 1) col++;
                else if (board[h][col] == -1) col--;
            }

            if (col != start) return false;

//            while (true) {
//                if (board[row][col] == 0)
//                    row++;
//                else if (board[row][col] == 'L') {
//                    col++;
//                    row++;
//                } else if (board[row][col] == 'R') {
//                    col--;
//                    row++;
//                }
//                if (row == (maxRow + 1))
//                    break;
//            }

//            if (start != col)
//                return false;
        }

        return true;
    }

    public static void dfs(int[][] board, int stRow, int stCol, int edRow, int edCol, int count) {

        if (count > 3 || count >= ans)
            return;
        /* 사다리 검증 시작 */
        if (start(board, edCol, edRow)) {
            ans = count;
            return;
        }

        if (stRow == (edRow + 1)) return;

        for(int i=stRow;i<=edRow;i++) {
            for(int j=1;j<edCol;j++) {
                if (board[i][j] == 0 && board[i][j + 1] == 0) {
                    board[i][j] = 1;
                    board[i][j + 1] = -1;
                    dfs(board, i, stCol, edRow, edCol, count+1);
                    board[i][j] = board[i][j+1] = 0;
                }
            }
        }

//        if (board[stRow][stCol] == 0 && board[stRow][stCol + 1] == 0) {
//            board[stRow][stCol] = 1;
//            board[stRow][stCol + 1] = -1;
//            dfs(board, stCol == (edCol - 1) ? stRow + 1 : stRow, stCol + 2 >= (edCol - 1) ? 1 : stCol + 2, edRow, edCol,
//                    count + 1);
//            board[stRow][stCol] = board[stRow][stCol + 1] = 0;
//        }
//        dfs(board, stCol == (edCol - 1) ? stRow + 1 : stRow, stCol == (edCol - 1) ? 1 : stCol + 1, edRow, edCol,
//                count);
    }


}