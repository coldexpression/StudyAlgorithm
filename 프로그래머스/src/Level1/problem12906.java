package Level1;

import java.util.ArrayList;
import java.util.List;

public class problem12906 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] arr) {
        int[] answer = {};
        int pivot = arr[0];
        List<Integer> store = new ArrayList<>();
        store.add(pivot);

        for (int i=1;i<arr.length;i++) {
            if (pivot != arr[i]) {
                pivot = arr[i];
                store.add(pivot);
            }
        }

        answer = new int[store.size()];
        for (int i=0;i<answer.length;i++) {
            answer[i] = store.get(i);
        }

        return answer;
    }
}
