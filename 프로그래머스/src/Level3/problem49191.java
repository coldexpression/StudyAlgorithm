package Level3;

import java.util.*;

public class problem49191 {

    static HashSet<Integer> currentPlayers;

    public static void main(String[] args) {
        problem49191 problem49191 = new problem49191();
//        problem49191.solution(5, new int[][]{{4,3},{4,2},{3,2},{1,2},{2,5}});
//        problem49191.solution(100, new int[][]{{1,2},{1,3}});
//        problem49191.solution(5, new int[][]{{4,2},{4,3},{4,1},{1,2}});
        problem49191.solution(6, new int[][]{{1,6},{2,6},{3,6},{4,6}});
    }

    public int solution(int n, int[][] results) {
        int answer = 0;
        HashMap<Integer, List<Integer>> parentStore = new HashMap<>();
        HashMap<Integer, List<Integer>> childStore = new HashMap<>();
        HashSet<Integer> totalPlayer = new HashSet<>();
        List<Player> players = new ArrayList<>();
        currentPlayers = new HashSet<>();
        for(int i=0;i<results.length;i++) {
            List<Integer> listA = new ArrayList<>();
            List<Integer> listB = new ArrayList<>();
            childStore.put(results[i][0]-1, listA);
            parentStore.put(results[i][1]-1, listB);
        }

        // 자식 구하기
        for(int i=0;i<results.length;i++) {
            List<Integer> list = new ArrayList<>(childStore.get(results[i][0]-1));
            totalPlayer.add(results[i][0]-1);
            totalPlayer.add(results[i][1]-1);
            list.add(results[i][1]-1);
            childStore.put(results[i][0]-1, list);
        }

        // 부모 구하기
        for(int i=0;i<results.length;i++) {
            List<Integer> list = new ArrayList<>(parentStore.get(results[i][1]-1));
            list.add(results[i][0]-1);
            parentStore.put(results[i][1]-1, list);
        }

        for (int key : totalPlayer) {
            List<Integer> objects = new ArrayList<>();
            Player player = new Player(key, parentStore.getOrDefault(key, objects), childStore.getOrDefault(key, objects));
            players.add(player);
        }

        for (Player player : players) {
            System.out.println("플레이어 인덱스 : " + player.index);
            System.out.println("플레이어 부모 : " + player.parent);
            System.out.println("플레이어 자식 : " + player.child);
        }

        System.out.println(players);

        for(int index: totalPlayer) {
            currentPlayers = new HashSet<>();
            System.out.println("index= " + index);
            dfs(players, "P", index);
            dfs(players, "C", index);
            answer = currentPlayers.size() == n -1 ? answer + 1 : answer;
            System.out.println(currentPlayers);
        }

//        for(int i=0;i<n;i++) {
//            dfs(players, "P", i);
//            dfs(players, "C", i);
//            answer = currentPlayers.size() == n -1 ? answer + 1 : answer;
//            System.out.println(currentPlayers);
//            currentPlayers.clear();
//        }

        System.out.println(answer);
        return answer;
    }

    private void dfs(List<Player> players, String word, int startIndex) {
//        if (currentPlayers.size() == n - 1) {
//            return;
//        }
        System.out.println("startINdex : " + startIndex);
        int count = 0;
        for (Player player : players) {
            if (player.index == startIndex) break;
            count++;
        }
        Player player = players.get(count);
        if (word.equals("P") && !player.parent.isEmpty()) {
            for (int j = 0; j < player.parent.size(); j++) {
                if (!currentPlayers.contains(player.parent.get(j))) {
                    currentPlayers.add(player.parent.get(j));
                    dfs(players, "P", player.parent.get(j));
                }
            }
        } else if (word.equals("C") && !player.child.isEmpty()) {
            for (int j = 0; j < player.child.size(); j++) {
                if (!currentPlayers.contains(player.child.get(j))) {
                    currentPlayers.add(player.child.get(j));
                    dfs(players, "C", player.child.get(j));
                }
            }
        } else if (player.parent == null || player.child == null) return;
    }

    private static class Player {
        private List<Integer> parent;
        private List<Integer> child;
        private int index;

        public Player(int index, List<Integer> parent, List<Integer> child) {
            this.index = index;
            this.parent = parent;
            this.child = child;
        }
    }
}
