package Level1;

import java.util.HashMap;
import java.util.Map;

public class problem86501 {

    public static void main(String[] args) {

    }

    public int solution(int[] numbers) {
        int answer = 0;
        Map<Integer, Integer> store = new HashMap<>();
        for(int i=0;i<10;i++) {
            store.put(i, 0);
        }

        for(int i=0;i<numbers.length;i++) {
            store.put(numbers[i],1);
        }

        for(int i=0;i<store.size();i++) {
            answer = store.get(i) == 0 ? answer+i : answer;
        }
        return answer;
    }
}
