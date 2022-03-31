package Level3;

import java.util.*;

public class problem42898 {

    static boolean[][] visited;
    static int[][] board;
    static int answer;

    public static void main(String[] args) {
        problem42898 problem42898 = new problem42898();
        problem42898.solution(4, 3, new int[][]{{2,2}});
    }

    public int solution(int m, int n, int[][] puddles) {
        answer = 0;
        int min = 0;
        board = new int[n][m];
        visited = new boolean[n][m];
        for(int i=0;i<visited.length;i++)
            Arrays.fill(visited[i], false);

        for(int i=0;i<puddles.length;i++) {
            int col = puddles[i][0] - 1;
            int row = puddles[i][1] - 1;
            board[row][col] = -1;
            visited[row][col] = true;
        }

        board[0][0] = 0;
        dfs(0, 0, n-1, m-1);
        System.out.println(answer);
        return answer;
    }

    private void dfs(int startRow, int startCol, int endRow, int endCol) {
        if (startRow == endRow && startCol == endCol) {
            answer = board[startRow][startCol];
            return ;
        }

        if (!visited[startRow][startCol]) {
//            System.out.println("["+startCol+","+startRow+"]");
            visited[startRow][startCol] = true;
            int prev;
            if (startRow + 1 <= endRow && startCol + 1 > endCol) {
                prev = board[startRow][startCol];
                board[startRow+1][startCol] = (board[startRow][startCol] + 1) % 1000000007;
                dfs(startRow+1, startCol, endRow, endCol);
                board[startRow+1][startCol] = prev;
            } else if (startCol + 1 <= endCol && startRow + 1 > endRow) {
                prev = board[startRow][startCol+1];
                board[startRow][startCol+1] = (board[startRow][startCol] + 1) % 1000000007;
                dfs(startRow, startCol + 1, endRow, endCol);
                board[startRow][startCol+1] = prev;
            } else if (startRow + 1 <= endRow && startCol + 1 <= endCol) {
                prev = board[startRow][startCol];
                board[startRow+1][startCol] = (board[startRow][startCol] + 1) % 1000000007;
                dfs(startRow+1, startCol, endRow, endCol);
                board[startRow+1][startCol] = prev;
                board[startRow][startCol+1] = (board[startRow][startCol] + 1) % 1000000007;
                dfs(startRow, startCol + 1, endRow, endCol);
                board[startRow][startCol+1] = prev;
            }
            visited[startRow][startCol] = false;
        }

    }
}
