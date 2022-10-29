package Level3;

import java.util.*;

public class problem132266 {
    public static void main(String[] args) {
        problem132266 problem132266 = new problem132266();
        problem132266.solution(3, new int[][]{{1,2},{2,3}}, new int[]{2,3}, 1);
    }

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        int[] answer = new int[n+1];

        Arrays.fill(answer, -1);

        answer[destination] = 0;

        HashMap<Integer, List<Integer>> map = new HashMap<>();

        for(int i=0;i<=n;i++) map.put(i, new ArrayList<>());

        for (int[] road : roads) {
            int start = road[0];
            int end = road[1];

            map.get(start).add(end);
            map.get(end).add(start);
        }

            int[] visited = new int[n+1];
            Queue<Integer> queue = new LinkedList<>();
            queue.add(destination);
            visited[destination] = 1;

            while(!queue.isEmpty()) {
                int index = queue.poll();

                List<Integer> list = map.get(index);
                for(int i=0;i<list.size();i++) {
                    int idx = list.get(i);
                    if (visited[idx] == 0) {
                        visited[idx] = 1;
                        answer[idx] = answer[index] + 1;
                        queue.add(idx);
                    }
                }

            }
        List<Integer> ansList = new ArrayList<>();

        Arrays.sort(sources);
        for(int i=0;i<sources.length;i++) {
            ansList.add(answer[sources[i]]);
        }

        int[] ans = new int[ansList.size()];
        for(int i=0;i<ansList.size();i++) ans[i] = ansList.get(i);
        return ans;
    }
}
