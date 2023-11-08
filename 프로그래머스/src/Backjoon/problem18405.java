package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class problem18405 {
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[][] map = new int[n][n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[3] == o2[3]) return o1[2] - o2[2];
            return o1[3] - o2[3];
        });
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] != 0) pq.add(new int[]{i, j, map[i][j], 0});
            }
        }

        st = new StringTokenizer(bf.readLine());
        int s = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken()) - 1;
        int y = Integer.parseInt(st.nextToken()) - 1;

        while(!pq.isEmpty()) {
            int[] info = pq.poll();
            int r = info[0]; int c = info[1]; int flag = info[2]; int time = info[3];
            if (time == s) break;

            for(int i=0;i<4;i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                if (isCheck(nr, nc, n) && map[nr][nc] == 0) {
                    map[nr][nc] = flag;
                    pq.add(new int[]{nr, nc, flag, time + 1});
                }
            }
        }
        System.out.println(map[x][y]);
    }

    public static boolean isCheck(int r, int c, int n) {
        return r>=0 && r<n && c>=0 && c<n;
    }
}
