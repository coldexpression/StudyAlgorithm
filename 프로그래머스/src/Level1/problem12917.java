package Level1;

import java.util.Arrays;

public class problem12917 {

    public static void main(String[] args) {
        System.out.println();
    }

    public String solution(String s) {
        String answer = "";
        char[] words = s.toCharArray();
//        int[] score = new int[words.length];
//        for(int i=0;i<words.length;i++) {
//            score[i] = (int)words[i];
//        }
        Arrays.sort(words);

        for (int i=0;i<words.length;i++) {
            answer += words[words.length -1 - i];
        }
        return answer;
    }
}
