package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16985 {
    static final int INF = Integer.MAX_VALUE;
    static int[][] move = {{-1,0,0},{1,0,0},{0,1,0},{0,-1,0},{0,0,-1},{0,0,1}};
    static int answer;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, List<int[][]>> rotateMap = new HashMap<>();
        StringTokenizer st = null;
        int[][][] panels = new int[5][5][5];
        for(int i=0;i<5;i++) {
            for(int j=0;j<5;j++) {
                st = new StringTokenizer(bf.readLine());
                for(int k=0;k<5;k++) panels[i][j][k] = Integer.parseInt(st.nextToken());
            }
        }

        for(int i=0;i<5;i++) {
            int[][] rMap = panels[i];
            rotateMap.put(i, new ArrayList<>());
            for(int j=0;j<4;j++) {
                rMap = rotate(rMap);
                rotateMap.get(i).add(rMap);
            }
        }

        for (Integer key : rotateMap.keySet()) {
            System.out.println("["+key+"] 번째 판넬");
            for (int[][] ints : rotateMap.get(key)) {
                for(int i=0;i<5;i++) System.out.println(Arrays.toString(ints[i]));
                System.out.println("==============");
            }

        }

        answer = Integer.MAX_VALUE;

        perm(rotateMap, new boolean[5], new boolean[5][4], new int[5][5][5], 0);

        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        System.out.println(answer);
    }

    public static boolean isCheck(int r, int c, int h) {
        return r>= 0 && r < 5 && c >= 0 && c < 5 && h >= 0 && h < 5;
    }

    public static int bfs(int[][][] map) {
        if (map[0][0][0] == 0 || map[4][4][4] == 0) return INF;

        boolean[][][] vis = new boolean[5][5][5];
        vis[0][0][0] = true;

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0, 0, 0, 0});

        while(!q.isEmpty()) {
            int[] info = q.poll();
            int r = info[0]; int c = info[1]; int h = info[2]; int cnt = info[3];
            if (r == 4 && c == 4 && h == 4) return cnt;

            for(int i=0;i<6;i++) {
                int nr = r + move[i][0];
                int nc = c + move[i][1];
                int nh = h + move[i][2];

                if (isCheck(nr, nc, nh) && map[nr][nc][nh] == 1 && !vis[nr][nc][nh]) {
                    vis[nr][nc][nh] = true;
                    q.add(new int[]{nr, nc, nh, cnt + 1});
                }
            }
        }
        return INF;
    }

    public static int[][] rotate(int[][] map) {
        int[][] rMap = new int[5][5];
        int rIndex = 0;
        for(int col=0;col<5;col++) {
            int[] panel = new int[5];
            int index = 0;
            for(int row=4;row>=0;row--) {
                panel[index++] = map[row][col];
            }
            rMap[rIndex++] = panel;
        }
        return rMap;
    }

    public static void perm(HashMap<Integer, List<int[][]>> rotateMap, boolean[] panelVis, boolean[][] rotateVis, int[][][] map, int count) {
        if (count == 5) {
            answer = Math.min(answer, bfs(map));
            return;
        }

        for(int panelIndex=0;panelIndex<5;panelIndex++) {
            if (!panelVis[panelIndex]) {
                panelVis[panelIndex] = true;
                for(int rotateIndex=0;rotateIndex<4;rotateIndex++) {
                    if (!rotateVis[panelIndex][rotateIndex]) {
                        rotateVis[panelIndex][rotateIndex] = true;
                        map[count] = rotateMap.get(panelIndex).get(rotateIndex);
//                        System.out.println("현재 카운트 : " + count);
                        System.out.println("panelVis : " + Arrays.toString(panelVis));
                        System.out.println("rotateVis : " + Arrays.toString(rotateVis));
                        perm(rotateMap, panelVis, rotateVis, map, count + 1);
                        rotateVis[panelIndex][rotateIndex] = false;
                    }
                }
                panelVis[panelIndex] = false;
            }
        }
    }
}
