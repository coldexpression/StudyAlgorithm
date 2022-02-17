package Level2;

import java.util.*;
import java.util.stream.Collectors;

public class problem42578 {

    public static void main(String[] args) {
        problem42578 problem42578 = new problem42578();
//        problem42578.solution(new String[][]{{"yellowhat","headgear"},{"bluesunglasses","eyewear"},{"green_turban","headgear"}});
//        problem42578.solution(new String[][]{{"crowmask", "face"},{"bluesunglasses", "face"},{"smoky_makeup", "face"}});
//        problem42578.solution(new String[][]{{"a","aa"},{"b","aa"},{"c","aa"},{"aa","bb"},{"bb","bb"},{"c_c","bb"},{"aaa","cc"},{"bbb","cc"},{"ccc","cc"}});
//        problem42578.solution(new String[][]{{"a","a"},{"b","a"},{"c","a"},{"a","b"},{"b","b"},{"a","c"}});
        problem42578.solution(new String[][]{{"a","a"},{"b","a"},{"a","b"},{"a","c"},{"a","d"}});
    }


    public int solution(String[][] clothes) {
        HashMap<String, Integer> store = new HashMap<>();
        String keyword = "";
        int answer = 1;
        int count = 1;
        for (int i=0; i<clothes.length;i++) {
            keyword = clothes[i][1];
            if (store.containsKey(keyword)) {
                store.put(keyword, store.get(keyword) + 1);
            } else {
                store.put(keyword, 1);
            }
        }

        answer = store.size();

        if (store.size() > 1) {
            for (String key : store.keySet()) {
                count *= store.get(key) + 1;
            }
            count = count - 1;
        }
        answer += count;
        System.out.println(answer);
        return answer;
    }
}
