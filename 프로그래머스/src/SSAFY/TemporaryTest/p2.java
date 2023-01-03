package SSAFY.TemporaryTest;

import java.util.Arrays;
import java.util.Scanner;

public class p2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=T;i++) {
            int[] board = new int[10];

            for(int j=0;j<10;j++) board[j] = sc.nextInt();


            int max = Arrays.stream(board).max().getAsInt();

            sb.append("#").append(i).append(" ").append(max).append("\n");
        }

        System.out.println(sb.toString());
    }
}
