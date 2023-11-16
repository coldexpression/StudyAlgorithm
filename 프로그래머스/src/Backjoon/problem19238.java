package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem19238 {
    static class Area {
        private int index;
        private boolean startPoint;
        private HashSet<Integer> endPoints;
        public Area(int index, boolean startPoint, HashSet<Integer> endPoints) {
            this.index = index;
            this.startPoint = startPoint;
            this.endPoints = endPoints;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public void setStartPoint(boolean startPoint) {
            this.startPoint = startPoint;
        }
        public void startInit() {
            this.index = 0;
            this.startPoint = false;
        }
        public void endInit(int index) {
            this.endPoints.remove(index);
        }
    }

    static class Node {
        private int r;
        private int c;
        private int storeFuel;
        private int useFuel;
        private int flag;
        private boolean isTaxiServiceEnable;
        private boolean existUser;

        public Node(int r,int c, int storeFuel, int useFuel, int flag, boolean isTaxiServiceEnable, boolean existUser) {
            this.r = r;
            this.c = c;
            this.storeFuel = storeFuel;
            this.useFuel = useFuel;
            this.flag = flag;
            this.isTaxiServiceEnable = isTaxiServiceEnable;
            this.existUser = existUser;
        }

    }
    static int[][] move = {{-1,0},{1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        HashSet<Integer> set = new HashSet<>();
        int answer = 0;
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Area[][] map = new Area[n][n];
        boolean[][] vis = new boolean[n][n];
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) map[i][j] = new Area(Integer.parseInt(st.nextToken()), false, new HashSet<>());
        }
        st = new StringTokenizer(bf.readLine());
        int sr = Integer.parseInt(st.nextToken()) - 1;
        int sc = Integer.parseInt(st.nextToken()) - 1;
        int flag = 2;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            set.add(flag);
            map[r][c].setIndex(flag);
            map[r][c].setStartPoint(true);
            r = Integer.parseInt(st.nextToken()) - 1;
            c = Integer.parseInt(st.nextToken()) - 1;
            map[r][c].endPoints.add(flag);
            flag++;
        }

        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.isTaxiServiceEnable == o2.isTaxiServiceEnable) {
                if (o1.useFuel == o2.useFuel) {
                    if (o1.r == o2.r) return o1.c - o2.c;
                    return o1.r - o2.r;
                }
                return o1.useFuel - o2.useFuel;
            }
           return Boolean.compare(o2.isTaxiServiceEnable, o1.isTaxiServiceEnable);
        });
        pq.add(new Node(sr, sc, k, 0, map[sr][sc].index ,map[sr][sc].startPoint, false));
        while(!pq.isEmpty()) {
            Node node = pq.poll();

            if (node.isTaxiServiceEnable && !node.existUser && map[node.r][node.c].startPoint) {
                pq.clear();
                vis = new boolean[n][n];
                if (!map[node.r][node.c].endPoints.contains(node.flag)) pq.add(new Node(node.r, node.c, node.storeFuel, 0, map[node.r][node.c].index, true, true));
                else {
                    pq.add(new Node(node.r, node.c, node.storeFuel, 0, 0, false, false));
                    set.remove(map[node.r][node.c].index);
                    answer = node.storeFuel;
                    map[node.r][node.c].endInit(node.flag);
                }
                map[node.r][node.c].startInit();
                continue;
            }
            

            if (node.storeFuel <= 0) continue;

            for(int i=0;i<4;i++) {
                int nr = node.r + move[i][0];
                int nc = node.c + move[i][1];

                if(isCheck(nr, nc, n)) {
                    if (map[nr][nc].index == 1 || vis[nr][nc]) continue;

                    if (!node.isTaxiServiceEnable) {
                        // 승객을 못태운 경우
                        vis[nr][nc] = true;
                        pq.add(new Node(nr, nc, node.storeFuel - 1, node.useFuel + 1, map[nr][nc].index >= 2 ? map[nr][nc].index : 0, map[nr][nc].index >= 2, false));
                    } else {
                        // 승객을 태운 경우
                        if (map[nr][nc].endPoints.contains(node.flag)) {
                            pq.clear();
                            vis = new boolean[n][n];
                            pq.add(new Node(nr, nc, node.storeFuel - 1 + ((node.useFuel+1)*2), 0, map[nr][nc].index, map[nr][nc].index != 0, false));
                            map[nr][nc].endInit(node.flag);
                            answer = node.storeFuel - 1 + ((node.useFuel+1)*2);
                            set.remove(node.flag);
                            break;
                        } else {
                            pq.add(new Node(nr, nc, node.storeFuel - 1, node.useFuel + 1, node.flag, node.isTaxiServiceEnable, node.existUser));
                            vis[nr][nc] = true;
                        }
                    }
                }
            }
        }
        System.out.println(set.isEmpty() ? answer : -1);
    }

    public static boolean isCheck(int r, int c, int n) {
        return r>= 0 && r < n && c >=0 && c < n;
    }
}
