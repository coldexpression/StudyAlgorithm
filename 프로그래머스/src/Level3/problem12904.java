package Level3;

import java.util.*;

public class problem12904 {
    public static void main(String[] args) {
        problem12904 problem12904 = new problem12904();
//        problem12904.solution("abcdcba");
//        problem12904.solution("abbb");
        problem12904.solution("aabccbab");
    }

    public int solution(String s) {
        int answer = 1;
        int left = 1;
        int right = s.length()-2;
        int length = 1;
        int index = 0;

        if (reverseString(s)) return s.length();

        for(int i=1;i<s.length();i++) {
            char pivot = s.charAt(i);
            int endIndex = Math.min(left, right);
            length = 0;
            String leftWord = String.valueOf(pivot);
            String rightWord = String.valueOf(pivot);
            String word = String.valueOf(pivot);
            for(int j=1;j<=endIndex;j++) {
                if (answer == s.length()) break;
                leftWord = s.charAt(i-j) + word;
                rightWord = word + s.charAt(i+j);
                word = s.charAt(i-j) + word + s.charAt(i+j);
                if (reverseString(leftWord)) {
                    length = leftWord.length();
                } else if (reverseString(rightWord)) {
                    length = rightWord.length();
                } else if (reverseString(word)) {
                    length = word.length();
                }
            }
            left++;
            right--;
            answer = Math.max(answer ,length);
        }
        System.out.println(answer);
        return answer;
    }

    public boolean reverseString(String word) {
        int index = 0;
        boolean check = true;
        for(int i=word.length()-1;i>=0;i--) {
            if (word.charAt(index++) != word.charAt(i)) {
                check = false;
                break;
            }
        }

        return check;
    }
}
