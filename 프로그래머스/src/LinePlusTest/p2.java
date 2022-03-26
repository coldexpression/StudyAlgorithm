package LinePlusTest;

import java.util.*;
import java.util.regex.Pattern;

public class p2 {

    public static void main(String[] args) {
        p2 p2 = new p2();
        p2.solution(new String[]{"line in line", "LINE", "in lion"}, 5);
    }

    public int solution(String[] sentences, int n) {
        int answer = -1;
        boolean upperCheck = false;
        HashSet<String> wordStore = new HashSet<>();
        for(int i=0;i<sentences.length;i++) {
            if (Pattern.matches("^[A-Z]*$", sentences[i])) upperCheck = true;
            for(int j=0;j<sentences[i].length();j++) {
                if (sentences[i].charAt(j) != ' ') {
                    wordStore.add(String.valueOf(sentences[i].charAt(j)).toLowerCase(Locale.ROOT));
                }
            }
            sentences[i] = sentences[i].trim();
        }

        System.out.println(wordStore);
        return answer;
    }
}
