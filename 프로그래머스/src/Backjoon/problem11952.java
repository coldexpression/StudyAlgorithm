package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class problem11952 {

    static int[] weights;

    public static class Node {
        private int index;
        private boolean zombieArea;

        public Node(int index,boolean zombieArea) {
            this.index = index;
            this.zombieArea = zombieArea;
        }


        public void setZombieArea(boolean zombieArea) {
            this.zombieArea = zombieArea;
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        HashMap<Integer, List<Node>> graph = new HashMap<>();
        List<Node> infoList = new ArrayList<>();
        HashMap<Integer, Node> infoMap = new HashMap<>();

        long ans = Long.MAX_VALUE;

        String input = bf.readLine();
        String[] word = input.split(" ");
        int n = Integer.parseInt(word[0]);
        int m = Integer.parseInt(word[1]);
        int k = Integer.parseInt(word[2]);
        int s = Integer.parseInt(word[3]);

        int[] zombie = new int[k];
        boolean[] zombieZoneValid = new boolean[n+1];
        weights = new int[n+1];

        input = bf.readLine();
        word = input.split(" ");
        int p = Integer.parseInt(word[0]);
        int q = Integer.parseInt(word[1]);

        for(int i=0;i<zombie.length;i++) zombie[i] = Integer.parseInt(bf.readLine());

        infoList.add(0, new Node(-1, false));

        for(int i=1;i<=n;i++) {
            //infoMap.put(i, new Node(i, p, false));
            infoList.add(i, new Node(i, false));
        }

        for(int i=1;i<=m;i++) {
            input = bf.readLine();
            word = input.split(" ");
            int st = Integer.parseInt(word[0]);
            int ed = Integer.parseInt(word[1]);
            boolean fCheck = false;
            boolean bCheck = false;

            List<Node> nodeList = graph.getOrDefault(st, new LinkedList<>());

            for (int zomIndex : zombie) {
                if (fCheck) break;
                fCheck = ed == zomIndex;
            }

            for (int zomIndex : zombie) {
                if (bCheck) break;
                bCheck = st == zomIndex;
            }
            Node node = infoList.get(ed);
            node.setZombieArea(fCheck);
            nodeList.add(node);
            graph.put(st, nodeList);

            nodeList = graph.getOrDefault(ed, new LinkedList<>());
            node = infoList.get(st);
            node.setZombieArea(bCheck);
            nodeList.add(node);
            graph.put(ed, nodeList);
        }

        Arrays.fill(weights, p);

        for (int zombieIndex : zombie) {
            zombieZoneValid[zombieIndex] = true;
            weights[zombieIndex] = 0;
            zombieAreaCheck2(zombieIndex, graph, s, q);
        }

        long[] dst = new long[n+1];

        dijk(graph, zombieZoneValid,dst, 1, n);


        ans = dst[n] - weights[infoList.get(n).index];
        System.out.println(ans);
    }

    public static void dijk(HashMap<Integer, List<Node>> graph, boolean[] zombieZoneValid,long[] dst ,int st, int ed) {
        PriorityQueue<long[]> queue = new PriorityQueue<>(new Comparator<long[]>() {
            public int compare(long[] o1, long[] o2) {
                // TODO Auto-generated method stub
                if (o1[1] == o2[1]) {
                    return (int)(o1[0] - o2[0]);
                }
                return (int)(o1[1] - o2[1]);
            }

        });

        Arrays.fill(dst, Long.MAX_VALUE);

        boolean[] visited = new boolean[ed+1];
        visited[0] = true;
        dst[0] = 0;
        dst[1] = 0;

        queue.add(new long[] {1,0});
        visited[1] = true;

        while(!queue.isEmpty()) {
            int currentIndex = (int)queue.poll()[0];

            for (Node nextNode : graph.get(currentIndex)) {
                if (!nextNode.zombieArea && !visited[nextNode.index] && dst[currentIndex] + weights[nextNode.index] < dst[nextNode.index]) {
                    visited[nextNode.index] = true;
                    dst[nextNode.index] = dst[currentIndex] + weights[nextNode.index];
                    queue.add(new long[] {nextNode.index, dst[nextNode.index]});
                }
            }

        }

    }

    public static void zombieAreaCheck2(int st, HashMap<Integer, List<Node>> graph, int length, int price) {

        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // TODO Auto-generated method stub
                return o1[1] - o2[1];
            }
        });
        boolean[] visited = new boolean[graph.size() + 1];

        queue.add(new int[] { st, 0 });
        visited[st] = true;

        while (!queue.isEmpty()) {
            int[] info = queue.poll();
            int index = info[0];
            int val = info[1];

            if (val < length) {
                for (Node node : graph.get(index)) {
                    if (!visited[node.index]) {
                        visited[node.index] = true;
                        weights[node.index] = price;
                        if (val + 1 < length)
                            queue.add(new int[] { node.index, val + 1 });
                    }
                }
            }
        }

    }


}