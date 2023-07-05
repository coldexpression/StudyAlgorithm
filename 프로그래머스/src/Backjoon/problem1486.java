package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem1486 {
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int ans = 0;
        int[][] map = new int[n][m];
        long[][] dist = new long[n][m];
        int[][] height = new int[n][m];
        long[][] dist_back = new long[n][m];
        int[][] height_back = new int[n][m];
        PriorityQueue<int[]> heightPq = new PriorityQueue<>((o1, o2) -> o2[2]-o1[2]);
        for(int i=0;i<n;i++) {
            String input = bf.readLine();
            for(int j=0;j<m;j++) {
                char alph = input.charAt(j);
                if (alph >= 'a' && alph <= 'z') map[i][j] = alph - 71;
                else map[i][j] = alph - 65;
                if (i == 0 && j == 0) continue;
                heightPq.add(new int[]{i, j, map[i][j]});
            }
        }
        ans = map[0][0];
        // 출발점에서 각 산지점 까지 다익스트라 실행
        dijk(0, 0, t, d, map, dist);

        // 각 산지점에서 출발점까지 다익스트라 실행
        while(!heightPq.isEmpty()) {
            int[] info = heightPq.poll();
            int r = info[0]; int c = info[1]; int hei = info[2];
            dijk(r, c, t, d, map, dist_back);
            System.out.println(Arrays.toString(info));

            for(int i=0;i<dist_back.length;i++) System.out.println(Arrays.toString(dist_back[i]));

            if (dist[r][c] + dist_back[0][0] <= d) {
                ans = Math.max(map[0][0], hei);
                break;
            }
        }
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                if (i == 0 && j == 0) continue;
//                dijk(i, j, t, d, map, dist_back);
//
//                if (dist[i][j] + dist_back[0][0] <= d) ans = Math.max(ans, Math.max(height[i][j], height_back[0][0]));
//            }
//        }

        System.out.println(ans);
    }

    public static void dijk(int sr, int sc, int t, int d, int[][] map, long[][] score) {
        int n = map.length;
        int m = map[0].length;
        for(int i=0;i<score.length;i++) {
            Arrays.fill(score[i], Integer.MAX_VALUE);
//            Arrays.fill(height[i], 0);
        }
        score[sr][sc] = 0;
//        height[sr][sc] = map[sr][sc];

        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2]-o2[2]);
        pq.add(new int[]{sr, sc, 0});

        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int r = info[0]; int c = info[1]; int val = info[2];

            if (val >= d) continue;
            if (score[r][c] < val) continue;

            for(int i=0;i<4;i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                int nextVal = val;
                if (isCheck(nr, nc, n, m)) {
                    int diff = map[r][c] - map[nr][nc] < 0 ? (map[r][c] - map[nr][nc])*(-1) : map[r][c] - map[nr][nc];
                    if (diff > t)  continue;

                    if (map[r][c] >= map[nr][nc]) {
                        nextVal++;
                        if (nextVal < score[nr][nc]) {
                            score[nr][nc] = nextVal;
                            pq.add(new int[]{nr, nc, (int)score[nr][nc]});
                        }
                    } else {
                        nextVal += diff * diff;
                        if (nextVal < score[nr][nc]) {
                            score[nr][nc] = nextVal;
                            pq.add(new int[]{nr, nc, (int)score[nr][nc]});
                        }
                    }
                }
            }
        }
    }

    public static boolean isCheck(int r, int c, int mr, int mc) {
        return r >= 0 && r < mr && c >= 0 && c < mc;
    }
}
