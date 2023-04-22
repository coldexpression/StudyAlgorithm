package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class problem1937 {
    static int[][] map;
    static int[][] dp;
    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,-1,1};
    static int n;
    static int zeroCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(bf.readLine());
        PriorityQueue<int[]> pq = new PriorityQueue<int[]>((o1,o2) -> o2[2] - o1[2]);

        n = Integer.parseInt(st.nextToken());
        map = new int[n][n];
        dp = new int[n][n];

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                pq.add(new int[] {i, j, map[i][j]});
            }
        }

        zeroCnt = n*n;

        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int r = info[0]; int c = info[1]; int val = info[2];
            int max = 0;
            for(int i=0;i<4;i++) {
                int nr = r + moveRow[i];
                int nc = c + moveCol[i];

                if (isCheck(nr, nc)) {
                    if (map[nr][nc] > val && dp[nr][nc] > max) {
                        max = dp[nr][nc];
                    }
                }
            }
            dp[r][c] = max + 1;
        }

        System.out.println(findAns());
        printf();

    }

    public static void printf() {
        for(int i=0;i<n;i++) {
            System.out.println();
            for(int j=0;j<n;j++) {
                System.out.print(dp[i][j] + " ");
            }
        }
        System.out.println();
    }

    public static int findAns() {
        int ans = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }


    public static boolean isCheck(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }
}