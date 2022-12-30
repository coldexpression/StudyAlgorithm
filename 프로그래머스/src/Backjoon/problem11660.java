package Backjoon;

import java.util.Scanner;

public class problem11660 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N+1][N+1];
        int[][] sum = new int[N+1][N+1];
        int[][] problem = new int[M][4];

        for(int i=1;i<=N;i++) {
            for (int j = 1; j <=N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        for(int i=1;i<=N;i++) {
            for (int j = 1; j <=N; j++) {
                if (j == 1) sum[i][j] = map[i][j];
                else sum[i][j] = sum[i][j-1] + map[i][j];
            }
        }


        for(int i=0;i<M;i++)
            for(int j=0;j<4;j++) problem[i][j] = sc.nextInt();

        for(int i=0;i<M;i++) {
            int ans = 0;
            if (problem[i][0] == problem[i][2]) {
                if (problem[i][1] == problem[i][3]) ans = map[problem[i][0]][problem[i][1]];
                else ans = sum[problem[i][0]][problem[i][3]] - sum[problem[i][0]][problem[i][1]-1];
            } else {
                for(int j=problem[i][0];j<=problem[i][2];j++) {
                    ans += sum[j][problem[i][3]] - sum[j][problem[i][1] -1];
                }
            }
            sb.append(ans).append("\n");
        }
        System.out.println(sb.toString());
    }
}
