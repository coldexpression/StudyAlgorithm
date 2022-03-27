package Level3;

import java.util.*;
import java.util.stream.Collectors;

public class problem43163 {

    static HashSet<String> containsWord;
    static int min;

    public static void main(String[] args) {
        problem43163 problem43163 = new problem43163();
        problem43163.solution("hit","cog",new String[]{"hot","dot","dog","lot","log","cog"});
    }

    public int solution(String begin, String target, String[] words) {
        int answer = 0;
        HashMap<Integer, List<Character>> store = new HashMap<>();
        containsWord = new HashSet<>();
        min = Integer.MAX_VALUE;
        for(int i=0;i<begin.length();i++) {
            HashSet<Character> wordStore = new HashSet<>();
            List<Character> list = new ArrayList<>();
            for(String word: words) {
                containsWord.add(word);
                wordStore.add(word.charAt(i));
            }
            list = new ArrayList<>(wordStore);
            store.put(i, list);
        }

        if(!containsWord.contains(target)) return 0;

        dfs(begin, target, store, 0);
        System.out.println(min);
        return min;
    }

    private void dfs(String begin, String target, HashMap<Integer, List<Character>> store, int count) {
        if (begin.equals(target)) {
            min = Math.min(count, min);
            return ;
        }

        for(int i=0;i<begin.length();i++) {
            System.out.println(i+"번째 인덱스");
            System.out.println("시작 단어 :" + begin);
            for(int j=0;j<store.get(i).size();j++) {
                char changeWord = store.get(i).get(j);
                char[] temp = begin.toCharArray();
                System.out.println("begin : " + begin);
                temp[i] = changeWord;
                for (char c : temp) {
                    System.out.print(c+" ");
                }
                System.out.println();
                String newBegin = String.valueOf(temp);
                if (containsWord.contains(newBegin)) {
                    store.get(i).remove(j);
                    containsWord.remove(newBegin);
                    dfs(newBegin, target, store, count + 1);
                    containsWord.add(newBegin);
                    store.get(i).add(changeWord);
                }
            }
        }
    }
}
