package Level3;

import java.util.*;

public class problem118669 {

    public class Node {
        private int index;

        private int time;

        public Node(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public static void main(String[] args) {
        problem118669 problem118669 = new problem118669();
        problem118669.solution(6, new int[][]{{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}}, new int[]{1,3}, new int[]{5});
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        int[] score = new int[n+1];
        HashSet<Integer> summitsSet = new HashSet<>();

        answer[0] = Integer.MAX_VALUE;
        answer[1] = Integer.MAX_VALUE;

        List<List<Node>> graph = new ArrayList<>();

        for (int summit : summits) {
            summitsSet.add(summit);
        }

        for(int i=0;i<=n;i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] path : paths) {
            int start = path[0];
            int end = path[1];
            int time = path[2];

            graph.get(start).add(new Node(end, time));
            graph.get(end).add(new Node(start, time));
        }


        for (int gate : gates) {
            PriorityQueue<Node> queue = new PriorityQueue<>(new Comparator<Node>() {
                @Override
                public int compare(Node o1, Node o2) {
                    if (o1.time == o2.time) {
                        return o1.index - o2.index;
                    }
                    return o1.time - o2.time;
                }
            });
            boolean[] visited = new boolean[n+1];

            for (int i : gates) {
                visited[i] = true;
            }

            queue.add(new Node(gate, 0));

            while(!queue.isEmpty()) {
                Node node = queue.poll();
                System.out.println("**************************");
                System.out.println("현재 위치 : " + node.index);
                System.out.println("**************************");
                List<Node> list = graph.get(node.index);

                for (Node node2 : list) {
                    if (visited[node2.index]) continue;

                    if (summitsSet.contains(node2.index)) {
                        score[node2.index] = Math.max(node2.time, score[node.index]);
                    } else {
                        if (!visited[node2.index] && answer[1] >= node2.time && answer[1] >= score[node.index]) {
                            score[node2.index] = Math.max(node2.time, score[node.index]);
                            System.out.println("연결된 위치 : " + node2.index);
                            System.out.println("여기까지 최대 시간 : " + score[node2.index]);
                            queue.add(new Node(node2.index, 0));
                            visited[node2.index] = true;
                        }
                    }
                }
            }
            for (int summit : summits) {
                int time = score[summit];
                System.out.println("[봉우리: " + summit + "] => " + time);
                if (time > 0) {
                    if (answer[1] == time) {
                        if (answer[0] > summit) answer[0] = summit;
                    } else if (answer[1] > time) {
                        answer[1] = time;
                        answer[0] = summit;
                    }
                }
            }
        }

        System.out.println(answer[0]+", "+answer[1]);
        return answer;
    }
}
