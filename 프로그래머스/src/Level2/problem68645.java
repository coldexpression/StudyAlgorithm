package Level2;

public class problem68645 {

    public static void main(String[] args) {
        problem68645 problem68645 = new problem68645();
        problem68645.solution(6);
    }

    public int[] solution(int n) {
        int[] answer = {};
        int[][] board = new int[n][n];
        int finishNumber = 0;
        int topStartPoint = 0;
        int topEndPoint = 0;
        int leftStartPoint = 0;
        int leftEndPoint = n-1;
        int rightPoint = 0;
        int count = 1;
        int check = 0;
        int index = 0;
        for(int i=1;i<=n;i++) finishNumber += i;
        answer = new int[finishNumber];

        System.out.println("종료 숫자");

        while(finishNumber >= count) {


            for (int i = topStartPoint; i < n; i++) {
                if (board[i][rightPoint] != 0) break;
                System.out.println("board["+i+"]["+rightPoint+"] = "+ count);
                board[i][rightPoint] = count++;
                check = i;
            }

            leftStartPoint = check;

            for (int i = rightPoint+1; i <= leftEndPoint; i++) {
                if (board[leftStartPoint][i] != 0) break;
                System.out.println("board["+leftStartPoint+"]["+i+"] = "+ count);
                board[leftStartPoint][i] = count++;
            }

            rightPoint = leftEndPoint;

            for (int i = leftStartPoint - 1; i > topStartPoint; i--) {
                if (board[i][rightPoint-1] != 0) break;
                System.out.println("board["+i+"]["+(rightPoint-1)+"] = "+ count);
                board[i][--rightPoint] = count++;
                topEndPoint = i;
            }

            topStartPoint = topEndPoint + 1;
            leftEndPoint = leftEndPoint - 2;

        }

        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[i].length;j++) {
                System.out.print(board[i][j]);
                if(board[i][j] == 0) break;
                answer[index++] = board[i][j];
            }
            System.out.println();
        }

        return answer;
    }
}
