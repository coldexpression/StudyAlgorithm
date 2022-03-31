package Level3;

import java.util.*;

public class problem42898 {

    public static void main(String[] args) {
        problem42898 problem42898 = new problem42898();
        problem42898.solution(1, 3, new int[][]{{1,2}});
    }

    public int solution(int m, int n, int[][] puddles) {
        int answer = 0;
        int[][] board = new int[n][m];
        HashMap<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        PriorityQueue<Integer> answerStore;
        for (int i = 0; i < puddles.length; i++) {
            int x = puddles[i][0] - 1;
            int y = puddles[i][1] - 1;
            board[y][x] = -1;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (board[0][i] == -1) break;
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            queue.add(i + 1);
            map.put(i, queue);
        }

        if (m == 1) {
            for(int i=0;i<n;i++) if (board[i][0] == -1) return 0;
        } else if (n == 1) {
            for(int i=0;i<m;i++) if (board[0][i] == -1) return 0;
        }

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("[" + i + "," + j + "]");
                if (board[i][j] != -1) {
                    PriorityQueue<Integer> queue;
                    PriorityQueue<Integer> newQueue;
                    PriorityQueue<Integer> prevQueue;
                    if (j == 0 && board[i - 1][j] != -1) {
                        queue = map.getOrDefault(j, new PriorityQueue<>());
                        newQueue = new PriorityQueue<>();
                        while (!queue.isEmpty()) {
                            newQueue.add(queue.poll() + 1);
                        }
                        map.put(j, newQueue);
                    }  else {
                        if (board[i][j - 1] == -1 && board[i - 1][j] != -1) {
                            queue = map.getOrDefault(j, new PriorityQueue<>());
                            newQueue = new PriorityQueue<>();
                            while (!queue.isEmpty()) {
                                newQueue.add(queue.poll() + 1);
                            }
                            map.put(j, newQueue);
                        } else if (board[i][j - 1] != -1 && board[i - 1][j] == -1) {
                            queue = map.getOrDefault(j - 1, new PriorityQueue<>());
                            prevQueue = new PriorityQueue<>(queue);
                            newQueue = new PriorityQueue<>();
                            while (!queue.isEmpty()) {
                                newQueue.add(queue.poll() + 1);
                            }
                            map.put(j - 1, prevQueue);
                            map.put(j, newQueue);
                        } else if (board[i][j - 1] != -1 && board[i - 1][j] != -1) {
                            Queue<Integer> queue1 = map.getOrDefault(j, new PriorityQueue<>());
                            Queue<Integer> queue2 = map.getOrDefault(j - 1, new PriorityQueue<>());
                            prevQueue = new PriorityQueue<>(queue2);
                            newQueue = new PriorityQueue<>();
                            while (!queue1.isEmpty()) newQueue.add(queue1.poll() + 1);
                            while (!queue2.isEmpty()) newQueue.add(queue2.poll() + 1);
                            map.put(j, newQueue);
                            map.put(j - 1, prevQueue);
                        }
                    }
                }
                System.out.println(map);
            }
        }
        System.out.println(map.get(m - 1));
        answerStore = map.getOrDefault(m - 1, new PriorityQueue<>());
        if (answerStore.isEmpty()) return 0;
        int min = answerStore.peek();
        while (!answerStore.isEmpty()) {
            if (min != answerStore.peek()) break;
            answer = (answer % 1000000007) + 1;
            answerStore.poll();
        }

        System.out.println(answer);


        return answer;
    }
}
