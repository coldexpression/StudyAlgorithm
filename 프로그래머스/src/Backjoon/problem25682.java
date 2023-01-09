package Backjoon;

import java.util.Arrays;
import java.util.Scanner;

public class problem25682 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        int K = sc.nextInt();

        int ans = Integer.MAX_VALUE;

        char[][] map = new char[N+1][M+1];
        int[][] fB = new int[N+1][M+1];
        int[][] fW = new int[N+1][M+1];

        for(int i=1;i<=N;i++) {
            String line = sc.next();
            for(int j=0;j<M;j++) {
                map[i][j+1] = line.charAt(j);
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=M;j++) {
                if (j % 2 == 0) {
                    if (map[i][j] != 'W') {
                        fB[i][j] += fB[i][j-1] + 1;
                        fW[i][j] = fW[i][j-1];
                    }
                    else {
                        fW[i][j] += fW[i][j-1] + 1;
                        fB[i][j] = fB[i][j-1];
                    }
                } else {
                    if (map[i][j] != 'B') {
                        fB[i][j] = j == 1 ? 1 : fB[i][j] + fB[i][j-1] + 1;
                        fW[i][j] = j == 1 ? 0 : fW[i][j-1];
                    } else {
                        fB[i][j] = j == 1 ? 0 : fB[i][j-1];
                        fW[i][j] = j == 1 ? 1 : fW[i][j] + fW[i][j-1] + 1;
                    }
                }
            }
        }

        for(int i=1;i<=(N-K)+1;i++){
            for(int j=1;j<=(M-K)+1;j++) {
                int num = Math.min(findColorCount(i, j, K, 'W', fB, fW, ans), findColorCount(i, j, K, 'B', fB, fW, ans));
                if (ans > num) ans = num;
            }
        }

        System.out.println(ans);
    }

    static int findColorCount(int row, int col, int k, char target, int[][] fB, int[][] fW, int maxNum) {
        int count = 0;

        if (target == 'W') {
            for(int i=row;i<=row+k-1;i++) {
                if (count > maxNum) return Integer.MAX_VALUE;
                if (i % 2 != 0) {
                    if (col % 2 == 0) count += fB[i][col+k-1] - fB[i][col-1];
                    else count += fW[i][col+k-1] - fW[i][col-1];
                }
                else {
                    if (col % 2 == 0) count += fW[i][col+k-1] - fW[i][col-1];
                    else count += fB[i][col+k-1] - fB[i][col-1];
                }
            }
        } else {
            for(int i=row;i<=row+k-1;i++) {
                if (count > maxNum) return Integer.MAX_VALUE;
                if (i % 2 != 0) {
                    if (col % 2 == 0) count += fW[i][col+k-1] - fW[i][col-1];
                    else count += fB[i][col+k-1] - fB[i][col-1];
                }
                else {
                    if (col % 2 == 0) count += fB[i][col+k-1] - fB[i][col-1];
                    else count += fW[i][col+k-1] - fW[i][col-1];
                }
            }
        }

        return count;
    }
}
