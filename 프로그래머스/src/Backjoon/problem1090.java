package Backjoon;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class problem1090 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        long[] ans = new long[N];

        int[][] board = new int[N][2];
        int[][] sortedBoard = new int[N][2];

        int[] row = new int[N];
        int[] col = new int[N];

        for (int i = 0; i < N; i++) {
            col[i] = sc.nextInt();
            row[i] = sc.nextInt();
            board[i][1] = sortedBoard[i][1] = col[i];
            board[i][0] = sortedBoard[i][0] = row[i];
        }

        Arrays.sort(col);
        Arrays.sort(row);

        Arrays.fill(ans, Integer.MAX_VALUE);

        ans[0] = 0;

        for (int i = 1; i < N; i++) {
            int num = i + 1;

            System.out.println("현재 Num : " + num);
            for (int k = 0; k + i < N; k++) {
                int pivotRow = 0;
                int pivotCol = 0;
                long sum = 0;

                for (int j = k; j < num + k; j++) {
                    System.out.println("j >> " + j);
                    pivotRow += row[j];
                    pivotCol += col[j];
                }

                /* 중간 지점 */
                final int pRow = (int) Math.round((double) pivotRow / num);
                final int pCol = (int) Math.round((double) pivotCol / num);

                System.out.println("중간 지점 : [" + pRow + ", " + pCol + "]");

                Arrays.sort(sortedBoard, new Comparator<int[]>() {
                    @Override
                    public int compare(int[] o1, int[] o2) {
                        int d1 = Math.abs(o1[0] - pRow) + Math.abs(o1[1] - pCol);
                        int d2 = Math.abs(o2[0] - pRow) + Math.abs(o2[1] - pCol);

                        return d1 - d2;
                    }
                });

                /* 중간 값 기준 */
                for (int j = 0; j < num; j++) {
                    sum += Math.abs(sortedBoard[j][0] - pRow) + Math.abs(sortedBoard[j][1] - pCol);
                }

                System.out.println("최초 중간 값 결과 : " + sum);

                ans[i] = sum;

                for (int idx = 0; idx < N; idx++) {
                    sum = 0;

                    int finalIdx = idx;

                    System.out.println("이후 중간 지점 : [" + sortedBoard[idx][0] + ", " + sortedBoard[idx][1] + "]");
                    Arrays.sort(board, new Comparator<int[]>() {
                        @Override
                        public int compare(int[] o1, int[] o2) {
                            int d1 = Math.abs(o1[0] - sortedBoard[finalIdx][0]) + Math.abs(o1[1] - sortedBoard[finalIdx][1]);
                            int d2 = Math.abs(o2[0] - sortedBoard[finalIdx][0]) + Math.abs(o2[1] - sortedBoard[finalIdx][1]);

                            return d1 - d2;
                        }
                    });

                    for (int j = 0; j < num; j++) {
                        sum += Math.abs(board[j][0] - sortedBoard[idx][0]) + Math.abs(board[j][1] - sortedBoard[idx][1]);
                    }
                    System.out.println("반복 중간 값 결과 : " + sum);
                    //132
                    ans[i] = Math.min(ans[i], sum);
                }
            }
        }
        Arrays.stream(ans).forEach(x -> System.out.print(x + " "));
    }

}
