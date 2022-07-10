package Backjoon;

import java.util.*;

public class problem2565 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] map = new int[N][2];
        int[] dp = new int[N];
        int answer = 0;
        for(int i=0;i<N;i++) {
            map[i][0] = sc.nextInt();
            map[i][1] = sc.nextInt();
        }

        Arrays.sort(map, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });

        for(int i=0;i<N;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if (map[i][1] > map[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }
        for(int i=0;i<N;i++) answer = Math.max(dp[i], answer);

        System.out.println(N - answer);

    }
}
