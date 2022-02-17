package Level2;

import java.util.*;

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
        HashMap<String, String> exclusiveKey = new HashMap<>();
        List<String> mokStore = new ArrayList<>();
        String keyword = "";
        int answer = 0;
        for (int i=0; i<clothes.length;i++) {
            keyword = clothes[i][1];
            if (store.containsKey(keyword)) {
                store.put(keyword, store.get(keyword) + 1);
            } else {
                store.put(keyword, 1);
            }
        }

        System.out.println(store);
        // [1] 종류별로 한 개씩 입을 경우
        for(Integer score : store.values()) answer += score;


        for(String key: store.keySet()) {
            System.out.println("key : " + key);
            int count = 0;
            // 탐색 해야할 종류의 갯수
            int size = store.size() - exclusiveKey.size();
            mokStore.add(key);
            while (count != size) {
                System.out.println("come in!");
                int mok = 1;
                int subAnswer = 0;
                int check = 0;
                for (String ele : mokStore) {
                    mok *= store.get(ele);
                }

                for(String subKey: store.keySet()) {
                    if(!mokStore.contains(subKey) && !exclusiveKey.containsKey(subKey)) {
                        System.out.println("exclusiveKey : " + exclusiveKey);
                        System.out.println("mokStore : " + mokStore);
                        System.out.println("successSubKEY : " + subKey);
                        subAnswer += mok * store.get(subKey);
                        System.out.println("subAnswer : " + subAnswer);
                        if(check == 0) {
                            mokStore.add(subKey);
                            exclusiveKey.put(mokStore.get(mokStore.size()-1), "");
                            check++;
                        }
                    }
                }
//                mokStore.remove(mokStore.size()-2);
                answer += subAnswer;
                count++;
            }
            System.out.println("come out!");
            System.out.println("middle_answer : " + answer);
            exclusiveKey.put(mokStore.get(0), "");
            mokStore.clear();
        }
        System.out.println(answer);
        return answer;
    }
}
