package Level2;

import java.util.*;

public class problem17679 {

    static boolean[][] visited;
    static char[][] game;
    static boolean check;

    public static void main(String[] args) {
        problem17679 problem17679 = new problem17679();
        problem17679.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"});
    }

    public int solution(int m, int n, String[] board) {
        int answer = 0;
        check = true;
        visited = new boolean[m][n];
        game = new char[m][n];
        for(int i=0;i<m;i++) {
            for (int j = 0; j < n; j++) {
                visited[i][j] = false;
                game[i][j] = board[i].charAt(j);
            }
        }

        while(check) {
            check = false;
            for (int i = 0; i < m-1; i++) {
                for (int j = 0; j < n; j++) {
                    if (game[i][j] != '0') {
                        dfs(i, j, game[i][j]);
                    }
                }
            }
            answer = block_clear(m, n);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                System.out.print("["+visited[i][j]+"] ");
            }
            System.out.println();
        }

        System.out.println(answer);


        return answer;
    }

    static void dfs(int row, int col, char pickBlock) {
        if (row == 4) {
            System.out.println("row : " + row);
            System.out.println("col : " + col);
            System.out.println("pickBlock : " + pickBlock);
        }
        if (row < game.length - 1 && pickBlock != '0') {
            // 가장 왼쪽 블록 일 때,
            if (col == 0) {
                // 대각선의 블록이 고른 블록과 같은 것 이라면,
                if (checker(row, col, row + 1, col + 1, pickBlock)) {
                    visited[row + 1][col + 1] = true;
                    dfs(row + 1, col + 1, pickBlock);
                }
            }
            // 가장 오른쪽 블록 일 때,
            else if (col == game[row].length - 1) {
                if (checker(row, col, row + 1, col - 1, pickBlock)) {
                    visited[row + 1][col - 1] = true;
                    dfs(row + 1, col - 1, pickBlock);
                }
            }
            // 중간 지점의 블록 일 때.
            else {
                if (checker(row, col, row + 1, col + 1, pickBlock)) {
                    System.out.println("오른쪽 대각선");
                    System.out.println("[row] : " + row);
                    System.out.println("[col] : " + col);
                    visited[row + 1][col + 1] = true;
                    dfs(row + 1, col + 1, pickBlock);
                }
                if (checker(row, col, row + 1, col - 1, pickBlock)) {
                    System.out.println("왼쪽 대각선");
                    System.out.println("[row] : " + row);
                    System.out.println("[col] : " + col);
                    visited[row + 1][col - 1] = true;
                    dfs(row + 1, col - 1, pickBlock);
                }
            }
        }

    }

    static boolean checker(int row, int col, int pivotRow, int pivotCol, char pickBlock) {
        if (game[pivotRow][pivotCol] == pickBlock && game[row][pivotCol] == pickBlock && game[row][pivotCol] == game[pivotRow][col]) {
            check = true;
            System.out.println("Checker!!");
            System.out.println("row -> " + row);
            System.out.println("col -> " + col);
            System.out.println("pivotRow -> " + pivotRow);
            System.out.println("pivotCol -> " + pivotCol);
            visited[row][pivotCol] = true;
            visited[pivotRow][col] = true;
            return true;
        }
        return false;
    }

    static int block_clear(int rows, int cols) {
        HashMap<Integer, Character> rowBoard = new HashMap<>();
        int answer = 0;
        for(int col=0; col<cols;col++) {
            int count = rows-1;

            for(int i=0;i<rows;i++) rowBoard.put(i,'0');

            for(int row=rows-1; row>=0;row--) {
                if (!visited[row][col]) {
                    rowBoard.put(count, game[row][col]);
                    count--;
                } else {
                    visited[row][col] = false;
                }
            }

            System.out.println("rowBoard : " + rowBoard);

            for(int key: rowBoard.keySet()) {
                if (game[key][col] == '0') answer++;
                game[key][col] = rowBoard.get(key);
            }
            rowBoard.clear();
        }
        return answer;
    }
}
