package Backjoon;

import java.util.*;

public class problem14502 {

    static int[] moveRow = {-1,1,0,0};
    static int[] moveCol = {0,0,1,-1};

    static List<int[]> virusPos;

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<int[]> list = new ArrayList<>();

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] board = new int[N][M];
        boolean[] visited = new boolean[3];
        int[] posBoard = new int[3];

        ans = Integer.MAX_VALUE;

        virusPos = new ArrayList<>();
        ans = Integer.MIN_VALUE;

        for(int i=0;i<N;i++) {
            for (int j = 0; j < M; j++) {
                board[i][j] = sc.nextInt();
                if(board[i][j] == 0) list.add(new int[] {i,j});
                if (board[i][j] == 2) virusPos.add(new int[]{i,j});
            }
        }

        int[][] zeroBoard = new int[list.size()][2];

        for(int i=0;i<list.size();i++) {
            int[] pos = list.get(i);
            zeroBoard[i][0] = pos[0];
            zeroBoard[i][1] = pos[1];
        }

        dfs(board, zeroBoard, visited, posBoard, 0, list.size(), 0);

        System.out.println(ans);
    }

    static void fillVirus(int[][] board) {
        Queue<int[]> queue = new LinkedList<>();

        for(int i=0;i<virusPos.size();i++) queue.add(virusPos.get(i));

        while(!queue.isEmpty()) {
            int[] pos = queue.poll();

            for(int i=0;i<4;i++) {
                int nRow = pos[0] + moveRow[i];
                int nCol = pos[1] + moveCol[i];

                if (nRow >= 0 && nRow < board.length && nCol >= 0 && nCol < board[0].length) {
                    if (board[nRow][nCol] == 0) {
                        board[nRow][nCol] = 2;
                        queue.add(new int[] {nRow, nCol});
                    }
                }
            }
        }
    }


    static void dfs(int[][] board ,int[][] zeroBoard , boolean[] visited , int[] posBoard ,int stIdx, int edIdx, int count) {
        if (count == 3) {
            int[][] copy = copyArr(board);

            /* 벽 쌓기 */
            for(int i=0;i<posBoard.length;i++) {
                int idx = posBoard[i];

                copy[zeroBoard[idx][0]][zeroBoard[idx][1]] = 1;
            }


            /* 바이러스 채우기 */
            fillVirus(copy);

            /* 0의 갯수 세기 */
            int sum = 0;
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[i].length;j++) {
                    sum = copy[i][j] == 0 ? sum + 1 : sum;
                }
            }

            ans = Math.max(ans,  sum);

            return;
        }

        for(int i=stIdx;i<edIdx;i++) {
            if (!visited[count]) {
                visited[count] = true;
                posBoard[count] = i;
                dfs(board, zeroBoard, visited, posBoard, i+1, edIdx, count + 1);
                posBoard[count] = -1;
                visited[count] = false;
            }
        }
    }

    static int[][] copyArr(int[][] board) {
        int[][] copy = new int[board.length][board[0].length];

        for(int i=0;i<copy.length;i++)
            for(int j=0;j<copy[i].length;j++)
                copy[i][j] = board[i][j];

        return copy;
    }
}