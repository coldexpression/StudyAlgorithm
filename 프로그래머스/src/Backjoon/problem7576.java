package Backjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem7576 {

    static int[] moveX = new int[]{-1,1,0,0};
    static int[] moveY = new int[]{0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int answer = -1;
        int count = 0;

        int[][] map = new int[n][m];
        boolean[][] visited = new boolean[n][m];
        Queue<int[]> queue = new LinkedList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                int input = sc.nextInt();
                map[i][j] = input;
                if (map[i][j] == 1) {
                    queue.add(new int[]{i, j, 0});
                    count++;
                } else if (map[i][j] == -1) {
                    visited[i][j] = true;
                }
            }
        }

        if (count == m*n) {
            answer = 0;
        } else {
            while (!queue.isEmpty()) {
                int[] pick = queue.poll();
                int currentX = pick[1];
                int currentY = pick[0];
                int time = pick[2];

                if (!visited[currentY][currentX]) {
                    visited[currentY][currentX] = true;

                    for (int i = 0; i < 4; i++) {
                        int nextX = currentX + moveX[i];
                        int nextY = currentY + moveY[i];

                        if (nextX >= 0 && nextX < m && nextY >= 0 && nextY < n && !visited[nextY][nextX]) {
                            queue.add(new int[]{nextY, nextX, time + 1});
                        }
                    }
                    answer = time;
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (!visited[i][j]) {
                        answer = -1;
                        break;
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
