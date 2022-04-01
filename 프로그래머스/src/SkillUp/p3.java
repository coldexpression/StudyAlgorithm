package SkillUp;

import java.util.*;
import java.util.Locale;

public class p3 {

    public static void main(String[] args) {
        p3 p3 = new p3();
        p3.solution(" 1A 3people  ab  unFollowed me KK K AbC abC ddVDc        ");
    }

    public String solution(String s) {
        String answer = "";
        List<String> store = new ArrayList<>();
        String[] words = s.split(" ");
        for(String word: words) {
            if (!word.equals("")) {
                if (Character.isDigit(word.charAt(0))) {
                    String subString = word.substring(1).toLowerCase();
                    word = word.charAt(0) + subString;
                } else {
                    word = word.toLowerCase(Locale.ROOT);
                    word = word.replaceFirst(String.valueOf(word.charAt(0)), String.valueOf(word.charAt(0)).toUpperCase());
                }
            }
            store.add(word);
        }
        System.out.println(store);
        for(int i=0;i<store.size();i++) {
            answer = i == store.size() -1 ? answer + store.get(i) : answer + store.get(i) + " ";
        }
        if(answer.length() != s.length()) {
            while(answer.length() != s.length()) {
                answer += " ";
            }
        }

        System.out.println(answer);
        return answer;
    }
}
