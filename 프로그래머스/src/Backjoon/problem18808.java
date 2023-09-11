package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class problem18808 {
    static boolean finish = false;
    static class Puzzle{
        private int[][] position;
        private int r;
        private int c;

        public Puzzle(int[][] position, int r, int c) {
            this.position = position;
            this.r = r;
            this.c = c;
        }


        @Override
        public String toString() {
            return "Puzzle{" +
                    "r=" + r +
                    ", c=" + c +
                    '}';
        }

        public Puzzle rotate() {
            int nRow = 0;
            int nCol = this.r - 1;
            int[][] position = new int[this.c][this.r];
            for(int col=0;col<this.c;col++) {
                for(int row=0;row<this.r;row++) {
                    position[nRow][nCol--] = this.position[row][col];
                    if (row == this.r - 1) nCol = this.r - 1;
                }
                nRow++;
            }
            return new Puzzle(position, this.c, this.r);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] board = new int[n][m];
        Puzzle[] puzzles = new Puzzle[k];
        for(int i=0;i<k;i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int[][] position = new int[r][c];
            for(int j=0;j<r;j++) {
                st = new StringTokenizer(bf.readLine());
                for(int l=0;l<c;l++) position[j][l] = Integer.parseInt(st.nextToken());
            }
            puzzles[i] = new Puzzle(position, r, c);
        }

        /**
         * 1. 스티커를 회전시키지 않고 단순히 이동하면서 보드에 넣기
         * 2. 스티커를 붙일수 있는 위치(다른 스티커와 겹치지않거나, 보드가 넘어가지 않는곳) 를 ㄹㅊ자는다
         * 3. 그 위치가 여러개라면 가장 위쪽에 해당하는 위치를 선택
         * 4. (3) 의 위치가 여러개라면 가장 왼쪽에 해당하는 위치를 선택
         * 5. 그래도 스티커를 붙일 수 없다면 90도 오른쪽으로 회전 시키고 (2)번으로 이동
         * 6. 회전각이 다시 원점으로 돌아오면 해당 스티커는 버린다.
         */

        start(0, puzzles, false, board, n, m, 0, 0);
        int answer = 0;
        for (int[] info : board) {
            answer += (int) Arrays.stream(info).filter(x -> x == 1).count();
        }
        System.out.println(answer);
    }

    public static void start(int index, Puzzle[] puzzles, boolean rotateCheck, int[][] board, int n, int m, int count, int rotateCount) {
        if (finish) return;
        if (index == puzzles.length) {
            finish = true;
            return;
        }
        if (rotateCount == 4) {
            start(index + 1, puzzles, false, board, n, m, count, 0);
            return;
        }

        Puzzle puzzle = rotateCheck ? puzzles[index].rotate() : puzzles[index];
        puzzles[index] = puzzle;
        boolean check = false;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (isLocated(puzzle, board, i, j, n, m)) {
                    attachSticker(puzzle, board, i, j);
                    System.out.println("[" + index + "] 스티커 부착!");
                    for (int[] info : board) {
                        System.out.println(Arrays.toString(info));
                    }
                    check = true;
                    break;
                }
            }
            if (check) break;
        }

        if(check) start(index+1, puzzles, false, board, n, m, count + 1, 0);
        else start(index, puzzles , true, board, n, m, count, rotateCount + 1);
    }

    public static void attachSticker(Puzzle puzzle, int[][] board, int row, int col) {
        for(int r=0;r< puzzle.r;r++) {
            for(int c=0;c< puzzle.c;c++) {
                int flag = puzzle.position[r][c];
                int cr = row + r;
                int cc = col + c;
                board[cr][cc] = flag == 1 ? 1 : board[cr][cc];
            }
        }
    }

    public static boolean isLocated(Puzzle puzzle, int[][] board, int row, int col, int n, int m) {
        System.out.println("검사 퍼즐 : " + puzzle);
        System.out.println("검사 위치 : [" + row + ", " + col + "]");
        if (puzzle.r == 3 && puzzle.c == 3) {
            for (int[] ints : puzzle.position) {
                System.out.println(Arrays.toString(ints));
            }
        }
        for(int r=0;r< puzzle.r;r++) {
            for(int c=0;c< puzzle.c;c++) {
                int flag = puzzle.position[r][c];
                int cr = row + r;
                int cc = col + c;
                if (!isOk(cr, cc, n, m) || (flag == 1 && board[cr][cc] == 1)) return false;
            }
        }
        return true;
    }

    public static boolean isOk(int row, int col, int n, int m) {
        return row >= 0 && row < n && col >= 0 && col < m;
    }

}
