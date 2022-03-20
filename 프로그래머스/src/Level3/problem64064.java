package Level3;

import java.util.*;

public class problem64064 {

    static boolean[] visited;
    static List<String> board;
    static HashSet<String> answerSet;
    static int answer;

    public static void main(String[] args) {
        problem64064 problem64064 = new problem64064();
        problem64064.solution(new String[]{"frodo","fradi","crodo","abc123","frodoc"}, new String[]{"fr*d*","abc1**"});
    }

    public int solution(String[] user_id, String[] banned_id) {
        HashMap<Integer, List<String>> store = new HashMap<>();
        answer = 0;
        int index = 0;
        int count = 0;
        visited = new boolean[banned_id.length];
        board = new ArrayList<>();
        answerSet = new HashSet<>();
        for(String bannedId : banned_id) {
            List<String> wordsStore = new ArrayList<>();
            int length = bannedId.replaceAll("\\*","").length();
            for(int i=0;i< user_id.length;i++) {
                count = 0;
                if (bannedId.length() == user_id[i].length()) {
                    for (int j = 0; j < bannedId.length(); j++) {
                        if (user_id[i].charAt(j) == bannedId.charAt(j)) count++;
                    }
                    if (count == length) wordsStore.add(user_id[i]);
                }
            }

            store.put(index, wordsStore);
            index++;
        }


        System.out.println(store);
        dfs(store, 0, visited.length);
        System.out.println(answerSet);
        answer = answerSet.size();
        return answer;
    }

    private void dfs(HashMap<Integer, List<String>> store, int start, int end) {
        if (start == end) {
            if (board.size() == end) {
                String[] temp = board.stream().toArray(String[]::new);
                Arrays.sort(temp);
                String tempBoard = "";
                for(String word: temp) tempBoard += word;
                System.out.println(tempBoard);
                answerSet.add(tempBoard);
            }
        }

        for(int i=start;i< visited.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                for(int j=0;j<store.get(i).size();j++) {
                    if (!board.contains(store.get(i).get(j))) {
                        board.add(store.get(i).get(j));
                        dfs(store, start+1, end);
                        board.remove(store.get(i).get(j));
                    }
                }
                visited[i] = false;
            }
        }
    }
}
