package Level3;

import java.util.*;

public class problem92343 {

    public class Node {
        private int index;

        private int wolfCount;

        private int sheepCount;

        private boolean[] visited;

        private int[] nextPos;

        public Node(int index, int wolfCount, int sheepCount, boolean[] visited, int[] nextPos) {
            this.index = index;
            this.wolfCount = wolfCount;
            this.sheepCount = sheepCount;
            this.visited = visited;
            this.nextPos = nextPos;
        }

        public boolean[] getVisited() {
            return visited;
        }

        public int getIndex() {
            return index;
        }

        public int getSheepCount() {
            return sheepCount;
        }

        public int getWolfCount() {
            return wolfCount;
        }

        public int[] getNextPos() {
            return nextPos;
        }
    }

    public static void main(String[] args) {
        problem92343 problem92343 = new problem92343();
//        problem92343.solution(new int[]{0,0,1,1,1,0,1,0,1,0,1,1}, new int[][]{{0,1},{1,2},{1,4},{0,8},{8,7},{9,10},{9,11},{4,3},{6,5},{4,6},{8,9}});
//        problem92343.solution(new int[]{0,1,0,1,1,0,1,0,0,1,0}, new int[][]{{0,1},{0,2},{1,3},{1,4},{2,5},{2,6},{3,7},{4,8},{6,9},{9,10}});
        problem92343.solution(new int[]{0,1}, new int[][]{{0,1}});
    }

    public int solution(int[] info, int[][] edges) {
        boolean[] visited = new boolean[info.length];
        Queue<Node> queue = new LinkedList<>();
        HashMap<Integer, int[]> nodeMap = new HashMap<>();
        Arrays.fill(visited, false);
        int answer = 0;
        Arrays.sort(edges, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0]) {
                    return o1[0] - o2[0];
                } else if (o1[0] == o2[0]) {
                    if (o1[1] > o2[1]) {
                        return o1[1] - o2[1];
                    } else if (o1[1] == o2[1]) {
                        return -1;
                    }
                    return -1;
                }
                return -1;
            }
        });

        for(int i=0;i<edges.length;i++) {
            System.out.print("["+edges[i][0]+" , "+edges[i][1]+"] ");
        }
        System.out.println();

        for (int[] edge : edges) {
            int parent = edge[0];
            int child = edge[1];
            int[] childes = nodeMap.getOrDefault(parent, new int[]{-1, -1});
            if (childes[0] == -1) {
                childes[0] = child;
            } else if (childes[1] == -1) {
                childes[1] = child;
            }
            nodeMap.put(parent, childes);
        }

        visited[0] = true;
        int[] ints = nodeMap.get(0);

        queue.add(new Node(0, 0, 1, visited, ints));

        while(!queue.isEmpty()) {
            Node node = queue.poll();
            int sheepCount = node.getSheepCount();
            int wolfCount = node.getWolfCount();

            if (sheepCount > wolfCount) {
                System.out.println("현재 인덱스 : " + node.getIndex());
                System.out.print("갈수 있는 목적지 : [");
                for (int ele : node.nextPos) {
                    System.out.print(ele + " ");
                }
                System.out.print("]");
                System.out.println();
                answer = Math.max(answer ,sheepCount);
                int[] nextPos = node.getNextPos();
                for (int i = 0; i < nextPos.length; i++) {
                    if (nextPos[i] != -1) {
                        List<Integer> list = new ArrayList<>();
                        int[] ints1 = nodeMap.getOrDefault(nextPos[i], new int[]{-1});
//                    System.out.println("다음 목적지 : ["+ints1[0]+", "+ints1[1]+"]");

                        for (int j = 0; j < nextPos.length; j++) {
                            if (i != j) {
                                list.add(nextPos[j]);
                            }
                        }

                        for (int j = 0; j < ints1.length; j++) {
                            if (ints1[j] != -1) list.add(ints1[j]);
                        }

                        System.out.println("list >> " + list);
                        int[] newNextPos = new int[list.size()];
                        for (int j = 0; j < newNextPos.length; j++) newNextPos[j] = list.get(j);

                        int animal = info[nextPos[i]];
                        if (animal == 0) {
                            queue.add(new Node(nextPos[i], wolfCount, sheepCount + 1, visited, newNextPos));
                        } else {
                            queue.add(new Node(nextPos[i], wolfCount + 1, sheepCount, visited, newNextPos));
                        }
                    }
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}
