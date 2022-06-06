package Level3;

import java.util.*;

public class problem67259 {

    static int[][] visited;
    static int[] directRow;
    static int[] directCol;
    static int price;

    public static void main(String[] args) {
        problem67259 problem67259 = new problem67259();
        problem67259.solution(new int[][]{{0,0,0,0,0,0},{0,1,1,1,1,0},{0,0,1,0,0,0},{1,0,0,1,0,1},{0,1,0,0,0,1},{0,0,0,0,0,0}});
    }

    public int solution(int[][] board) {
        int answer = 0;
        int n = board.length;
        visited = new int[n][n];
        directRow = new int[]{1, 0, -1, 0};
        directCol = new int[]{0, 1, 0, -1};
        price = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == 1) visited[i][j] = 1;
                else visited[i][j] = 0;
            }
        }
        dfs(0, 0, n-1, 'N', 0);
        answer = price;
        return answer;
    }

    private void dfs(int startRow, int startCol, int end,  char mode, int sum) {
        if (startRow == end && startCol == end && sum < price) {
            price = sum;
            return;
        }

        if (sum < price && visited[startRow][startCol] == 0) {
            visited[startRow][startCol] = 1;
            for (int i = 0; i < 4; i++) {
                int nextRow = startRow + directRow[i];
                int nextCol = startCol + directCol[i];
                char currentMode = mode;
                int checkRow , checkCol = 0;
                int total = sum;
                if (nextRow >= 0 && nextRow <= end && nextCol >= 0 && nextCol <= end) {
                    checkRow = nextRow - startRow;
                    checkCol = nextCol - startCol;
                    if (mode == 'N') {
                        currentMode = checkRow != 0 ? 'R' : 'C';
                    } else if (mode == 'R') {
                        currentMode = checkCol != 0 ? 'C' : 'R';
                        total = checkCol != 0 ? total + 500 : total;
                    } else {
                        currentMode = checkRow != 0 ? 'R' : 'C';
                        total = checkRow != 0 ? total + 500 : total;
                    }
                    total += 100;
                    dfs(nextRow, nextCol, end, currentMode, total);
                }
            }
            visited[startRow][startCol] = 0;
        }
    }
}
