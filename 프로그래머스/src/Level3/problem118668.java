package Level3;

import java.util.Arrays;
import java.util.Comparator;

public class problem118668 {

    public static void main(String[] args) {
        problem118668 problem118668 = new problem118668();
        problem118668.solution(10, 10, new int[][]{{10,15,2,1,2},{20,20,3,3,4}});
//        problem118668.solution(0, 0, new int[][]{{0,0,2,1,2},{4,5,3,1,2},{4,11,4,0,2},{10,4,0,4,2}});
    }

    public int solution(int alp, int cop, int[][] problems) {
        int answer = 0;

        int max_a = 0;
        int max_c = 0;

        for(int i=0;i<problems.length;i++) {
            max_a = Math.max(max_a, problems[i][0]);
            max_c = Math.max(max_c, problems[i][1]);
        }

        if (max_a <= alp && max_c <= cop) return 0;

        alp = Math.min(max_a, alp);
        cop = Math.min(max_c, cop);

        int[][] dp = new int[max_a+2][max_c+2];

        for(int i=alp;i<=max_a;i++)
            for(int j=cop;j<=max_c;j++)
                dp[i][j] = Integer.MAX_VALUE;

        dp[alp][cop] = 0;

        for(int i=alp;i<=max_a;i++) {
            for (int j = cop; j <= max_c; j++) {
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j] + 1);
                dp[i][j + 1] = Math.min(dp[i][j + 1], dp[i][j] + 1);

                for (int[] problem : problems) {
                    int new_alp = problem[0];
                    int new_cop = problem[1];
                    int new_alp_rwd = problem[2];
                    int new_cop_rwd = problem[3];
                    int dst = problem[4];
                    if (i >= new_alp && j >= new_cop) {
                        if (i + new_alp_rwd > max_a && j + new_cop_rwd > max_c) {
                            dp[max_a][max_c] = Math.min(dp[max_a][max_c], dp[i][j] + dst);
                        } else if (i + new_alp_rwd > max_a) {
                            dp[max_a][j+new_cop_rwd] = Math.min(dp[max_a][j+new_cop_rwd], dp[i][j] + dst);
                        } else if (j + new_cop_rwd > max_c) {
                            dp[i+new_alp_rwd][max_c] = Math.min(dp[i+new_alp_rwd][max_c], dp[i][j] + dst);
                        } else if (i + new_alp_rwd <= max_a && j + new_cop_rwd <= max_c) {
                            dp[i + new_alp_rwd][j + new_cop_rwd] = Math.min(dp[i + new_alp_rwd][j + new_cop_rwd], dp[i][j] + dst);
                        }
                    }
                }
            }
        }
        answer = dp[max_a][max_c];
        System.out.println(answer);
        return answer;
    }
}
