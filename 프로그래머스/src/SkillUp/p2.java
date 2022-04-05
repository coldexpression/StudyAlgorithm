package SkillUp;

import java.util.*;

public class p2 {

    public static void main(String[] args) {
        p2 p2 = new p2();
        p2.solution(4);
    }

    public int[] solution(int n) {
        List<Integer> answerStore = new ArrayList<>();
        int[] answer = {};
        int[][] board = new int[n][n];
        int index = 1;
        int col = 0;
        int row = n-1;
        int startRow = 0;
        int startCol = 0;
        int endRow = n-1;
        int endCol = n-1;
        int round = 0;
        while (true) {
            if (startRow >= n || startCol >= n || board[startRow][startCol] != 0) break;
            for (int i = startRow; i <= endRow; i++) {
                if (board[i][startCol] == 0) board[i][startCol] = index++;
                else break;
            }
            for (int i = startCol+1; i <= endCol; i++) {
                if (board[endRow][i] == 0) board[endRow][i] = index++;
                else break;
            }
            startRow++;
            for (int i = endRow-1; i >= startRow; i--) {
                if (board[i][i-round] == 0) board[i][i-round] = index++;
                else break;
            }
            startRow++;
            startCol++;
            round++;
            endRow--;
            endCol -= 2;
        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                if (board[i][j] == 0) break;
                answerStore.add(board[i][j]);
            }
        }

        System.out.println(answerStore);
        answer = answerStore.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
