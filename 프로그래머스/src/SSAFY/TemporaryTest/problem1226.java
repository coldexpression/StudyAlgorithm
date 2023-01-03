package SSAFY.TemporaryTest;

import java.util.Scanner;

public class problem1226 {

    static int[] moveRow = new int[]{-1,1,0,0};
    static int[] moveCol = new int[]{0,0,-1,1};
    static boolean check;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        for(int i=1;i<=10;i++) {
            int tNum = sc.nextInt();

            int[][] map = new int[16][16];
            boolean[][] visited = new boolean[16][16];
            check = false;

            for(int row=0;row<16;row++) {
                String line = sc.next();
                for (int col = 0; col < 16; col++) {
                    map[row][col] = Character.getNumericValue(line.charAt(col));
                    visited[row][col] = map[row][col] == 1;
                }
            }

            dfs(1, 1, visited, map);

            sb.append("#").append(tNum).append(" ").append(check ? 1 : 0).append("\n");
        }

        System.out.println(sb.toString());
    }

    static public void dfs(int r1, int c1, boolean[][] visited, int[][] map) {
        if (check) return;

        if (map[r1][c1] == 3) {
            check = true;
            return ;
        }

        for(int i=0;i<4;i++) {
            int nextR1 = r1 + moveRow[i];
            int nextC1 = c1 + moveCol[i];

            if (nextR1 >= 0 && nextR1 < 16 && nextC1 >= 0 && nextC1 < 16 && !visited[nextR1][nextC1]) {
                visited[nextR1][nextC1] = true;
                dfs(nextR1, nextC1, visited, map);
                visited[nextR1][nextC1] = false;
            }
        }
    }
}
