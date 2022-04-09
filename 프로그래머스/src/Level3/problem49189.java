package Level3;

import java.util.*;

public class problem49189 {

    public static void main(String[] args) {
        problem49189 problem49189 = new problem49189();
        problem49189.solution(6, new int[][]{{3,6},{4,3},{3,2},{1,3},{1,2},{2,4},{5,2}});
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        int[][] board = new int[n][n];
        boolean[] visited = new boolean[n];
        int prevNode = 0;
        int max = Integer.MIN_VALUE;
        Arrays.fill(visited, false);
        HashMap<Integer, Integer> dstStore = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        for(int i=0;i<edge.length;i++) {
            int p1 = edge[i][0] - 1;
            int p2 = edge[i][1] - 1;
            board[p1][p2] = board[p2][p1] = 1;
        }

        queue.add(new Node(0, 0));
        while(!queue.isEmpty()) {
            Node node = queue.poll();
            if (!visited[node.current]) {
                visited[node.current] = true;
                for (int i = 0; i < n; i++) {
                    if (board[node.current][i] != 0 && !visited[i]) {
                        Node nextNode = new Node(i, node.current);
                        queue.add(nextNode);
                    }
                }
                if (node.current == 0) {
                    dstStore.put(node.current, 0);
                } else {
                    dstStore.put(node.current, dstStore.get(node.prev) + 1);
                }
            }
        }
        for (Integer value : dstStore.values()) max = Math.max(value, max);
        for (Integer value : dstStore.values()) answer = max == value ? answer + 1 : answer;
        System.out.println(dstStore);
        return answer;
    }

    class Node {
        private int current;
        private int prev;


        public Node(int current, int prev) {
            this.current = current;
            this.prev = prev;
        }
    }
}
