package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem16235 {

    static int[][] map;
    static int[][] valMap;
    static List<int[]> liveTrees;
    static Stack<int[]> deadTrees;

    static int[] moveRow = {-1,-1,-1,0,0,1,1,1};
    static int[] moveCol = {-1, 0, 1,-1,1,-1,0,1};

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());

        // 봄 -> 자신의 나이만큼 양분을 먹음 -> 나이 +1
        // 하나의 칸에 여러개의 나무가 있다면, 나이가 어린나무부터 양분을 섭취
        // 만약에 자신의 나이만큼 양분을 먹을수 없다면 나무는 사망
        // 여름 -> 봄에 죽은 나무가 양분으로 변경 -> 양분 = (죽은 나무나이 / 2) [소수점 아래는 버림]
        // 가을 -> 나무의 나이가 5의 배수이면 번식 -> 인접한 8개의 칸에 나이가 1인 나무가 생김

        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        map = new int[n][n];
        valMap = new int[n][n];
        liveTrees = new ArrayList<>();
        deadTrees = new Stack<>();

        for(int i=0;i<n;i++) {
            st = new StringTokenizer(bf.readLine());
            for(int j=0;j<n;j++) {
                valMap[i][j] = Integer.parseInt(st.nextToken());
                map[i][j] = 5;
            }
        }

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(bf.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int age = Integer.parseInt(st.nextToken());
            liveTrees.add(new int[] {r-1,c-1, age});
        }

        for(int i=0;i<k;i++) {
            spring();
            summer();
            fall();
            winter();
        }

        System.out.println(liveTrees.size());

    }

    public static boolean isCheck(int r, int c) {
        return r >= 0 && r < n && c >= 0 && c < n;
    }

    public static void winter() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] += valMap[i][j];
            }
        }
    }

    public static void fall() {
        List<int[]> newLivesTrees = new ArrayList<>();
        for (int[] tree : liveTrees) {
            int r = tree[0]; int c = tree[1]; int age = tree[2];

            if (age % 5 == 0) {

                for(int i=0;i<8;i++) {
                    int nr = r + moveRow[i];
                    int nc = c + moveCol[i];

                    if (isCheck(nr, nc)) {
                        newLivesTrees.add(new int[] {nr, nc, 1});
                    }
                }
            }
        }

        liveTrees.addAll(newLivesTrees);
    }

    public static void summer() {

        while(!deadTrees.isEmpty()) {
            int[] tree = deadTrees.pop();
            int r = tree[0]; int c = tree[1]; int age = tree[2];

            map[r][c] += (age/2);
        }

    }

    public static void spring() {
        Collections.sort(liveTrees, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
//                if (o1[2] == o2[2]) {
//                    if (o1[0] == o2[0]) return o1[1] - o2[1];
//                    return o1[0] - o2[0];
//                }

                return o1[2] - o2[2];
            }
        });

        List<int[]> newLivesTrees = new ArrayList<>();

        for (int[] tree : liveTrees) {
            int r = tree[0]; int c = tree[1]; int age = tree[2];

            if (map[r][c] >= age) {
                map[r][c] -= age;
                newLivesTrees.add(new int[] {r, c, age+1});
            } else {
                deadTrees.add(new int[] {r, c, age});
            }
        }

        liveTrees = new ArrayList<>(newLivesTrees);
    }



}