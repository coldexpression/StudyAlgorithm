package SSAFY.TemporaryTest;

import java.util.Arrays;
import java.util.Scanner;

public class p3 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();

        int[] board = new int[N];

        for(int i=0;i<N;i++) board[i] = sc.nextInt();

        Arrays.sort(board);

        System.out.println(board[N/2]);
    }
}
