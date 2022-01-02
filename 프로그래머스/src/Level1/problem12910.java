package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem12910 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] arr, int divisor) {
        int[] answer = {};
        List<Integer> store = new ArrayList<>();

        for(int ele: arr) {
            if (ele % divisor == 0) {
                store.add(ele);
            }
        }

        if (store.size() == 0) {
            answer = new int[1];
            answer[0] = -1;
            return answer;
        }

        answer = new int[store.size()];

        for (int i=0;i<answer.length;i++) {
            answer[i] = store.get(i);
        }

        Arrays.sort(answer);

        return answer;
    }
}
