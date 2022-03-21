package Level3;

import java.util.*;

public class problem72413 {

//    static String board;
//    static int count;
//    static HashMap<String, Integer> storeA;
//    static boolean[] visited;
    static int[][] map;

    public static void main(String[] args) {
        problem72413 problem72413 = new problem72413();
//        problem72413.solution(6, 4, 6, 2, new int[][]{{4,1,10},{3,5,24},{5,6,2},{3,1,41},{5,1,24},{4,6,50},{2,4,66},{2,3,22},{1,6,25}});
        problem72413.solution(7, 3, 4, 1, new int[][]{{5,7,9},{4,6,4},{3,6,1},{3,2,3},{2,1,6}});
    }

    public int solution(int n, int s,int a, int b, int[][] fares) {
        int[] transfer = new int[n];
        int[] dstStore;
        map = new int[n][n];
        int min = Integer.MAX_VALUE;
        int sum = 0;
        init(fares, n);
        transfer = findShortDistance(map, transfer, s-1, n);
        for(int i=0;i<n;i++) {
            if (transfer[i] != Integer.MAX_VALUE && transfer[i] < min) {
                dstStore = findShortDistance(map, transfer, i, n);
                sum = dstStore[a - 1] + dstStore[b - 1] + transfer[i];
                min = Math.min(sum, min);
            }
        }
        System.out.println(min);
        return min;
    }

    private int[] findShortDistance(int[][] map, int[] transfers, int s, int n) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int[] transfer = transfers.clone();
        int[] visited = new int[n];
        int index = 0;
        Arrays.fill(transfer, Integer.MAX_VALUE);
        Arrays.fill(visited, 0);
        for(int i=0;i<n;i++) {
            if (map[s][i] != -1) {
                transfer[i] = map[s][i];
                queue.add(map[s][i]);
            }
        }
        visited[s] = 1;
        transfer[s] = 0;
        while(!queue.isEmpty()) {
            int pickNum = queue.poll();
            if(pickNum == Integer.MAX_VALUE) break;
            for(int i=0;i<n;i++) {
                if (s != i && visited[i] == 0 && transfer[i] == pickNum) {
                    index = i;
                    break;
                }
            }
            for(int i=0;i<n;i++) {
                if(s != i && map[index][i] != -1 && map[index][i] + pickNum <= transfer[i]) {
                    transfer[i] = map[index][i] + pickNum;
                    queue.add(transfer[i]);
                }
            }
            visited[index] = 1;
        }
        return transfer;
    }

    public void init(int[][] fares, int n) {
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                map[i][j] = -1;

        for(int i=0;i<fares.length;i++) {
            map[fares[i][0] - 1][fares[i][1] - 1] = fares[i][2];
            map[fares[i][1] - 1][fares[i][0] - 1] = fares[i][2];
        }
    }
//    public int solution(int n, int s, int a, int b, int[][] fares) {
//        int answer = 0;
//        int[][] map = new int[n][n];
//        board = "";
//        count = 0;
//        storeA = new HashMap<>();
//        visited = new boolean[n];
//        Arrays.fill(visited, false);
//        map = init(map);
//        for (int i = 0; i < fares.length; i++) {
//            int p1 = fares[i][0] - 1;
//            int p2 = fares[i][1] - 1;
//            int distance = fares[i][2];
//            map[p1][p2] = distance;
//            map[p2][p1] = distance;
//        }
//        dfs(map, s-1, a-1, n);
//        board = "";
//        dfs(map, s-1, b-1, n);
//        System.out.println(storeA);
//        return answer;
//    }
//
//    private int[][] init(int[][] map) {
//        for(int i=0;i<map.length;i++) {
//            for (int j = 0; j < map[i].length; j++) {
//                map[i][j] = -1;
//            }
//        }
//        return map;
//    }
//
//    private void dfs(int[][] map, int start, int end, int n) {
//        if (board.length() != 0 && board.indexOf(String.valueOf(end)) == board.length() - 1 && !storeA.containsKey(board)) {
//            int score = 0;
//            System.out.println("정답 : " + board);
//            for(int i=0;i<board.length()-1;i++) {
//                int i1 = Integer.parseInt(String.valueOf(board.charAt(i)));
//                int i2 = Integer.parseInt(String.valueOf(board.charAt(i+1)));
//                score += map[i1][i2];
//            }
//            storeA.put(board, score);
//            return;
//        }
//
//
//        for (int i = 0; i < n; i++) {
//            if (!visited[start] && map[start][i] != -1) {
//                String temp = board;
//                visited[start] = true;
//                board += start;
//                dfs(map, i, end, n);
//                board = temp;
//                visited[start] = false;
//            }
//        }
//    }
}
