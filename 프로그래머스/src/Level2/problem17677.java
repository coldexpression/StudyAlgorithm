package Level2;

import java.util.*;
import java.util.regex.Pattern;

public class problem17677 {

    public static void main(String[] args) {
        problem17677 problem17677 = new problem17677();
        problem17677.solution("FRANCE", "french");
    }

    public long solution(String str1, String str2) {
        long answer = 0;
        int min = 0;
        int max = 0;
        boolean check = false;
        double sim = 0;
        Map<String, Integer> store1 = new HashMap<>();
        Map<String, Integer> store2 = new HashMap<>();
        List<String> common = new ArrayList<>();

        for(int i=0;i<str1.length()-1;i++) {
            String split = String.valueOf(str1.charAt(i)) + String.valueOf(str1.charAt(i+1));
            check = Pattern.matches("^[a-zA-Z]*$", split);
            if (check) {
                split = split.toLowerCase();
                if (!store1.containsKey(split)) {
                    store1.put(split, 1);
                } else {
                    store1.put(split, store1.get(split) + 1);
                }
            }
        }

        for(int i=0;i<str2.length()-1;i++) {
            String split = String.valueOf(str2.charAt(i)) + String.valueOf(str2.charAt(i+1));
            split = split.toLowerCase();
            check = Pattern.matches("^[a-zA-Z]*$", split);
            if (check) {
                split = split.toLowerCase();
                if (!store2.containsKey(split)) {
                    store2.put(split, 1);
                } else {
                    store2.put(split, store2.get(split) + 1);
                }
            }
        }

        System.out.println(store1);
        System.out.println(store2);

        for(String ele: store1.keySet()) {
            if (store2.containsKey(ele)) {
                min += Math.min(store1.get(ele), store2.get(ele));
                max += Math.max(store1.get(ele), store2.get(ele));
            } else {
                max += store1.get(ele);
            }
        }

        for(String ele: store2.keySet()) {
            if (!store1.containsKey(ele)) {
                max += store2.get(ele);
            }
        }

        System.out.println("min : " + min);
        System.out.println("max : " + max);
        if (min == 0 && max == 0) {
            sim = 1;
        } else {
            sim = ((double) min)/((double)max);
        }
        System.out.println("sim : " + sim);
        answer = (long)(sim * 65536);
        System.out.println(answer);
        return answer;
    }
}
