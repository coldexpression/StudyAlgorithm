package Level3;

import java.util.*;

public class problem60063 {

    static boolean[][][] visited;
    static Queue<Robot> queue;

    public static void main(String[] args) {
        problem60063 problem60063 = new problem60063();
        problem60063.solution(new int[][]{{0,0,0,1,1},{0,0,0,1,0},{0,1,0,1,1},{1,1,0,0,1},{0,0,0,0,0}});
//        problem60063.solution(new int[][]{{0,0,1,1,0,0},{0,0,0,0,0,0},{0,1,0,0,0,0},{0,1,0,1,1,0},{0,0,0,1,1,0},{0,0,0,1,1,0}});
//        problem60063.solution(new int[][]{{0, 0, 0, 0, 1, 0},{0, 0, 1, 1, 1, 0},{0, 1, 1, 1, 1, 0},{0, 1, 0, 0, 1, 0},{0, 0, 1, 0, 0, 0},{0, 0, 0, 0, 0, 0}});
//        problem60063.solution(new int[][]{{0, 0, 0, 0, 0, 0, 1},{1, 1, 1, 1, 0, 0, 1},{0, 0, 0, 0, 0, 0, 0},{0, 0, 1, 1, 1, 1, 0},{0, 1, 1, 1, 1, 1, 0},{0, 0, 0, 0, 0, 1, 1},{0, 0, 1, 0, 0, 0, 0}});
//        problem60063.solution(new int[][]{{0,0,0,0,1},{1,0,0,0,1},{0,1,0,0,0},{0,0,1,0,0},{0,0,0,1,0}});
    }

    public class Robot {
        private int r1;
        private int c1;
        private int r2;
        private int c2;

        private int val;

        public Robot(int r1, int c1, int r2, int c2, int val) {
            this.r1 = r1;
            this.c1 = c1;
            this.r2 = r2;
            this.c2 = c2;
            this.val = val;
        }
    }

    public int solution(int[][] board) {
        int[] moveRow = new int[]{-1,0,1,0};
        int[] moveCol = new int[]{0,-1,0,1};
        int[] moveVal = new int[]{-1,1};

        int answer = 0;
        int N = board.length;
        int[][] map = new int[N+2][N+2];
        queue = new LinkedList<>();
        visited = new boolean[N+2][N+2][3];

        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                map[i+1][j+1] = board[i][j];
            }
        }

        for(int i=0;i<N+2;i++) {
            map[0][i] = -1;
            map[N+1][i] = -1;
            map[i][0] = -1;
            map[i][N+1] = -1;
        }

        for(int i=0;i<N+2;i++) {
            System.out.println();
            for(int j=0;j<N+2;j++) {
                System.out.print("["+map[i][j]+"] ");
            }
        }

        System.out.println();
        queue.add(new Robot(1, 1, 1, 2, 0));

        while(!queue.isEmpty()) {

                Robot robot = queue.poll();
                System.out.println("POS 1 : [" + robot.r1 + ", " + robot.c1 + "] POS 2 : [" + robot.r2 + ", " + robot.c2 + "]");

                if ((robot.r1 == N && robot.c1 == N) || (robot.r2 == N && robot.c2 == N)) {
                    answer = robot.val;
                    break;
                }

                /* 상, 하, 좌, 우 이동*/
                for (int i = 0; i < 4; i++) {
                    int nextRow1 = robot.r1 + moveRow[i];
                    int nextCol1 = robot.c1 + moveCol[i];
                    int nextRow2 = robot.r2 + moveRow[i];
                    int nextCol2 = robot.c2 + moveCol[i];

                    if (map[nextRow1][nextCol1] == 0 && map[nextRow2][nextCol2] == 0) {
                        int t = nextRow1 - nextRow2 == 0 ? 2 : 1;
                        insert(nextRow1, nextCol1, nextRow2, nextCol2, robot.val, t);
                    }
                }

                if (robot.r1 == robot.r2) {
                    /* 가로 상태에서 회전*/
                    for (int i = 0; i < 2; i++) {
                        int nextRow1 = robot.r1 + moveVal[i];
                        int nextRow2 = robot.r2 + moveVal[i];

                        if (map[nextRow1][robot.c1] == 0 && map[nextRow2][robot.c2] == 0) {
                            insert(robot.r1, robot.c1, nextRow1, robot.c1, robot.val, 1);
                            insert(robot.r1, robot.c2, nextRow2, robot.c2, robot.val, 1);
                        }
                    }
                }

                if (robot.c1 == robot.c2) {
                    /* 세로 상태에서 회전*/
                    for (int i = 0; i < 2; i++) {
                        int nextCol1 = robot.c1 + moveVal[i];
                        int nextCol2 = robot.c2 + moveVal[i];

                        if (map[robot.r1][nextCol1] == 0 && map[robot.r2][nextCol2] == 0) {
                            insert(robot.r1, robot.c1, robot.r1, nextCol2, robot.val, 2);
                            insert(robot.r2, robot.c2, robot.r2, nextCol1, robot.val, 2);
                        }
                    }
                }
        }

        System.out.println(answer);

        return answer;
    }

    public void insert(int r1, int c1, int r2, int c2, int dst, int type) {

        if (!(visited[r1][c1][type] && visited[r2][c2][type]) || !(visited[r2][c1][type] && visited[r1][c2][type])) {
            queue.add(new Robot(r1, c1, r2, c2, dst + 1));
            visited[r1][c1][type] = true;
            visited[r2][c2][type] = true;
            visited[r2][c1][type] = true;
            visited[r1][c2][type] = true;
        }
    }
}
