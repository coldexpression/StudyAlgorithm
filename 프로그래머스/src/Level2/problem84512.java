package Level2;

import java.util.*;

public class problem84512 {

    static boolean[] visited;
    static StringBuilder sb;
    static int count;
    static int answer;
    static boolean check;
    static HashMap<String, Integer> store = new HashMap<>();

    public static void main(String[] args) {
        problem84512 problem84512 = new problem84512();
        problem84512.solution("A");
    }

    public int solution(String word) {
        answer = 0;
        check = false;
        String[] words = new String[]{"A","E","I","O","U"};
        sb = new StringBuilder();
        visited = new boolean[5];
        count = -1;
        Arrays.fill(visited, false);
        dfs(0, 5, words, word);
        System.out.println(answer);
        return answer;
    }

    private void dfs(int start, int end, String[] words, String word) {
        if (start <= end && !store.containsKey(sb.toString())) {
            count++;
            store.put(sb.toString(), count);
            System.out.println(sb.toString());
            if(sb.toString().equals(word)) {
                answer = store.get(sb.toString());
                check = true;
                return ;
            }
        }

        for(int i=0;i<5;i++) {
            if (!visited[i]) {
                visited[i] = true;
                for(int j=0;j<words.length;j++) {
                    if(check) break;
                    sb.append(words[j]);
                    dfs(start+1, end, words, word);
                    sb.deleteCharAt(sb.length()-1);
                }
                visited[i] = false;
            }
        }

    }

}
