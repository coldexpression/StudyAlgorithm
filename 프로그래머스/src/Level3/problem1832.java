package Level3;

import java.util.*;

public class problem1832 {

    static boolean[][] visited;
    static int count;
    int MOD = 20170805;

    public static void main(String[] args) {
        problem1832 problem1832 = new problem1832();
//        problem1832.solution(3, 3, new int[][]{{0,0,0},{0,0,0},{0,0,0}});
        problem1832.solution(3, 6, new int[][]{{0,2,0,0,0,2},{0,0,2,0,1,0},{1,0,0,2,2,0}});
    }

    public int solution(int m, int n, int[][] cityMap) {
        int answer = 0;
        visited = new boolean[m][n];
        count = 0;
        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (cityMap[i][j] == 1) visited[i][j] = true;
                else visited[i][j] = false;
            }
        }
        visited[0][0] = true;
        // 오른쪽 방향으로 출발
        dfs(0, 1, m-1, n-1, cityMap, 'R');

        // 아래 쪽 방향으로 출발
        dfs(1, 0, m-1, n-1, cityMap, 'D');

        answer = count;
        System.out.println(answer);
        return answer;
    }

    private void dfs(int startRow, int startCol, int endRow, int endCol, int[][] cityMap, char direct) {
        if (startRow == endRow && startCol == endCol) {
//            System.out.println("종료 좌표 : [" + startRow + ", " + startCol + "]");
            count = (count+1) % MOD;
            return;
        }

        if (startRow >= 0 && startRow <= endRow && startCol >= 0 && startCol <= endCol) {
            if (!visited[startRow][startCol]) {
//                System.out.println("방문 좌표 : [" + startRow + ", " + startCol + "]");
                visited[startRow][startCol] = true;
                if (cityMap[startRow][startCol] == 2) {
                    if (direct == 'R') dfs(startRow, startCol + 1, endRow, endCol, cityMap, 'R');
                    else if (direct == 'D') dfs(startRow + 1, startCol, endRow, endCol, cityMap, 'D');
                } else {
                    dfs(startRow + 1, startCol, endRow, endCol, cityMap, direct);
                    dfs(startRow, startCol + 1,endRow, endCol, cityMap, direct);
                }
                visited[startRow][startCol] = false;
            }
        }
    }
}
