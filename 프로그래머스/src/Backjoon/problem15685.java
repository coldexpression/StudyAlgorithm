package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem15685 {

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int ans = 0;
        int n = Integer.parseInt(bf.readLine());

        int[][] board = new int[101][101];

        for(int testCase=0;testCase<n;testCase++) {
            Stack<Character> stack = new Stack<>();
            Stack<Character> answerStack = new Stack<>();
            String input = bf.readLine();
            String[] word = input.split(" ");
            char dir = 0;

            /*
             * L -> D
             * D -> R
             * R -> U
             * U -> L
             * */

            int x = Integer.parseInt(word[0]);
            int y = Integer.parseInt(word[1]);
            int d = Integer.parseInt(word[2]);
            int g = Integer.parseInt(word[3]);

            if (d == 0) dir = 'R';
            else if (d == 1) dir = 'U';
            else if (d == 2) dir = 'L';
            else if (d == 3) dir = 'D';

            stack.add(dir);
            for(int i=0;i<g;i++) {
                Stack<Character> st = new Stack<>();
                Queue<Character> q = new LinkedList<>();
                while(!stack.isEmpty()) {
                    char direction = stack.pop();
                    q.add(trans(direction));
                    st.add(direction);
                }


                while(!st.isEmpty()) {
                    char c = st.pop();
                    stack.add(c);
                }

                while(!q.isEmpty()) {
                    char c = q.poll();
                    stack.add(c);
                }

                System.out.println(stack);
            }

            while(!stack.isEmpty()) answerStack.add(stack.pop());

            int[] pos = new int[] {y, x};
            board[pos[0]][pos[1]] = 1;

            while(!answerStack.isEmpty()) {
                char direction = answerStack.pop();
                pos = calc(pos[1], pos[0], direction);
                board[pos[0]][pos[1]] = 1;
            }
        }


        for(int i=0;i<board.length-1;i++) {
            for(int j=0;j<board.length-1;j++) {
                ans += returnNum(board, i, j);
            }
        }

        System.out.println(ans);


    }

    public static int returnNum(int[][] board ,int row, int col) {

        if (board[row][col] == 1 && board[row+1][col] == 1 && board[row][col+1] == 1 && board[row+1][col+1] == 1) {
            return 1;
        }

        return 0;
    }

    public static char trans(char c) {
        switch (c) {
            case 'L': return 'D';
            case 'D': return 'R';
            case 'R': return 'U';
            default: return 'L';
        }
    }

    public static int[] calc(int x, int y, char op) {
        switch (op) {
            case 'L':
                return new int[] {y, x-1};
            case 'D':
                return new int[] {y+1, x};
            case 'R':
                return new int[] {y, x+1};
            default:
                return new int[] {y-1, x};
        }
    }




}
