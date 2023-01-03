package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem1961 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i <= T; i++) {
            int N = sc.nextInt();

            int[][][] map = new int[4][N][N];

            for (int row = 0; row < N; row++)
                for (int col = 0; col < N; col++)
                    map[0][row][col] = sc.nextInt();

            for (int j = 1; j <= 3; j++) {

                for (int row = 0; row < N; row++) {
                    for (int col = 0; col < N; col++) {
                        map[j][row][col] = map[j - 1][N - col - 1][row];
                    }
                }
            }

            sb.append("#").append(i).append("\n");

            for (int row = 0; row < N; row++) {
                for (int idx = 1; idx <= 3; idx++) {
                    for (int col = 0; col < N; col++) {
                        sb.append(map[idx][row][col]);
                    }
                    sb.append(" ");
                }
                sb.append("\n");
            }
        }

        System.out.println(sb.toString());
    }
}
