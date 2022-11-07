package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class problem132265 {

    public static void main(String[] args) {

    }

    public int solution(int[] topping) {
        int answer = 0;
        HashSet<Integer> left = new HashSet<>();
        HashSet<Integer> right = new HashSet<>();
        HashMap<Integer, Integer> map = new HashMap();

        for (int i : topping) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        left.add(topping[0]);
        for(int i=1;i<topping.length;i++) right.add(topping[i]);

        if (left.size() == right.size()) answer++;

        for(int i=1;i<topping.length-1;i++) {
            if (map.get(topping[i]) - 1 <= 0) right.remove(topping[i]);
            map.put(topping[i], map.get(topping[i]) - 1);
            left.add(topping[i]);

            if (left.size() == right.size()) answer++;
        }
        return answer;
    }
}
