package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem14400 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] rowPos = new int[N];
        int[] colPos = new int[N];
        int[][] board = new int[N][2];

        long ans = 0;

        Arrays.sort(rowPos);
        Arrays.sort(colPos);

        long row = 0;
        long col = 0;

        for(int i=0;i<N;i++) {
            colPos[i] = sc.nextInt();
            rowPos[i] = sc.nextInt();

            board[i][0] = rowPos[i];
            board[i][1] = colPos[i];
        }

        Arrays.sort(rowPos);
        Arrays.sort(colPos);

        row = calc(rowPos, N);
        col = calc(colPos, N);

        for(int i=0;i<N;i++) {
            ans += Math.abs(row - board[i][0]) + Math.abs(col - board[i][1]);
        }

        System.out.println(ans);
    }

    static long calc(int[] consumer, int N) {
        int ans = 0;

        if (N % 2 == 0) {
            int left = (N/2) - 1;
            int right = left + 1;

            int ln = 0;
            int rn = 0;

            for(int i=0;i<N;i++) {
                if (i != left) ln += Math.abs(consumer[left] - consumer[i]);
                if (i != right) rn += Math.abs(consumer[right] - consumer[i]);
            }
            ans = ln > rn ? right : left;
        } else {
            ans = N / 2;
        }

        return consumer[ans];
    }

}
