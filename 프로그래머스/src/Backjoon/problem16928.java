package Backjoon;

import java.util.*;

public class problem16928 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        int answer = 0;
        boolean[] visited = new boolean[101];

        int[][] ledder = new int[N][2];
        for(int i=0;i<N;i++) {
            ledder[i][0] = sc.nextInt();
            ledder[i][1] = sc.nextInt();
        }

        int[][] snakes = new int[M][2];
        for(int i=0;i<M;i++) {
            snakes[i][0] = sc.nextInt();
            snakes[i][1] = sc.nextInt();
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        while(!queue.isEmpty()) {
            int[] currentPos = queue.poll();
            System.out.println("현재 좌표 : [" + currentPos[0] + "] ===>" + currentPos[1]);

            if (currentPos[0] == 100) {
                answer = currentPos[1];
                break;
            }

            for(int i=0;i<ledder.length;i++) currentPos[0] = currentPos[0] == ledder[i][0] ? ledder[i][1] : currentPos[0];
            for(int i=0;i<snakes.length;i++) currentPos[0] = currentPos[0] == snakes[i][0] ? snakes[i][1] : currentPos[0];


            for(int i=1;i<=6;i++) {
                int nextPos = currentPos[0] + i;

                if (nextPos >= 1 && nextPos <= 100 && !visited[nextPos]) {
                    visited[nextPos] = true;
                    queue.add(new int[]{nextPos, currentPos[1] + 1});
                }
            }
        }
        System.out.println(answer);
    }
}
