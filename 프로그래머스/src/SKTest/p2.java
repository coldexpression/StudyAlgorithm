package SKTest;

public class p2 {

    static int[][] answer;

    public static void main(String[] args) {
        p2 p2 = new p2();
        p2.solution(8, true);
    }

    public int[][] solution(int n, boolean clockwise) {
        int currentRow = 0;
        int maxMinus = n % 2 == 0 ? n / 2 : (n / 2) + 1;
        int maxNum = 0;
        answer = new int[n][n];

        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                answer[i][j] = -1;

        answer[0][0] = 1;


        if (n > 1) {
            answer[0][answer.length-1] = 1;
            answer[answer.length-1][0] = 1;
            answer[answer.length-1][answer.length-1] = 1;
        }

        if (clockwise) {
            if (n == 1) {
                return new int[][]{{1}};
            } else if (n == 2) {
                return new int[][]{{1,2},{2,1}};
            }
            int col = 0;
            int row = 0;
            int minus = 1;
            // 위
            while(true) {
                col = right(col, row, minus++);
                if (maxMinus < minus ) break;
                row = down(col, row, minus++);
                if (maxMinus < minus ) break;
                col = left(col, row, minus++);
                if (maxMinus < minus ) break;
                row = up(col, row, minus++);
                if (maxMinus < minus ) break;
            }

            minus = 1;
            col = answer.length - 1;
            row = 0;
            // 오른쪽
            while(true) {
                row = down(col, row, minus++);
                if (maxMinus < minus ) break;
                col = left(col, row, minus++);
                if (maxMinus < minus ) break;
                row = up(col, row, minus++);
                if (maxMinus < minus ) break;
                col = right(col, row, minus++);
                if (maxMinus < minus ) break;
            }

            minus = 1;
            col = answer.length - 1;
            row = col;

            // 아래
            while(true) {
                col = left(col, row, minus++);
                if (maxMinus < minus ) break;
                row = up(col, row, minus++);
                if (maxMinus < minus ) break;
                col = right(col, row, minus++);
                if (maxMinus < minus ) break;
                row = down(col, row, minus++);
                if (maxMinus < minus ) break;
            }

            minus = 1;
            col = 0;
            row = answer.length - 1;

            // 왼쪽
            while(true) {
                row = up(col, row, minus++);
                if (maxMinus < minus ) break;
                col = right(col, row, minus++);
                if (maxMinus < minus ) break;
                row = down(col, row, minus++);
                if (maxMinus < minus ) break;
                col = left(col, row, minus++);
                if (maxMinus < minus ) break;
            }

            maxNum = answer[row][col]+1;
            System.out.println("row " + row);
            System.out.println("col " + col);
            System.out.println(answer[row][col]);
//            if (n % 2 != 0 && answer[row][col] == -1) answer[answer.length/2][answer.length/2] = maxNum;
        } else {

        }

        for(int i=0;i<n;i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(answer[i][j]);
            }
            System.out.println();
        }
        return answer;
    }

    private int right(int startCol, int startRow, int minus) {
        int pos = 0;
        int length = answer.length - startCol - minus;
        for(int i=1;i< answer.length - minus;i++) {
            if (answer[startRow][startCol+i] != -1) break;
             answer[startRow][startCol+i] = answer[startRow][startCol+i-1] + 1;
             pos = startCol + i;
        }
        return pos;
    }

    private int down(int startCol, int startRow, int minus) {
        int pos = 0;
        int length = answer.length - startRow - minus;
        for(int i=1;i<answer.length - minus;i++) {
            if (answer[startRow+i][startCol] != -1) break;
            answer[startRow+i][startCol] = answer[startRow+i-1][startCol] + 1;
            pos = startRow + i;
        }
        return pos;
    }

    private int left(int startCol, int startRow, int minus) {
        int pos = 0;
        int length = answer.length - startCol - minus;
        System.out.println("startRow >> " + startRow);
        System.out.println("startCol >> " + startCol);
        for(int i=1;i< answer.length - minus;i++) {
            if (answer[startRow][startCol-i] != -1) break;
            answer[startRow][startCol-i] = answer[startRow][startCol-i+1] + 1;
            pos = startCol - i;
        }
        return pos;
    }

    private int up(int startCol, int startRow, int minus) {
        int pos = 0;
        for(int i=1;i< answer.length - minus;i++) {
            if (answer[startRow-i][startCol] != -1) break;
            answer[startRow-i][startCol] = answer[startRow-i+1][startCol] + 1;
            pos = startRow - i;
        }
        return pos;
    }
}
