package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16954 {
    static char[][] map;
    static List<int[]> wallsList;
    static int[][] move = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{-1,1},{1,-1},{1,1},{0,0}};
    static HashMap<Integer, List<int[]>> wallsMap;
    static boolean[][][] visited;
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String input;
        map = new char[8][8];
        wallsList = new ArrayList<>();
        wallsMap = new HashMap<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
        int sr = 7;
        int sc = 0;
        boolean check = false;
        visited = new boolean[11][8][8];

        for(int i=0;i<8;i++) {
            input = bf.readLine();
            for(int j=0;j<8;j++) {
                map[i][j] = input.charAt(j);
                if (map[i][j] == '#') wallsList.add(new int[]{i,j});
            }
        }

        saveWallsMap();
        initVisited();

        pq.add(new int[]{sr, sc, 0});
        if (wallsList.isEmpty()) System.out.println(1);
        else {
            while(!pq.isEmpty()) {
                int[] info = pq.poll();
                int cr = info[0]; int cc = info[1]; int time = info[2];
                if (!wallsMap.containsKey(time)) {
                    check = true;
                    break;
                }
                for(int i=0;i<9;i++) {
                    int nr = cr + move[i][0];
                    int nc = cc + move[i][1];
                    if (isCheck(nr, nc) && !isFaceToWall(nr, nc, time) && !visited[time + 1][nr][nc]) {
                        pq.add(new int[]{nr, nc, time + 1});
                        visited[time + 1][nr][nc] = true;
                    }
                }

            }
            System.out.println(check ? 1 : 0);
        }
    }

    public static boolean isFaceToWall(int r, int c,int time) {
        List<int[]> list = wallsMap.getOrDefault(time, new ArrayList<>());
        for(int[] info : list) {
            if (r == info[0] && c == info[1]) return true;
        }
        return false;
    }

    public static void initVisited() {
        for(int time: wallsMap.keySet()) {
            List<int[]> list = wallsMap.get(time);
            for(int[] info: list) visited[time][info[0]][info[1]] = true;
            wallsMap.put(time, list);
        }
    }
    public static void saveWallsMap() {
        for(int i=0;i<=8;i++) {
            List<int[]> newWallsList = new ArrayList<>();
            for(int[] info: wallsList) {
                int r = info[0]; int c = info[1];
                if (r + i < 8) newWallsList.add(new int[]{r+i,c});
            }
            wallsMap.put(i, newWallsList);
        }
    }
    public static boolean isCheck(int r, int c) {
        return r >= 0 && r < 8 && c >= 0 && c < 8;
    }

}