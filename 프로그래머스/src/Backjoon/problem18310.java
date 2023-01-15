package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem18310 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] board = new int[N];

        for(int i=0;i<N;i++) board[i] = sc.nextInt();

        int ans = 0;

        Arrays.sort(board);

        if (N % 2 == 0) {
            int leftMiddle = (N/2)-1;
            int rightMiddle = leftMiddle+1;

            int a1 = 0;
            int a2 = 0;

            for(int i=0;i<N;i++) if (i != leftMiddle) a1 += Math.abs(board[leftMiddle]- board[i]);
            for(int i=0;i<N;i++) if (i != rightMiddle) a2 += Math.abs(board[rightMiddle] - board[i]);

            ans = a1 > a2 ? rightMiddle : leftMiddle;
        } else {
            ans = N/2;
        }

        System.out.println(board[ans]);
    }
}
