package Level2;

public class problem12905 {

    public static void main(String[] args) {

    }

    public int solution(int [][]board) {
        int answer = 1;
        int count = 0;
        int m = board.length;
        int n = board[0].length;
        int min = Math.min(m, n);

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                count = board[i][j] == 1 ? count + 1 : count;
            }
        }

        count = Math.min((int)Math.sqrt(count), min);

        for(int i=count;i>1;i--) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<n;k++) {
                    if (board[j][k] != 0 && ((j+i <= m) || (k+i <= n))) {
                        if(checker(board, m, n, j, k, i)) return i*i;
                    }
                }
            }
        }
        return answer;
    }

    public boolean checker(int[][] board, int m, int n, int startRow, int startCol, int count) {
        int num = 0;

        for(int i=startRow;i<startRow+count;i++) {
            for(int j=startCol;j<startCol+count;j++) {
                if (i >= m || j >= n) break;
                if (board[i][j] == 0) break;
                num++;
            }
        }
        return num == count*count;
    }
}
