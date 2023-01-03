package SSAFY.TemporaryTest;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem1249 {

    static int[] moveRow = new int[]{-1,1,0,0};
    static int[] moveCol = new int[]{0,0,-1,1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();
        for(int t=1;t<=T;t++) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o1[2] - o2[2];
                }
            });

            int N = sc.nextInt();

            sb.append("#").append(t).append(" ");

            int[][] map = new int[N][N];
            boolean[][] visited = new boolean[N][N];

            for(int i=0;i<N;i++) {
                String word = sc.next();
                for (int j = 0; j < N; j++) {
                    map[i][j] = Character.getNumericValue(word.charAt(j));
                }
            }

            queue.add(new int[]{0,0, 0});
            visited[0][0] = true;

            while(!queue.isEmpty()) {
                int[] pos = queue.poll();

                if (pos[0] == (N-1) && pos[1] == (N-1)) {
                    sb.append(pos[2]).append("\n");
                    break;
                }

                for(int i=0;i<4;i++) {
                    int r1 = pos[0] + moveRow[i];
                    int c1 = pos[1] + moveCol[i];

                    if (r1 >= 0 && r1 < N && c1 >= 0 && c1 < N && !visited[r1][c1]) {
                        visited[r1][c1] = true;
                        queue.add(new int[]{r1, c1, pos[2] + map[r1][c1]});
                    }
                }
            }

        }
        System.out.println(sb.toString());
    }
}
