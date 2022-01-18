package Level2;

import java.util.ArrayList;
import java.util.List;

public class problem12973 {

    public static void main(String[] args) {
        problem12973 problem12973 = new problem12973();
        problem12973.solution("cdcd");
    }

    public int solution(String s) {
        int answer = -1;
        int length = 0;
        int index = 0;
        int count = 0;
        boolean check;
        char pivot;
        List<Character> store = new ArrayList<>();
        char[] words = s.toCharArray();
        for(char word: words) store.add(word);
        while(!store.isEmpty()) {
            check = false;
            count = 0;
            length = store.size();
            if (index == length) {
                answer = 0;
                break;
            }
            pivot = store.get(index);
            for (int i = index+1; i < length; i++) {
                if (pivot == store.get(i)) count++;
                else break;
            }

            if (count > 0) {
                for(int i=0;i<=count;i++) store.remove(index);
                check = true;
            }

            index = check ? 0 : index+1;
        }
        answer = answer == 0 ? 0 : 1;

        return answer;
    }
}
