package Level1;

import java.util.*;

public class problem12915 {

    public static void main(String[] args) {
        problem12915 problem12915 = new problem12915();
//        problem12915.solution(new String[]{"abzcd", "cdzab", "abzfg", "abzaa", "abzbb", "bbzaa"}, 2);
        problem12915.solution(new String[]{"sun", "bed", "car"}, 1);

    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        Arrays.sort(strings);
        Arrays.sort(strings, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                char c1 = o1.charAt(n);
                char c2 = o2.charAt(n);
                if (c1 != c2) return c1-c2;
                return 0;
            }
        });

        for(int i=0;i<strings.length;i++) answer[i] = strings[i];

        return answer;
    }
}
