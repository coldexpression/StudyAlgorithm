package Level2;

import java.util.*;

public class problem1844 {

    static int[][] visited;
    static int[] x = {-1, 1};
    static int[] y = {-1, 1};

//    static int answer;
    static Queue<int[]> queue = new LinkedList<>();

    public static void main(String[] args) {
        problem1844 problem1844 = new problem1844();
        problem1844.solution(new int[][]{{1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}});
    }

    public int solution(int[][] maps) {
        int answer = -1;
        int x_length = maps[0].length -1;
        int y_length = maps.length -1;
        visited = new int[y_length+1][x_length+1];
        for(int i=0;i<=y_length;i++)
            for(int j=0;j<=x_length;j++)
                visited[i][j] = 0;
        if (x_length == 0 && y_length == 0) return 1;
        visited[0][0] = 1;
        queue.add(new int[]{0, 0});
        answer = bfs(x_length, y_length, maps);
        System.out.println(answer);
        return answer;
    }

    private int bfs(int x_length, int y_length, int[][] maps) {
        while(!queue.isEmpty()) {
            int[] position = queue.poll();

            int x_position = position[1];
            int y_position = position[0];
            if (!queue.isEmpty()) {
                System.out.println("queue in! ");
                System.out.println("[" + queue.peek()[0] + "," + queue.peek()[1] + "]");
                System.out.println("queue out!");
            }
            System.out.println("[" + y_position + "," + x_position + "]");
            if (x_position == x_length && y_position == y_length) return visited[y_position][x_position];
            for(int x_weight: x) {
                int x_nextPosition = x_position + x_weight;
                if (x_nextPosition >= 0 && x_nextPosition<= x_length && maps[y_position][x_nextPosition] == 1 && visited[y_position][x_nextPosition] == 0) {
                    visited[y_position][x_nextPosition] = visited[y_position][x_position] + 1;
                    queue.add(new int[]{y_position, x_nextPosition});
                }
            }
            for(int y_weight: y) {
                int y_nextPosition = y_position + y_weight;
                if (y_nextPosition >= 0 && y_nextPosition <= y_length && maps[y_nextPosition][x_position] == 1 && visited[y_nextPosition][x_position] == 0) {
                    visited[y_nextPosition][x_position] = visited[y_position][x_position] + 1;
                    queue.add(new int[]{y_nextPosition, x_position});
                }
            }
        }
        return -1;
    }

    /*
       public int solution(int[][] maps) {
        answer = -1;
        visited = new boolean[5][5];

        for (int i = 0; i < visited.length; i++)
            for (int j = 0; j < visited[i].length; j++)
                visited[i][j] = false;
        if (maps[4][3] == 1 && maps[3][4] == 1) return -1;
        dfs(0, 0, maps, 1);
        return answer;
    }

    private void dfs(int start_x, int start_y, int[][] maps, int move) {
        if (start_x == 4 && start_y == 4) {
            answer = Math.min(answer, move);
            System.out.println(answer);
            return;
        }
        if (!visited[start_y][start_x] && maps[start_y][start_x] != 0) {
            visited[start_y][start_x] = true;
            for (int k = 0; k < x.length; k++) {
                if (start_x + x[k] >= 0 && start_x + x[k] <= 4) {
                    dfs(start_x + x[k], start_y, maps, move + 1);
                }
            }
            for (int k = 0; k < y.length; k++) {
                if (start_y + y[k] >= 0 && start_y + y[k] <= 4) {
                    dfs(start_x, start_y + y[k], maps, move + 1);
                }
            }
            visited[start_y][start_x] = false;
        }

    } */

}
