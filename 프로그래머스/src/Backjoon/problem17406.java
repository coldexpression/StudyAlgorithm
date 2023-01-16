package Backjoon;

import java.util.Arrays;
import java.util.Scanner;


public class problem17406 {

    static int ans;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ans = Integer.MAX_VALUE;

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] map = new int[N][M];
        boolean[][] visited = new boolean[N][M];

        int K = sc.nextInt();
        int[][] rcs = new int[K][4];
        boolean[] checkVisited = new boolean[K];
        int[] order = new int[K];

        Arrays.fill(order, -1);

        for(int i=0;i<N;i++)
            for(int j=0;j<M;j++)
                map[i][j] = sc.nextInt();

        for(int i=0;i<K;i++) {
            int r = sc.nextInt();
            int c = sc.nextInt();
            int s = sc.nextInt();

            rcs[i][0] = r-s-1;
            rcs[i][1] = c-s-1;
            rcs[i][2] = r+s-1;
            rcs[i][3] = c+s-1;
        }


        dfs(0, new int[K], rcs, visited, checkVisited, map, K);
        System.out.println(ans);
    }

    static int[][] copyArr(int[][] map) {
        int[][] copy = new int[map.length][map[0].length];

        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[i].length;j++)
                copy[i][j] = map[i][j];

        return copy;
    }

    static boolean[][] copyBoolArr(boolean[][] map) {
        boolean[][] copy = new boolean[map.length][map[0].length];

        for(int i=0;i<map.length;i++)
            for(int j=0;j<map[i].length;j++)
                copy[i][j] = map[i][j];

        return copy;
    }


    static void dfs(int count, int[] order, int[][] rcs, boolean[][] visited, boolean[] checkVisited,int[][] map, int K) {
        if (count == order.length) {
            /* 회전 순서 출력 */
            /* 회전 시작 */
            int[][] tMap = copyArr(map);
            for(int idx = 0;idx<order.length;idx++) {
                boolean[][] tVisited = copyBoolArr(visited);
                int[] rrcs = rcs[order[idx]];
                rotate(tVisited, tMap, rrcs[0], rrcs[1], rrcs[2], rrcs[3]);
            }


            int sum = Integer.MAX_VALUE;
            for(int i=0;i<tMap.length;i++) {
                sum = Math.min(sum, Arrays.stream(tMap[i]).sum());
            }


            ans = Math.min(sum, ans);

            return;
        }

        for(int i=0;i<K;i++) {
            if(!checkVisited[i]) {
                checkVisited[i] = true;
                order[count] = i;
                dfs(count + 1, order, rcs, visited, checkVisited, map, K);
                order[count] = -1;
                checkVisited[i] = false;
            }
        }
    }

    static void rotate(boolean[][] visited, int[][] map, int sRow, int sCol, int eRow, int eCol) {

        while (true) {
            int startRow = sRow;
            int startCol = sCol;
            int endRow = eRow;
            int endCol = eCol;

            if (visited[startRow][startCol] || visited[endRow][endCol]) break;

            int first = map[sRow][eCol];
            Boolean check = false;



            // 1번 코스 [L -> R]
            for (; eCol > sCol; eCol--) {
                map[sRow][eCol] = map[sRow][eCol - 1];
                visited[sRow][sCol] = true;
                if (!visited[sRow][sCol]) return ;
            }



            int second = map[eRow][endCol];


            // 2번 코스 [U -> D]
            for (; eRow > sRow; eRow--) {
                map[eRow][endCol] = (eRow - 1) == sRow ? first : map[eRow - 1][endCol];
                visited[eRow][endCol] = true;
                if (!visited[eRow][endCol]) return ;
            }

            int third = map[endRow][sCol];


            // 3번 코스 [R -> L]
            for (; sCol < endCol; sCol++) {
                map[endRow][sCol] =  sCol == (endCol - 1) ? second : map[endRow][sCol + 1];
                visited[endRow][sCol] = true;
                if (!visited[endRow][sCol]) return ;
            }

            map[startRow][startCol] = map[sRow][startCol];
            // 4번 코스 [D -> U]
            for (; sRow < endRow; sRow++) {
                map[sRow][startCol] = sRow == (endRow - 1) ? third : map[sRow + 1][startCol];
                visited[sRow][startCol] = true;
                if (!visited[sRow][startCol]) return ;
            }




            int tsRow = sRow;
            int tsCol = sCol;

            sRow = startRow+1;
            sCol = startCol+1;
            eRow = endRow-1;
            eCol = endCol-1;

        }
    }
}
