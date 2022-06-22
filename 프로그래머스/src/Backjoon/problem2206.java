package Backjoon;

import java.util.*;

public class problem2206 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] moveRow = new int[]{-1, 1, 0, 0};
        int[] moveCol = new int[]{0, 0, 1, -1};

        int N = sc.nextInt();
        int M = sc.nextInt();
        String[] words = new String[N];
        int answer = -1;

        int[][] map = new int[N][M];
        boolean[][][] visited = new boolean[N][M][2];
        int[][] score = new int[N][M];

        for (int i = 0; i < N; i++) {
            words[i] = sc.next();
        }

        for (int i = 0; i < N; i++) {
            String word = words[i];
            System.out.println(word);
            for (int j = 0; j < word.length(); j++) {
                map[i][j] = Character.getNumericValue(word.charAt(j));
            }
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1, 0});

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            System.out.println("현재 좌표 : [" + info[0] + ", " + info[1] + "] ===> " + info[2] + " // 블록 파괴 여부 ===> " + info[3]);

            if (info[0] == N - 1 && info[1] == M - 1) {
                answer = info[2];
                break;
            }

            for (int i = 0; i < 4; i++) {
                int nextRow = info[0] + moveRow[i];
                int nextCol = info[1] + moveCol[i];

                if (nextRow >= 0 && nextRow < N && nextCol >= 0 && nextCol < M) {
                    if (!visited[nextRow][nextCol][info[3]]) {
                        if (map[nextRow][nextCol] == 1 && info[3] == 0) {
                            visited[nextRow][nextCol][info[3]] = true;
                            score[nextRow][nextCol] = info[2] + 1;
                            queue.add(new int[]{nextRow, nextCol, info[2] + 1, 1});
                        } else if (map[nextRow][nextCol] == 0) {
                            visited[nextRow][nextCol][info[3]] = true;
                            score[nextRow][nextCol] = info[2] + 1;
                            queue.add(new int[]{nextRow, nextCol, info[2] + 1, info[3]});
                        }
                    }
                }
            }
        }
        if (N == 1 && M == 1) answer = 0;

        System.out.println(answer);
    }
}
