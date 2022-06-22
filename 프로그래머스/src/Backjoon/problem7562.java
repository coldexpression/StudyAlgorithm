package Backjoon;

import java.util.*;

public class problem7562 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] moveRow = new int[]{2,-2,2,-2,1,-1,-1,1};
        int[] moveCol = new int[]{1,-1,-1,1,2,2,-2,-2};

        int T = sc.nextInt();
        for(int i=0;i<T;i++) {
            int I = sc.nextInt();
            int[][] map = new int[I][I];
            boolean[][] visited = new boolean[I][I];
            int startRow = sc.nextInt();
            int startCol = sc.nextInt();
            int endRow = sc.nextInt();
            int endCol = sc.nextInt();
            int answer = Integer.MAX_VALUE;

            Queue<int[]> queue = new LinkedList<>();
            queue.add(new int[]{startRow, startCol, 0});
            while(!queue.isEmpty()) {
                int[] currentPos = queue.poll();
                System.out.println("현재 좌표 : [" + currentPos[0] + ", " + currentPos[1] + "] ===> " + currentPos[2]);

                if (currentPos[0] == endRow && currentPos[1] == endCol) {
                    answer = currentPos[2];
                    break;
                }

                for(int j=0;j<8;j++) {
                    int nextRow = currentPos[0] + moveRow[j];
                    int nextCol = currentPos[1] + moveCol[j];

                    if (nextRow >= 0 && nextRow < I && nextCol >= 0 && nextCol < I && !visited[nextRow][nextCol]) {
                        visited[nextRow][nextCol] = true;
                        queue.add(new int[]{nextRow, nextCol, currentPos[2] + 1});
                    }
                }
            }

            System.out.println(answer);
        }
    }
}
