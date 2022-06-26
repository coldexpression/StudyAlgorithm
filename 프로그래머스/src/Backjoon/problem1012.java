package Backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem1012 {

    static int[] moveX = new int[]{-1,1,0,0};
    static int[] moveY = new int[]{0,0,-1,1};
    static int answer;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        int[] m = new int[t];
        int[] n = new int[t];
        int[] k = new int[t];
        int[][][] map = new int[t][][];

        for(int i=0;i<t;i++) {
            m[i] = sc.nextInt();
            n[i] = sc.nextInt();
            k[i] = sc.nextInt();


            map[i] = new int[n[i]][m[i]];
            for(int j=0;j<k[i];j++) {
                int x = sc.nextInt();
                int y = sc.nextInt();
                map[i][y][x] = 1;
            }

        }

        for(int i=0;i<t;i++) {
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n[i]][m[i]];
            int[][] detailMap = map[i];

            answer = 0;

            for(int j=0;j<n[i];j++) {
                for(int l=0;l<m[i];l++) {
                    if (detailMap[j][l] == 1) queue.add(new int[]{j, l});
                }
            }

            while(!queue.isEmpty()) {
                int[] pick = queue.poll();
                int x = pick[1];
                int y = pick[0];

                if (!visited[y][x]) {
                    visited[y][x] = true;
                    dfs(x, y, m[i], n[i], visited, map[i]);
                    answer++;
                }
            }

            System.out.println(answer);
        }
    }

    public static void dfs(int startX, int startY, int maxX, int maxY, boolean[][] visited, int[][] map) {

        for(int i=0;i<4;i++) {
            int nextX = startX + moveX[i];
            int nextY = startY + moveY[i];

            if (nextX >= 0 && nextX < maxX && nextY >= 0 && nextY < maxY && !visited[nextY][nextX] && map[nextY][nextX] != 0) {
                visited[nextY][nextX] = true;
                dfs(nextX, nextY, maxX, maxY, visited, map);
            }
        }

    }
}
