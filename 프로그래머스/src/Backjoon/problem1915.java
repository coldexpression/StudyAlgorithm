package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem1915 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String inputString = br.readLine();
        int n = Integer.parseInt(inputString.split(" ")[0]);
        int m = Integer.parseInt(inputString.split(" ")[1]);
        long ans = 0;
        Queue<int[]> queue = new LinkedList<>();

        int[][] board = new int[n][m];

        for(int i=0;i<n;i++) {
            String word = br.readLine();
            for(int j=0;j<m;j++) {
                board[i][j] = Character.getNumericValue(word.charAt(j));
                if (board[i][j] == 1) queue.add(new int[] {i, j});
            }
        }

        long size = 1;

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];

            if (board[row][col] == 1) {
                while(true) {
                    ++size;
                    if (!squareCheck(board, row, col, size)) {
                        size--;
                        break;
                    }
                }
                ans = Math.max(ans, size*size);
            }
        }

        System.out.println(ans);


    }

    static boolean squareCheck(int[][] board, int row, int col, long size) {
        int maxRow = board.length;
        int maxCol = board[0].length;
        long count = 0;

        for(int i=row;i<row+size;i++) {
            for(int j=col;j<col+size;j++) {
                if (i >= maxRow || j >= maxCol) return false;
                if(board[i][j] != 1) return false;
                count++;
            }
        }

        return count == (size*size);
    }

}
