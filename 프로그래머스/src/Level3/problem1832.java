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
        int[][] dpRight = new int[m][n];
        int[][] dpDown = new int[m][n];

        // 첫 Row 경우의 수 구하기
        for (int i = 0; i < n; i++) {
            if (cityMap[0][i] == 1) break;
            dpRight[0][i] = 1;
        }

        // 첫 Col 경우의 수 구하기
        for (int i = 0; i < m; i++) {
            if (cityMap[i][0] == 1) break;
            dpDown[i][0] = 1;
        }

        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (cityMap[i][j] == 1) continue;

                if (cityMap[i-1][j] == 0) {
                    dpDown[i][j] += (dpRight[i-1][j] + dpDown[i-1][j]) % MOD;
                } else if (cityMap[i-1][j] == 2) {
                    dpDown[i][j] += dpDown[i-1][j] % MOD;
                }

                if (cityMap[i][j-1] == 0) {
                    dpRight[i][j] += (dpRight[i][j-1] + dpDown[i][j-1]) % MOD;
                } else if (cityMap[i][j-1] == 2) {
                    dpRight[i][j] += dpRight[i][j-1] % MOD;
                }
            }
        }
        answer = dpRight[m-1][n-1] + dpDown[m-1][n-1];
        System.out.println(answer);
        return answer;
    }
}
