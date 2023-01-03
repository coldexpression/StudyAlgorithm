package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem1247 {
    static int min;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int t=1;t<=T;t++) {
            int N = sc.nextInt();

            min = Integer.MAX_VALUE;

            int[][] info = new int[N+2][2];
            boolean[] visited = new boolean[N];

            for(int i=0;i<N+2;i++) {
                if (i == 0) {
                    info[0][0] = sc.nextInt();
                    info[0][1] = sc.nextInt();
                } else if (i == 1) {
                    info[N+2-1][0] = sc.nextInt();
                    info[N+2-1][1] = sc.nextInt();
                } else {
                    info[i-1][0] = sc.nextInt();
                    info[i-1][1] = sc.nextInt();
                }
            }

            dfs(1, N, 0, 0, info, visited);
            sb.append("#").append(t).append(" ").append(min).append("\n");
        }
        System.out.println(sb.toString());
    }

    static void dfs(int start, int end, int prev, int sum, int[][] info, boolean[] visited) {
        if (start == (end+1)) {
            int score = Math.abs(info[prev][0] - info[end+1][0]) + Math.abs(info[prev][1] - info[end+1][1]);
            min = Math.min(min, sum + score);
            return ;
        }

        for(int i=1;i<=end;i++) {
            if (!visited[i-1]) {
                visited[i-1] = true;
                int score = Math.abs(info[prev][0] - info[i][0]) + Math.abs(info[prev][1] - info[i][1]);
                dfs(start+1, end, i, sum + score, info, visited);
                visited[i-1] = false;
            }
        }
    }
}
