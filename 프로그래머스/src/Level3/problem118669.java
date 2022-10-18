package Level3;

import java.util.*;

public class problem118669 {

    public class Node {
        private int index;

        private int currentSummit;

        private boolean[] visited;

        private int time;

        private boolean passSummits;

        public Node(int index, int currentSummit, boolean[] visited, int time, boolean passSummits) {
            this.index = index;
            this.currentSummit = currentSummit;
            this.visited = visited;
            this.time = time;
            this.passSummits = passSummits;
        }


        public boolean[] getVisited() {
            return visited;
        }

        public int getIndex() {
            return index;
        }

        public int getCurrentSummit() {
            return currentSummit;
        }

        public int getTime() {
            return time;
        }

        public boolean isPassSummits() {
            return passSummits;
        }
    }

    public static void main(String[] args) {
        problem118669 problem118669 = new problem118669();
        problem118669.solution(6, new int[][]{{1,2,3},{2,3,5},{2,4,2},{2,5,4},{3,4,4},{4,5,3},{4,6,1},{5,6,1}}, new int[]{1,3}, new int[]{5});
    }

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        int[] answer = new int[2];
        int min = Integer.MAX_VALUE;
        HashMap<String, Integer> dstMap = new HashMap<>();
        HashMap<Integer, List<Integer>> edgeMap = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        HashSet<Integer> summitsSet = new HashSet<>();
        HashSet<Integer> gatesSet = new HashSet<>();

        for (int summit : summits) {
            summitsSet.add(summit);
        }

        for (int gate : gates) {
            gatesSet.add(gate);
        }


        for (int[] path : paths) {
            StringBuilder sb = new StringBuilder();
            List<Integer> list = edgeMap.getOrDefault(path[0], new ArrayList<>());
            list.add(path[1]);
            edgeMap.put(path[0], list);

            sb.append(path[0]);
            sb.append("/");
            sb.append(path[1]);
            dstMap.put(sb.toString(), path[2]);
        }

        for (int[] path : paths) {
            List<Integer> list = edgeMap.getOrDefault(path[1], new ArrayList<>());
            list.add(path[0]);
            edgeMap.put(path[1], list);
        }

        answer[0] = Integer.MAX_VALUE;

        for (int i = 0; i < gates.length; i++) {
            boolean[] visited = new boolean[n + 1];
            int gate = gates[i];
            List<Integer> list = edgeMap.get(gate);

            int[] next = new int[list.size()];
            for (int j = 0; j < list.size(); j++) next[j] = list.get(j);

            visited[gate] = true;
            queue.add(new Node(gate, 0, visited, 0, false));

            while (!queue.isEmpty()) {
                Node node = queue.poll();
                int index = node.getIndex();
                boolean[] v = node.getVisited();
                boolean passSummits = node.isPassSummits();

                if (!passSummits) {
                    List<Integer> edges = edgeMap.get(index);
                    for (int j = 0; j < edges.size(); j++) {
                        int time = node.getTime();
                        int pick = edges.get(j);
                        if (!v[pick] && !gatesSet.contains(pick)) {
                            StringBuilder sb2 = new StringBuilder();

                            sb2.append(index);
                            sb2.append("/");
                            sb2.append(pick);

                            int d1 = dstMap.getOrDefault(sb2.toString(), -1);
                            int d2 = dstMap.getOrDefault(sb2.reverse().toString(), -1);

                            int newDst = Math.max(d1, d2);

                            if (summitsSet.contains(pick)) {
                                queue.add(new Node(pick, pick, null, Math.max(time, newDst), true));
                            } else {
                                boolean[] vst = node.getVisited().clone();
                                vst[index] = true;
                                queue.add(new Node(pick, 0, vst, Math.max(time, newDst), false));
                            }
                        }
                    }
                } else {
//                    if (index == gate) {
                    if (min >= node.getTime()) {
                        if (min == node.getTime() && answer[0] > node.currentSummit) {
                            answer[0] = node.getCurrentSummit();
                        } else {
                            min = node.getTime();
                            answer[0] = node.getCurrentSummit();
                            answer[1] = min;
                        }
                    }
//                    } else {
//                        List<Integer> edges = edgeMap.get(index);
//                        for (int j = 0; j < edges.size(); j++) {
//                            PriorityQueue<Integer> time = new PriorityQueue<>(node.getTime());
//                            int pick = edges.get(j);
//                            if (!v[pick] && (gate == pick || !gatesSet.contains(pick)) && !summitsSet.contains(pick)) {
//                                StringBuilder sb2 = new StringBuilder();
//
//                                sb2.append(index);
//                                sb2.append("/");
//                                sb2.append(pick);
//
//                                int d1 = dstMap.getOrDefault(sb2.toString(), -1);
//                                int d2 = dstMap.getOrDefault(sb2.reverse().toString(), -1);
//
//                                int newDst = Math.max(d1, d2);
//                                time.add(newDst);
//
//                                boolean[] vst = node.getVisited().clone();
//                                int currentSummit = node.getCurrentSummit();
//
//                                vst[index] = true;
//                                queue.add(new Node(pick, currentSummit, vst, time, passSummits));
//                            }
//                        }
//                    }
                }
            }
        }
//        answer = resultQueue.poll();
        System.out.println(answer[0]+" , " + answer[1]);
        return answer;
    }
}
