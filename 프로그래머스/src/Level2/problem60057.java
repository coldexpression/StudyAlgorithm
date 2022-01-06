package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem60057 {

    public static void main(String[] args) {
        problem60057 problem60057 = new problem60057();
        problem60057.solution("aabbaccc");
    }

    public int solution(String s) {
        List<Integer> store = new ArrayList<>();
        String wordCount = "";
        int answer = 0;
        int minIndex = 0;
        int maxIndex = 1;
        int count = 0;
        int length = s.length();
        String result = "";
        // aabbaccc
        while(maxIndex != (length + 1)) {
            String tmp = s;
            result = s;
            while (tmp.length() != 0) {
                if (tmp.length() < maxIndex) break;
                count = 0;
                wordCount = "";
                System.out.println("tmp : " + tmp);
                String word = tmp.substring(minIndex, maxIndex);
                System.out.println("word : " + word);
                for (int i = 0; i < s.length(); i++) {
                    if (tmp.length() < word.length()) break;

                    if (tmp.indexOf(word) == 0) {
                        count++;
                        tmp = tmp.replaceFirst(word, "");
                    } else {
                        break;
                    }
                }
                for (int i = 0; i < count; i++) {
                    wordCount += word;
                }
                result = count != 1 ? result.replaceFirst(wordCount, count + word) : result;
                System.out.println("result : " + result);
            }
            store.add(result.length());
            maxIndex++;
        }

        answer = store.get(0);
        for(int i=1;i<store.size();i++) {
            answer = answer > store.get(i) ? store.get(i) : answer;
        }

        return answer;
    }
}
