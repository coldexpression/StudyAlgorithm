package Level2;

import java.util.*;

public class problem77485 {

    static int index;
    static int min;

    public static void main(String[] args) {
        problem77485 problem77485 = new problem77485();
//        problem77485.solution(3, 3, new int[][]{{1,1,2,2},{1,2,2,3},{2,1,3,2},{2,2,3,3}});
        problem77485.solution(6, 6, new int[][]{{1,1,6,6},{2,2,5,5},{3,3,4,4}});
    }

    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        int[][] board = new int[rows][columns];
        int[] subBoard;
        int count = 0;
        min = 1000001;
        board = init(board, rows, columns);
        for(int i=0;i< queries.length;i++) {
            int startRow = queries[i][0]-1;
            int startCol = queries[i][1]-1;
            int endRow = queries[i][2]-1;
            int endCol = queries[i][3]-1;
            index = 0;
            subBoard = subBoardInit(board, startRow, startCol, endRow, endCol);
            board = right(board, subBoard, startRow, startCol, endRow, endCol);
            board = down(board, subBoard, startRow, startCol, endRow, endCol);
            board = left(board, subBoard, startRow, startCol, endRow, endCol);
            board = up(board, subBoard, startRow, startCol, endRow, endCol);
            System.out.println("["+i+" 번째 회전]");
            printBoard(board);
            answer[count++] = min;

            min = 1000001;
        }

        return answer;
    }

    private void printBoard(int[][] board) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }

    private int[][] init(int[][] board, int rows, int columns) {
        int count = 1;
        for(int i=0;i<rows;i++) {
            for (int j = 0; j < columns; j++) {
                board[i][j] = count;
                count++;
            }
        }
        return board;
    }

    private int[] subBoardInit(int[][] board, int startRow, int startCol, int endRow, int endCol) {
        List<Integer> store = new ArrayList<>();
        for(int i=startCol;i<=endCol;i++) {
            store.add(board[startRow][i]);
            min = Math.min(board[startRow][i], min);
        }

        for(int i=startRow+1;i<=endRow;i++) {
            store.add(board[i][endCol]);
            min = Math.min(board[i][endCol], min);
        }

        for(int i=endCol-1;i>=startCol;i--) {
            store.add(board[endRow][i]);
            min = Math.min(board[endRow][i], min);
        }

        for(int i=endRow-1;i>startRow;i--) {
            store.add(board[i][startCol]);
            min = Math.min(board[i][startCol], min);
        }
        System.out.println("subBoard >> " + store);
        System.out.println("min >> " + min);
        return store.stream().mapToInt(i -> i).toArray();
    }

    private int[][] right(int[][] board, int[] subBoard,int startRow, int startCol, int endRow, int endCol) {
        for(int i=startCol+1;i<=endCol;i++)
            board[startRow][i] = subBoard[index++];

        return board;
    }

    private int[][] down(int[][] board, int[] subBoard,int startRow, int startCol, int endRow, int endCol) {
        for(int i=startRow+1;i<=endRow;i++)
            board[i][endCol] = subBoard[index++];

        return board;
    }

    private int[][] left(int[][] board, int[] subBoard,int startRow, int startCol, int endRow, int endCol) {
        for(int i=endCol-1;i>=startCol;i--)
            board[endRow][i] = subBoard[index++];

        return board;
    }

    private int[][] up(int[][] board, int[] subBoard,int startRow, int startCol, int endRow, int endCol) {
        for(int i=endRow-1;i>=startRow;i--)
            board[i][startCol] = subBoard[index++];

        return board;
    }


}
