package Backjoon;

import java.util.Scanner;

public class problem11049 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] alph = new int[N+1][2];
        int answer = Integer.MAX_VALUE;

        for(int i=1;i<=N;i++) {
            alph[i][0] = sc.nextInt();
            alph[i][1] = sc.nextInt();
        }

        int[][] dp = new int[N+1][N+1];

//        for(int i=1;i<=N;i++)
//            for(int j=1;j<=N;j++)
//                dp[i][j] = Integer.MAX_VALUE;

        for(int i=1;i<N;i++) {
            dp[2][i] = alph[i][0]*alph[i][1]*alph[i+1][1];
        }

        for(int i=3;i<=N;i++) {
            System.out.println("i >> " + i);
            for(int j=1;j<=N-i+1;j++) {
                System.out.println("j >> " + j);
                dp[i][j] = Integer.MAX_VALUE;

                for(int k=0;k<=1;k++) {
                    int temp = 0;
                    System.out.println("k >> " + k);

                    if (k == 0) {
                        temp = dp[i-1][j];
                        int sub = 1;

                        for(int l=0;l<i;l++) {
                            if (l == 0) sub = alph[j+l][0];
                            else sub *= alph[j+l][1];
                        }

                        temp += sub;

                        System.out.println("k == 0 => " + temp);

                        dp[i][j] = Math.min(dp[i][j], temp);
                    } else {
                        temp = dp[i-1][j+1];
                        int sub = 1;

                        for(int l=0;l<i;l++) {
                            if (l == i-1) sub *= alph[j+l][1];
                            else sub *= alph[j+l][0];
                        }

                        temp += sub;

                        System.out.println("k != 0 => " +temp);

                        dp[i][j] = Math.min(dp[i][j], temp);
                    }
                }
            }
        }

        for(int i=1;i<=N;i++) {
            for(int j=1;j<=N;j++) {
                System.out.print("["+dp[i][j]+"]");
            }
            System.out.println();
        }

        System.out.println(dp[N][1]);
    }
}
