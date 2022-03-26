package LinePlusTest;

import java.util.*;
import java.util.regex.Pattern;

public class p1 {

    public static void main(String[] args) {

    }

    public int solution(String[] logs) {
        int answer = 0;
        boolean check = false;
        String[] store = new String[]{"team_name : ","application_name : ","error_level : ","message : "};
        for(String log: logs) {
            HashMap<String, String> box = new HashMap<>();
            check = false;
            for(int i=0;i<store.length;i++) {
                if (!log.contains(store[i])) {
                    answer++;
                    check = true;
                    break;
                }
            }
            if (log.length() > 100) answer++;
            else if (!check) {
                String[] split = log.split(store[0]);
                if (split[0].contains(" ")) {
                    answer++;
                    continue;
                }
                String[] split1 = split[1].split(store[1]);
                box.put(store[0], split1[0].substring(0, split1[0].length()-1));
                String[] split2 = split1[1].split(store[2]);
                box.put(store[1], split2[0].substring(0, split2[0].length()-1));
                String[] split3 = split2[1].split(store[3]);
                box.put(store[2], split3[0].substring(0, split3[0].length()-1));
                box.put(store[3], split3[1].substring(0, split3[1].length()));

                for (String value : box.values()) {
                    if (value.length() == 0 || !Pattern.matches("[a-zA-Z]*$", value)) {
                        answer++;
                        break;
                    }
                }
            }
        }

        return answer;
    }
}
