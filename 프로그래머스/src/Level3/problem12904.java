package Level3;

import java.util.*;

public class problem12904 {
    public static void main(String[] args) {
        problem12904 problem12904 = new problem12904();
//        problem12904.solution("abcdcba");
//        problem12904.solution("abbb");
        problem12904.solution("ecdabbcadc");
    }

    public int solution(String s) {
        int answer = 0;
        int left = 1;
        int right = s.length()-2;
        int length = 1;

        if (reverseString(s)) return s.length();

        for(int i=0;i<s.length();i++) {
            int size = s.length() - i;
            System.out.println("윈도우 크기 : " + size);
            if (answer != 0) break;
            for(int j=0;j+(size-1)<s.length();j++) {
                int index = 0;
                length = 0;
                System.out.println("시작 위치/단어 : [" + j + "] [" + s.charAt(j) + "]");
                for(int k=j;k<=j+(size-1)/2;k++) {
                    int end = j+(size-1) - index;
                    System.out.println("앞 단어 [" + s.charAt(k) + "] 뒤 단어 [" + s.charAt(end)+"]");
                    if (s.charAt(k) == s.charAt(end)) {
                        length = k == end ? length + 1 : length + 2;
                    } else {
                        length = 0;
                        break;
                    }
                    index++;
                }
                answer = Math.max(answer, length);
            }
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
