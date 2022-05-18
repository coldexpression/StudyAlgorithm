package Level2;

public class problem12905 {

    public static void main(String[] args) {

    }

    public int solution(int [][]board) {
        int answer = 1;
        boolean check = false;
        int row = board.length;
        int col = board[0].length;

        for(int i=0;i<row;i++) {
            for (int j=0;j<col;j++) {
                if (board[i][j] == 1) {
                    check = true;
                    break;
                }
            }
        }

        if (!check) return 0;

        if (row == 1 || col == 1) return 1;

        for(int i=1;i<row;i++) {
            for(int j=1;j<col;j++) {
                int left = board[i][j-1];
                int up = board[i-1][j];
                int cross = board[i-1][j-1];
                board[i][j] = board[i][j] != 0 ? Math.min(Math.min(left, up), cross) + 1 : 0;
                answer = Math.max(answer, board[i][j]);
            }
        }

        answer *= answer;

        return answer;
    }

}
