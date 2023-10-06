package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem2638 {
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][m];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<m;j++) map[i][j] = Integer.parseInt(st.nextToken());
        }

        // 공기인 부분은 -1 처리
        init(map, n, m);

        // 전파 시작
        System.out.println(start(map, n,m));
    }

    public static List<int[]> findCheese(int[][] map, int n, int m) {
        List<int[]> list = new ArrayList<>();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                if (map[i][j] != 1) continue;
                int count = 0;
                for(int k=0;k<4;k++) {
                    if (isCheck(i+move[k][0], j+move[k][1], n, m) && map[i+move[k][0]][j+move[k][1]] == -1) {
                        count++;
                    }
                }
                if (count >= 2) list.add(new int[]{i, j});
            }
        }
        System.out.println("발견 치즈들");
        for (int[] ints : list) {
            System.out.println(Arrays.toString(ints));
        }
        return list;
    }

    public static void eraseCheese(int[][] map, List<int[]> list) {
        for (int[] info : list) {
            int r = info[0]; int c = info[1];
            map[r][c] = -1;
        }
    }

    public static void fillArea(int[][] map, List<int[]> list, int n, int m) {
        Queue<int[]> queue = new LinkedList<>(list);
        boolean[][] vis = new boolean[n][m];
        for (int[] info : list) vis[info[0]][info[1]] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0];
            int c = info[1];
            for (int i = 0; i < 4; i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if (isCheck(nr, nc, n, m) && !vis[nr][nc] && map[nr][nc] == 0) {
                    map[nr][nc] = -1;
                    vis[nr][nc] = true;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static int start(int[][] map, int n, int m) {
        List<int[]> cheese = new ArrayList<>();
        int count = 0;
        while (true){
            System.out.println("현재 시간 : " + count);
            // 치즈 찾기
            cheese = findCheese(map, n, m);
            if (cheese.isEmpty()) break;
            // 치즈 삭제하기
            eraseCheese(map, cheese);
            // 공기 채우기
            fillArea(map, cheese, n, m);
            count++;
        }
        return count;
    }

    public static void init(int[][] map, int n, int m) {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        queue.add(new int[]{0,0});
        queue.add(new int[]{n-1, 0});
        queue.add(new int[]{n-1, m-1});
        queue.add(new int[]{0, m-1});
        visited[0][0] = visited[n-1][0] = visited[n-1][m-1] = visited[0][m-1] = true;
        while(!queue.isEmpty()) {
            int[] info = queue.poll();
            int r = info[0]; int c = info[1];
            for(int i=0;i<4;i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if (isCheck(nr, nc, n, m) && map[nr][nc] == 0 && !visited[nr][nc]) {
                    visited[nr][nc] = true;
                    map[nr][nc] = -1;
                    queue.add(new int[]{nr, nc});
                }
            }
        }
    }

    public static boolean isCheck(int r, int c, int n, int m) {
        return r>= 0 && r < n && c >= 0 && c < m;
    }
}
