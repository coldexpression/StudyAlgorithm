package Level2;
import java.util.*;

public class problem87390 {

    public static void main(String[] args) {
        problem87390 problem87390 = new problem87390();
        problem87390.solution(3, 2, 5);
    }

    public long[] solution(int n, long left, long right) {
        long[] answer = {};
        List<Long> store = new ArrayList<>();
        long startRow = left/n;
        long startCol = left%n;
        long endRow = right/n;
        long endCol = right%n;
        answer = new long[(int)(right-left)+1];
        int index = 0;

        for(long i=startRow;i<=endRow;i++) {
            for(long j=startCol;j<n;j++) {
                if (i == 0) answer[index++] = ((i+1) + j);
                else if (j <= i) answer[index++] = (i+1);
                else answer[index++] = ((i+1)+(j-i));
                if (i == endRow && j == endCol) break;

            }
            startCol = 0;
        }


        return answer;
    }

//    public int[] solution(int n, long left, long right) {
//        List<Integer> store = new ArrayList<>();
//        int[] answer = {};
//        long[][] board = new long[n][n];
//        long[] newBoard;
//        int[] resultBoard;
//        int startRow = 0;
//        int startCol = 0;
//        int endRow = 0;
//        int endCol = 0;
//        board = init(board);
//        for(int i=0;i<n;i++) board = fillBoard(board, i);
//
//        for(int i=0;i<board.length;i++) {
//            System.out.println();
//            for (int j = 0; j < board[0].length; j++)
//                System.out.print(board[i][j]);
//        }
//
//        startRow = (int)(left/n);
//        startCol = (int)(left%n);
//        endRow = (int)(right/n);
//        endCol = (int)(right%n);
//
//        for(int i=startRow;i<=endRow;i++) {
//            for(int j=startCol;j<=n-1;j++) {
//                store.add((int)board[i][j]);
//                if (i == endRow && j == endCol) break;
//            }
//            startCol = 0;
//        }
//
//        resultBoard = store.stream().mapToInt(i->i).toArray();
//
////        newBoard = cutBoard(board, n*n);
////        resultBoard = divideBoard(newBoard, left, right);
//        return resultBoard;
//    }

    private long[] divideBoard(long[] newBoard, long left, long right) {
        int count = 0;
        long[] resultBoard = new long[(int) ((right-left)+1)];
        for(long i=left;i<=right;i++) {
            resultBoard[count] = newBoard[(int) i];
            count++;
        }
        return resultBoard;
    }

    private long[] cutBoard(long[][] board, int size) {
        long[] newBoard = new long[size];
        int count = 0;
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                newBoard[count] = board[i][j];
                count++;
            }
        }
        return newBoard;
    }

    private long[][] fillBoard(long[][] board, int start) {
        for(int i=0;i<=start;i++) {
            for(int j=0;j<=start;j++) {
                if (board[i][j] == 0) board[i][j] = start+1;
            }
        }
        return board;
    }

    private long[][] init(long[][] board) {
        for(int i=0;i<board.length;i++)
            for(int j=0;j<board[0].length;j++)
                board[i][j] = 0;
            return board;
    }
}
