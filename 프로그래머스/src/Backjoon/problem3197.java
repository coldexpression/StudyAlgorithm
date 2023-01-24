package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem3197 {

    static int[] moveRow = {-1, 1, 0, 0};
    static int[] moveCol = {0, 0, 1, -1};
    static List<int[]> posList;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line = br.readLine();
        int r = Integer.parseInt(line.split(" ")[0]);
        int c = Integer.parseInt(line.split(" ")[1]);

        int sr = -1;
        int sc = -1;
        int er = -1;
        int ec = -1;

        posList = new ArrayList<>();

        int day = 0;

        ans = Integer.MAX_VALUE;

        int[][] lake = new int[r][c];

        for (int i = 0; i < r; i++) {
            String word = br.readLine();
            for (int j = 0; j < c; j++) {
                char input = word.charAt(j);
                if (input == 'X')
                    lake[i][j] = -1;
                else
                    lake[i][j] = 0;

                if (sr == -1 && input == 'L') {
                    sr = i;
                    sc = j;
                } else if (sr != -1 && input == 'L') {
                    er = i;
                    ec = j;
                }
            }
        }

        boolean[][] visited = new boolean[r][c];

        for (int i = 0; i < r; i++)
            for (int j = 0; j < c; j++)
                findFirstPoint(lake, visited, i, j, r, c);

//		System.out.println("posList Ele !!");
//		posList.forEach(x -> System.out.print("[" + x[0] + ", " + x[1] + "]"));
//		System.out.println();

        //printf(lake);
//		System.out.println("bfs 전");

//		System.out.println(" s : " + sr + " , " + sc);
//		System.out.println(" e : " + er + " , " + ec);
        bfs(lake, sr, sc, er, ec, r, c);
//		System.out.println("bfs 후");
//
//		System.out.println("새 움직이기");

        printf(lake);

        birdMove(lake, sr, sc, er, ec, r, c);

        System.out.println(ans);
    }

    static void birdMove(int[][] lake, int sr, int sc, int er, int ec, int mr, int mc) {
//        Queue<int[]> queue = new LinkedList<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[2] - o2[2];
            }
        });

        boolean[][] visited = new boolean[mr][mc];

        queue.add(new int[]{sr, sc, 0});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];
            int day = pos[2];
//			if (day < ans) {

//			System.out.println("시작 포인트 ! ["+r+", " + c + "]");

            if (r == er && c == ec) {
                //System.out.println("접근? > " + day);
                ans = Math.min(ans, day);
            }

            if (!visited[r][c]) {
//				System.out.println("움직이기 통과 : [" + r + ", " + c + "] => " + day);
                visited[r][c] = true;
                for (int i = 0; i < 4; i++) {
                    int nr = r + moveRow[i];
                    int nc = c + moveCol[i];

                    if (nr >= 0 && nr < mr && nc >= 0 && nc < mc) {
                        queue.add(new int[]{nr, nc, Math.max(day, lake[nr][nc])});
                    }
                }
            } else {
                lake[r][c] = Math.min(day, lake[r][c]);
            }
//		}
        }
    }

    static void printf(int[][] lake) {
        for (int i = 0; i < lake.length; i++) {
            System.out.println();
            for (int j = 0; j < lake[i].length; j++) {
                System.out.print(lake[i][j] + " ");
            }
            System.out.println();
        }
    }

    static void bfs(int[][] lake, int r1, int c1, int r2, int c2, int mr, int mc) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mr][mc];

        /* 탐색할 점들을 미리 큐에 넣어 놓는다. */
        for (int[] pos : posList) {
            int row = pos[0];
            int col = pos[1];

            lake[row][col] = 1;
            queue.add(new int[]{row, col, 1});
        }

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int row = pos[0];
            int col = pos[1];
            int day = pos[2];

//			if (checkAns(lake, r1, c1, r2, c2, mr, mc)) {
//				System.out.println("들어옴?");
//				System.out.println("통과 좌표 : [" + row + ", " + col + "]");
//				System.out.println("day : " + day);
//				ans = day;
//				return;
//			}

            if (!visited[row][col]) {
                visited[row][col] = true;

                for (int i = 0; i < 4; i++) {
                    int nr = row + moveRow[i];
                    int nc = col + moveCol[i];

                    if (nr >= 0 && nr < mr && nc >= 0 && nc < mc) {
                        if (lake[nr][nc] == -1) {
                            lake[nr][nc] = day + 1;
                            queue.add(new int[]{nr, nc, day + 1});
                        }
                    }
                }
            }
        }

    }

    static boolean checkAns(int[][] lake, int r1, int c1, int r2, int c2, int mr, int mc) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[mr][mc];

//		System.out.println("백조 연결 검사 ");

        queue.add(new int[]{r1, c1});

        while (!queue.isEmpty()) {
            int[] pos = queue.poll();
            int r = pos[0];
            int c = pos[1];

//			System.out.println("검사 좌표 : ["+r+", " + c + "]");

            if (r == r2 && c == c2)
                return true;

            if (!visited[r][c]) {
                visited[r][c] = true;
                for (int i = 0; i < 4; i++) {
                    int nr = r + moveRow[i];
                    int nc = c + moveCol[i];

                    if (nr >= 0 && nr < mr && nc >= 0 && nc < mc) {
                        if (lake[nr][nc] >= 0 || lake[nr][nc] == -2)
                            queue.add(new int[]{nr, nc});
                    }
                }
            }
        }

        return false;
    }

    static boolean areaCheck(int[][] lake, int r, int c, int mr, int mc) {
//		System.out.println("검사 좌표 : [" + r + ", " + c + "]");

        for (int i = 0; i < 4; i++) {
            int nr = r + moveRow[i];
            int nc = c + moveCol[i];

            if (nr >= 0 && nr < mr && nc >= 0 && nc < mc) {
                if (lake[nr][nc] == 0 || lake[nr][nc] == -2)
                    return true;
            }
        }

        return false;
    }

    static void findFirstPoint(int[][] lake, boolean[][] visited, int sr, int sc, int maxRow, int maxCol) {
        if (lake[sr][sc] != -1)
            return;

        if (!visited[sr][sc] && areaCheck(lake, sr, sc, maxRow, maxCol)) {
            posList.add(new int[]{sr, sc, 1});
            visited[sr][sc] = true;
        }

    }
}