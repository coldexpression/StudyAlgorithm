package Level3;

import java.util.*;

public class problem72413 {

    static String board;
    static int count;
    static HashMap<String, Integer> storeA;
    static boolean[] visited;

    public static void main(String[] args) {
        problem72413 problem72413 = new problem72413();
        problem72413.solution(6, 4, 6, 2, new int[][]{{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}});
    }

    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = 0;
        int[][] map = new int[n][n];
        board = "";
        count = 0;
        storeA = new HashMap<>();
        visited = new boolean[n];
        Arrays.fill(visited, false);
        map = init(map);
        for (int i = 0; i < fares.length; i++) {
            int p1 = fares[i][0] - 1;
            int p2 = fares[i][1] - 1;
            int distance = fares[i][2];
            map[p1][p2] = distance;
            map[p2][p1] = distance;
        }
        dfs(map, s-1, a-1, n);
        board = "";
        dfs(map, s-1, b-1, n);
        System.out.println(storeA);
        return answer;
    }

    private int[][] init(int[][] map) {
        for(int i=0;i<map.length;i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = -1;
            }
        }
        return map;
    }

    private void dfs(int[][] map, int start, int end, int n) {
        if (board.length() != 0 && board.indexOf(String.valueOf(end)) == board.length() - 1 && !storeA.containsKey(board)) {
            int score = 0;
            System.out.println("정답 : " + board);
            for(int i=0;i<board.length()-1;i++) {
                int i1 = Integer.parseInt(String.valueOf(board.charAt(i)));
                int i2 = Integer.parseInt(String.valueOf(board.charAt(i+1)));
                score += map[i1][i2];
            }
            storeA.put(board, score);
            return;
        }


        for (int i = 0; i < n; i++) {
            if (!visited[start] && map[start][i] != -1) {
                String temp = board;
                visited[start] = true;
                board += start;
                dfs(map, i, end, n);
                board = temp;
                visited[start] = false;
            }
        }
    }
}
