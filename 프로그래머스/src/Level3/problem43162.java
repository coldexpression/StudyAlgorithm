package Level3;

import java.util.*;

public class problem43162 {

    public static void main(String[] args) {
        problem43162 problem43162 = new problem43162();
        problem43162.solution(3, new int[][]{{1,1,0},{1,1,0},{0,0,1}});
    }

    public int solution(int n, int[][] computers) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[n];
        int answer = 0;
        int[][] map = new int[n][n];
        Arrays.fill(visited, false);
        for(int i=0;i<computers.length;i++) {
            for(int j=0;j<computers[i].length;j++) {
                if (i != j) map[i][j] = map[j][i] = computers[i][j];
                else map[i][j] = map[j][i] = 0;
            }
        }

        printfBoard(map);

        for(int i=0;i<n;i++) {
            if (!visited[i]) {
                visited[i] = true;
                for (int j = 0; j < n; j++) {
                    if (map[i][j] != 0) queue.add(j);
                }
                while (!queue.isEmpty()) {
                    int pickNum = queue.poll();
                    visited[pickNum] = true;
                    for (int j = 0; j < n; j++) if (map[pickNum][j] != 0 && !visited[j]) queue.add(j);
                }
                answer++;
            }
        }
        System.out.println(answer);
        return answer;
    }

    private void printfBoard(int[][] map) {
        for(int i=0;i< map.length;i++) {
            System.out.println();
            for (int j = 0; j < map[i].length; j++)
                System.out.print(map[i][j] + " ");
            System.out.println();
        }
    }
}
