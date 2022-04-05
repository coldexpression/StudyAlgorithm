package DevMatch;

import java.util.*;

public class p1 {

    static boolean[] visited;
    static Stack<Integer> routesStore;
    static List<List<Integer>> answerStore;

    public static void main(String[] args) {
        p1 p1 = new p1();
//        p1.solution(new int[][]{{0,5,2,4,1},{5,0,3,9,6},{2,3,0,6,3},{4,9,6,0,3},{1,6,3,3,0}});
        p1.solution(new int[][]{{0,2,3,1},{2,0,1,1},{3,1,0,2},{1,1,2,0}});
    }

    public int[][] solution(int[][] dist) {
        int[][] answer = {};
        int startMaxIndex = 0;
        int startMaxDst = Integer.MIN_VALUE;
        int endMaxIndex = 0;
        int endMaxDst = Integer.MIN_VALUE;
        List<int[]> list = new ArrayList<>();
        List<Integer> startIndexs = new ArrayList<>();
        List<Integer> endIndexs = new ArrayList<>();
        visited = new boolean[dist.length];
        routesStore = new Stack<>();
        answerStore = new ArrayList<>();
        Arrays.fill(visited, false);
        for(int i=0;i<dist[0].length;i++) {
            if (dist[0][i] > startMaxDst) {
                startMaxDst = dist[0][i];
                startMaxIndex = i;
            }
        }

        for(int i=0;i<dist[0].length;i++) {
            if (startMaxDst == dist[0][i]) startIndexs.add(i);
        }

        for(int i=0;i<dist[startMaxIndex].length;i++) {
            if (dist[startMaxIndex][i] > endMaxDst) {
                endMaxDst = dist[startMaxIndex][i];
                endMaxIndex = i;
            }
        }

        for(int i=0;i<dist[startMaxIndex].length;i++) {
            if (endMaxDst == dist[startMaxIndex][i]) endIndexs.add(i);
        }

        System.out.println(startIndexs);
        System.out.println(endIndexs);
        for(int i=0;i<startIndexs.size();i++){
            visited[startIndexs.get(i)] = true;
            routesStore.add(startIndexs.get(i));
            findRoutes(startIndexs.get(i), endIndexs.get(i), dist);
            routesStore.clear();
            visited[startIndexs.get(i)] = false;
            visited[endIndexs.get(i)] = true;
            routesStore.add(endIndexs.get(i));
            findRoutes(endIndexs.get(i), startIndexs.get(i), dist);
            routesStore.clear();
            visited[endIndexs.get(i)] = false;
        }
        System.out.println(answerStore);
        Collections.sort(answerStore, new Comparator<List<Integer>>() {
            @Override
            public int compare(List<Integer> o1, List<Integer> o2) {
                int n1 = o1.get(0);
                int n2 = o2.get(0);
                return n1-n2;
            }
        });
        answer = new int[answerStore.size()][answerStore.get(0).size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = answerStore.get(i).stream().mapToInt(j -> j).toArray();
        }



        return answer;
    }

    private void findRoutes(int start, int end, int[][] dist) {
        if (start == end) {
            answerStore.add(new ArrayList<>(routesStore));
            return ;
        }
        System.out.println("시작 : " + start);
        System.out.println("끝 : " + end);
        List<Integer> nextIndexStore = findMinIndex(dist, start);
        for(int nextIndex: nextIndexStore) {
            visited[nextIndex] = true;
//            if(!routesStore.contains(nextIndex)) {
                routesStore.add(nextIndex);
                System.out.println("스택: " + routesStore);
                findRoutes(nextIndex, end, dist);
                routesStore.pop();
//            }
            visited[nextIndex] = false;
        }

    }

    private List<Integer> findMinIndex(int[][] dist, int start) {
        List<Integer> store = new ArrayList<>();
        int minIndex = 0;
        int minDst = Integer.MAX_VALUE;
        for(int i=0;i<dist[0].length;i++) {
            if (!visited[i] && dist[start][i] != 0 && dist[start][i] < minDst) {
                minDst = dist[start][i];
                minIndex = i;
            }
        }
        store.add(minIndex);
        for(int i=0;i<dist[0].length;i++) {
            if (!visited[i] && i != minIndex && dist[start][i] == minDst) store.add(i);
        }
        System.out.println("시작 점 : " + start);
        System.out.println("minIndex 모음 : " + store);
        return store;
    }
}
