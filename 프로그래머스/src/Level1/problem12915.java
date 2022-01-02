package Level1;

import java.util.ArrayList;
import java.util.List;

public class problem12915 {

    public static void main(String[] args) {
        problem12915 problem12915 = new problem12915();
        String[] solution = problem12915.solution(new String[]{"abzcd", "cdzab", "abzfg", "abzaa", "abzbb", "bbzaa"}, 2);

    }

    public String[] solution(String[] strings, int n) {
        String[] answer = new String[strings.length];
        String tmp = "";
        int count = 0;
        int min = 0;
        int minIndex = 0;

        while(count < strings.length) {
            min = (int)strings[count].charAt(n);
            minIndex = count;
//            System.out.println(min);
//            System.out.println(strings[count]);
            for (int i = count + 1; i < strings.length; i++) {
                if (min > (int)strings[i].charAt(n)) {
                    min = (int)strings[i].charAt(n);
                    minIndex = i;
//                    tmp = strings[i - 1];
//                    strings[i - 1] = strings[i];
//                    strings[i] = tmp;
                } else if (min == (int)strings[i].charAt(n)) {
                    String[] split1 = strings[i].split("");
                    String[] split2 = strings[minIndex].split("");
                    int sumA = 0;
                    int sumB = 0;
                    for(int j=0;j<split1.length;j++) {
                        sumA += split1[j].charAt(0);
                        sumB += split2[j].charAt(0);
                    }
                    minIndex = sumA < sumB ? i : minIndex;
                }
            }
            tmp = strings[count];
            strings[count] = strings[minIndex];
            strings[minIndex] = tmp;
            count++;
        }

        for(int i=0;i < strings.length;i++) {
            answer[i] = strings[i];
        }

        for (String s : answer) {
            System.out.println(s);
        }

        return answer;
    }
}
