package SSAFY.TemporaryTest;

import java.util.*;

public class problem1248 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();

        int T = sc.nextInt();

        for(int t=1;t<=T;t++) {
            int V = sc.nextInt();
            int E = sc.nextInt();

            int f1 = sc.nextInt();
            int f2 = sc.nextInt();

            boolean[] visited = new boolean[V+1];

            HashMap<Integer, Integer> map = new HashMap<>();
            HashMap<Integer , List<Integer>> parentMap = new HashMap<>();

            for(int i=1;i<=E;i++) {
                int parent = sc.nextInt();
                int child = sc.nextInt();

                map.put(child, parent);
                List<Integer> list = parentMap.getOrDefault(parent, new ArrayList<>());
                list.add(child);

                parentMap.put(parent, list);
            }


            int m1 = markingNode(visited, map, f1);
            int m2 = markingNode(visited, map, f2);

            int commonParent = Math.max(m1, m2);

            int treeSize = countChildNode(parentMap, commonParent);

            sb.append("#").append(t).append(" ").append(commonParent).append(" ").append(treeSize).append("\n");
        }

        System.out.println(sb.toString());
    }

    static int countChildNode(HashMap<Integer, List<Integer>> map, int targetIndex) {
        int count = 1;
        Queue<Integer> queue = new LinkedList<>();

        queue.add(targetIndex);

        while(!queue.isEmpty()) {
            int pick = queue.poll();

            List<Integer> list = map.getOrDefault(pick, new ArrayList<>());

            count += list.size();
            list.forEach(ele -> queue.add(ele));
        }

        return count;
    }

    static int markingNode(boolean[] visited, HashMap<Integer, Integer> map, int targetIndex) {

        while(true) {
            if (visited[targetIndex]) return targetIndex;

            visited[targetIndex] = true;

            if (targetIndex == 1) return -1;

            targetIndex = map.get(targetIndex);
        }
    }
}
