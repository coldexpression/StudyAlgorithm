package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem17135 {

    static int maxDst;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();
        maxDst = sc.nextInt();
        ans = 0;

        int playerNum = 3;

        int[] playerPos = new int[3];
        Arrays.fill(playerPos, -1);
        boolean[] playerVisited = new boolean[3];

        int[][] map = new int[N+1][M];

        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                map[i][j] = sc.nextInt();

        dfs(map, 0, M, playerPos, playerVisited, 0, 3);

        System.out.println(ans);
    }

    static int[][] copyArr(int[][] map) {
        int N = map.length;
        int M = map[0].length;

        int[][] tmp = new int[N][M];

        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                tmp[i][j] = map[i][j];

        return tmp;
    }


    static int attackMonster(int[][] map, int row, int col) {
        int count = map[row][col] == 0 ? 0 : 1;

        map[row][col] = 0;

        return count;

    };
    static void nextRound(int[][] map, int round) {
        int N = map.length - 1;
        int M = map[0].length;

        for(int i=N-1;i>round;i--) {
            for(int j=0;j<M;j++) {
                map[i][j] = map[i-1][j];
            }
        }

        if (round == 0) for(int i=0;i<M;i++) map[0][i] = 0;


    }

    static void playGame(int[][] map, int round, int[] playerPos, int count) {
        int maxCol = map[0].length;
        int maxRow = map.length - 1;

        if (round == (maxRow) + 1) {
            ans = Math.max(ans, count);
            return ;
        }

        Queue<int[]> monsterQueue = new LinkedList<>();

        for(int idx = 0; idx < 3; idx++) {
            PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {

                @Override
                public int compare(int[] o1, int[] o2) {
                    if(o1[2] == o2[2]) {
                        return o1[1] - o2[1];
                    }

                    return o1[2]-o2[2];
                }
            });

            int pos = playerPos[idx];
            for(int i=maxRow-1;i>= round;i--) {
                for(int j=0;j<maxCol;j++) {
                    int dst = Math.abs(maxRow - i) + Math.abs(pos - j);
                    if (map[i][j] == 1 && dst <= maxDst) {
                        queue.add(new int[] {i, j, dst});
                    }
                }
            }

            if (!queue.isEmpty()) monsterQueue.add(queue.poll());
        }

        while(!monsterQueue.isEmpty()) {
            int[] info = monsterQueue.poll();

            count += attackMonster(map, info[0], info[1]);
        }

        nextRound(map, round);
        playGame(map, round + 1, playerPos, count);


    }

    static void dfs(int[][] map, int sCol, int eCol ,int[] playerPos ,boolean[] playerVisited ,int count, int endCount) {
        if (count == endCount) {
            /* player 의 위치가 정해짐 */
            int[][] newMap = copyArr(map);
            playGame(newMap, 0, playerPos, 0);
            return ;
        }

        for(int i=sCol;i<eCol;i++) {
            if (!playerVisited[count]) {
                playerVisited[count] = true;
                playerPos[count] = i;
                dfs(map, i+1, eCol, playerPos, playerVisited, count + 1, endCount);
                playerPos[count] = -1;
                playerVisited[count] = false;
            }
        }
    }

}