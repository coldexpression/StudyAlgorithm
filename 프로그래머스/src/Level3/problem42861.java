package Level3;

import java.util.*;

public class problem42861 {

    static HashSet<Integer> currentBridge;
    static int answer;

    public static void main(String[] args) {
        problem42861 problem42861 = new problem42861();
//        problem42861.solution(4, new int[][]{{0,1,1},{3,0,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}});
        problem42861.solution(6, new int[][]{{0,1,4},{2,0,3},{3,0,2},{1,3,5},{1,5,1},{2,3,1},{3,4,1},{5,4,6}});
    }

    public int solution(int n, int[][] costs) {
        answer = Integer.MAX_VALUE;
        int[][] board = new int[n][n];
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                board[i][j] = -1;

            for(int i=0;i<costs.length;i++) {
                int p1 = costs[i][0];
                int p2 = costs[i][1];
                int dst = costs[i][2];
                board[p1][p2] = board[p2][p1] = dst;
            }
            for(int i=0;i<n;i++) {
                bfs(board, i, n);
            }
        System.out.println(answer);
        return answer;
    }

    private void bfs(int[][] board, int startIndex, int n) {
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        int price = 0;
        currentBridge = new HashSet<>();
        System.out.println("시작 인덱스 : " + startIndex);
        for(int i=0;i<n;i++) {
            if (board[startIndex][i] != -1) {
                queue.add(new int[]{i, board[startIndex][i]});
            }
        }
        currentBridge.add(startIndex);

        while(!queue.isEmpty()) {
            int[] pick = queue.poll();
            if(!currentBridge.contains(pick[0])) {
                System.out.println("인덱스 : " + pick[0]);
                System.out.println("거리 : " + pick[1]);
                currentBridge.add(pick[0]);
                price += pick[1];
            }

            if(currentBridge.size() == n) break;
            for(int i=0;i<n;i++) {
                if (board[pick[0]][i] != -1 && !currentBridge.contains(i)) queue.add(new int[]{i, board[pick[0]][i]});
            }
        }
        System.out.println(currentBridge);
        System.out.println("가격 : " + price);
        answer = Math.min(answer, price);
    }
}
