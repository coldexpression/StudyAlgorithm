package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class problem17144 {

    static int[][] map;
    static int cleanerUr;
    static int cleanerUc;
    static int cleanerDr;
    static int cleanerDc;
    static int r;
    static int c;

    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,-1,1};

    static int[] rotateRow = {-1,0,1,0};
    static int[] rotateCol = {0,1,0,-1};
    static List<int[]> dirtyList;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        int t = Integer.parseInt(st.nextToken());

        cleanerUr = cleanerUc = cleanerDr = cleanerDc = -1;

        map = new int[r][c];
        dirtyList = new ArrayList<>();

        for(int i=0;i<r;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<c;j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) {
                    if (cleanerUr == -1 && cleanerUc == -1) {
                        cleanerUr = i;
                        cleanerUc = j;
                    } else {
                        cleanerDr = i;
                        cleanerDc = j;
                    }
                } else if (map[i][j] != 0) dirtyList.add(new int[]{i,j});
            }
        }

        for(int i=0;i<t;i++) {
            spreadDirty();
            print();
            operateCleaner();
            print();
            savePos();
        }

        int ans = 0;
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if (map[i][j] != -1) ans += map[i][j];
            }
        }

        System.out.println(ans);

    }

    public static boolean isCheck(int row, int col) {
        return row >= 0 && row < r && col >= 0 && col < c ;
    }

    public static void print() {
        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void savePos() {
        dirtyList.clear();

        for(int i=0;i<r;i++) {
            for(int j=0;j<c;j++) {
                if (map[i][j] > 0) dirtyList.add(new int[]{i,j});
            }
        }
    }

    public static void operateCleaner() {
        System.out.println("환기 시작");
        // 공기 청정기 윗 방향 [반시계 방향]
        int cr = cleanerUr - 1; int cc =  cleanerUc;
        int dir = 0;
        int nr = 0; int nc = 0;

        while(dir < 4) {
            if (cr == cleanerUr && cc == cleanerUc) break;
            nr = cr + rotateRow[dir];
            nc = cc + rotateCol[dir];

            if (isCheck(nr, nc) && nr <= cleanerUr) {
                map[cr][cc] = map[nr][nc];
                cr = nr;
                cc = nc;
            } else dir++;
        }

        map[cleanerUr][cleanerUc + 1] = 0;

        // 공기 청정기 아랫 방향 [시계 방향]
        cr = cleanerDr + 1; cc = cleanerDc;
        dir = 0;
        nr = 0; nc = 0;

        while(dir < 4) {
            if (cr == cleanerDr && cc == cleanerDc) break;
            nr = cr + rotateRow[dir] * -1;
            nc = cc + rotateCol[dir];

            if (isCheck(nr, nc) && nr >= cleanerDr) {
                map[cr][cc] = map[nr][nc];
                cr = nr;
                cc = nc;
            } else dir++;
        }

        map[cleanerDr][cleanerDc + 1] = 0;
    }

    public static void spreadDirty() {
        System.out.println("확산 시작");
        List<int[]> spredDirtyList = new ArrayList<>();
        List<int[]> updateDirtyList = new ArrayList<>();
        List<int[]> newDirtyList = new ArrayList<>();
        for (int[] pos : dirtyList) {
            int dr = pos[0]; int dc = pos[1];
            int cnt = 0;

            System.out.println("중심 좌표 ["+dr+", " +dc + "]");
            for(int i=0;i<4;i++) {
                int nr = dr + moveRow[i];
                int nc = dc + moveCol[i];

                if (isCheck(nr,nc) && map[nr][nc] != -1) {
                    cnt++;
                    if (map[dr][dc] >= 5) {
                        System.out.println("다음 좌표 ["+nr +", " + nc + "] => " + map[dr][dc] /5);
                        spredDirtyList.add(new int[]{nr, nc, map[dr][dc] / 5});
                    }
                }
            }

            if (map[dr][dc] - (map[dr][dc]/5) * cnt > 0) updateDirtyList.add(new int[]{dr, dc, map[dr][dc] - ((map[dr][dc]/5) * cnt)});
        }



        for (int[] info : updateDirtyList) {
            int dr = info[0]; int dc = info[1]; int val = info[2];
            map[dr][dc] = val;
        }

        for (int[] info : spredDirtyList) {
            int dr = info[0]; int dc = info[1]; int val = info[2];
            map[dr][dc] += val;
        }

    }
}
