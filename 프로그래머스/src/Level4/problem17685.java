package Level4;

import java.util.Arrays;
import java.util.Comparator;

public class problem17685 {

    public static void main(String[] args) {
        problem17685 problem17685 = new problem17685();
        problem17685.solution(new String[]{"aba", "abba", "aabbba", "abbaaba"});
//        problem17685.solution(new String[]{"go","gone","guild"});
//        problem17685.solution(new String[]{"aaaaa", "aaaab", "aaabb", "aabbb", "abbbb"});
    }

    public int solution(String[] words) {
        // a = 97, z = 122
        int answer = 0;
        int wordLength = 0;

        Arrays.sort(words);

        for (String word : words) {
            wordLength = Math.max(wordLength, word.length());
        }

        for(int i=0;i<words.length;i++) {
            int res = 0;
            if (i == 0) {
                res = getLen(words[i], words[i+1]);
                res = res < words[i].length() ? res + 1 : res;
            } else if (i == words.length - 1) {
                res = getLen(words[i], words[i-1]);
                res = res < words[i].length() ? res + 1 : res;
            } else {
                res = getLen(words[i], words[i-1]);
                res = Math.max(res, getLen(words[i], words[i+1]));
                res = res < words[i].length() ? res + 1 : res;
            }

            answer += res;
        }

        System.out.println(answer);
        return answer;
    }


    public int getLen(String s1, String s2) {
        int length = 0;

        for(int i=0;i<s1.length() && i<s2.length();i++) {
            if (s1.charAt(i) == s2.charAt(i)) {
                length++;
            } else {
                break;
            }
        }
        return length;
    }
}
