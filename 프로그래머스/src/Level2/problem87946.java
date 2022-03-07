package Level2;

import java.util.*;

public class problem87946 {

    static boolean[] visited;
    static String board;
    static int answer;

    public static void main(String[] args) {
        problem87946 problem87946 = new problem87946();
        problem87946.solution(80, new int[][]{{80,20},{50,40},{30,10}});
    }

    public int solution(int k, int[][] dungeons) {
        answer = -1;
        visited = new boolean[dungeons.length];
        for(int i=0;i<dungeons.length;i++) visited[i] = false;

        int end = visited.length;
        board = "";
        dfs(0, end, k, dungeons);

        return answer;
    }

    private void dfs(int start, int end, int k, int[][] dungeons) {
        if (start == end) {

            int currentGage = k;
            int pass = 0;
            for(String stage: board.split("")) {
                int minNecessaryGage = dungeons[Integer.parseInt(stage)][0];
                int useGage = dungeons[Integer.parseInt(stage)][1];
                if (currentGage < minNecessaryGage) {
                    answer = Math.max(answer, pass);
                    return ;
                }
                pass++;
                currentGage -= useGage;
            }
            answer = Math.max(answer, pass);
        }

        for(int i=0;i<end;i++) {
            if (!visited[i] && !board.contains(String.valueOf(i))) {
                String temp = board;
                visited[i] = true;
                board = board.concat(String.valueOf(i));
                dfs(start+1, end, k, dungeons);
                board = temp;
                visited[i] = false;
            }
        }

    }
}
