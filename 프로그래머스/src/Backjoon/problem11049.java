package Backjoon;

import java.util.Scanner;

public class problem11049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] alph = new int[N+1][2];
        int[] v = new int[N+1];
        int answer = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++) {
            alph[i][0] = sc.nextInt();
            alph[i][1] = sc.nextInt();
        }

        for(int i=1;i<=N;i++) {
            if (i == 1) {
                v[0] = alph[1][0];
                v[1] = alph[1][1];
            } else {
                v[i] = alph[i][1];
            }
        }

        int[][] dp = new int[N][N];

        for(int i=2;i<N+1;i++) {
            for(int j=0;j<N-i+1;j++) {
                dp[j][j+i-1] = Integer.MAX_VALUE;
                for(int k=j;k<j+i-1;k++) {
                    int temp = dp[j][k] + dp[k+1][j+i-1] + (v[j]*v[k+1]*v[j+i]);
                    dp[j][j+i-1] = Math.min(dp[j][j+i-1], temp);
                }

            }
        }


        System.out.println(dp[0][N-1]);
    }
}
