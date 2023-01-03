package SSAFY.TemporaryTest;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class problem1227 {

    static int[] moveRow = new int[]{-1,1,0,0};
    static int[] moveCol = new int[]{0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=10;i++) {
            Queue<int[]> queue = new LinkedList<>();

            int tNum = sc.nextInt();

            int[][] map = new int[100][100];
            boolean[][] visited = new boolean[100][100];
            boolean check = false;

            for(int row=0;row<100;row++) {
                String word = sc.next();
                for(int col=0;col<100;col++) {
                    map[row][col] = Character.getNumericValue(word.charAt(col));
                    visited[row][col] = map[row][col] == 1;
                }
            }

            queue.add(new int[]{1,1});
            visited[1][1] = true;

            while(!queue.isEmpty()) {
                int[] pos = queue.poll();

                if (map[pos[0]][pos[1]] == 3) {
                    check = true;
                    break;
                }

                for(int j=0;j<4;j++) {
                    int nextR = pos[0] + moveRow[j];
                    int nextC = pos[1] + moveCol[j];

                    if (nextR >= 0 && nextR < 100 && nextC >= 0 && nextC < 100 && !visited[nextR][nextC]) {
                        visited[nextR][nextC] = true;
                        queue.add(new int[]{nextR, nextC});
                    }
                }
            }

            sb.append("#").append(tNum).append(" ").append(check ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());
    }
}
