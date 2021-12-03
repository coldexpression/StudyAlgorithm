package Level1;

import java.util.HashMap;
import java.util.Map;

public class problem81301 {
    public static void main(String[] args) {
        problem81301 problem81301 = new problem81301();
        int result = problem81301.solution("one4seveneight");
        System.out.println(result);
    }

    public int solution(String s) {
        int answer= 0;
        Map <String, String> store = new HashMap<>();
        store.put("zero", "0");
        store.put("one", "1");
        store.put("two", "2");
        store.put("three", "3");
        store.put("four", "4");
        store.put("five", "5");
        store.put("six", "6");
        store.put("seven", "7");
        store.put("eight", "8");
        store.put("nine", "9");
        for (String key: store.keySet()) {
//            int start = s.indexOf(key);
//            int end = start + key.length() - 1;
            String result = s.replace(key, store.get(key));
            s = result;
//            System.out.println(s);
        }
        answer = Integer.parseInt(s);
        return answer;
    }
}
