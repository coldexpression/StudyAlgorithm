package Level2;

import java.util.List;
import java.util.ArrayList;

public class problem42586 {

    public static void main(String[] args) {
        System.out.println(1%2);
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int index = 0;
        int count = 1;
        List<Integer> store = new ArrayList<>();
        List<Integer> countStore = new ArrayList<>();

        // [96,94] [3,3]
        for(int i=0;i<progresses.length;i++) {
            int mok = (100 - progresses[i]) / speeds[i];
            int nam = (100 - progresses[i]) % speeds[i];
            if (nam == 0) {
                mok = mok;
            } else {
                mok = mok + 1;
            }
            store.add(mok);
        }

        while(!store.isEmpty()) {
            index = 0;
            count = 1;
            int i = 1;
            while(true) {
                if (store.size() == 1) {
                    store.remove(0);
                    break;
                }
                if (store.get(index) >= store.get(i)) {
                    count++;
                    store.remove(i);
                } else {
                    store.remove(index);
                    break;
                }
            }
            countStore.add(count);

        }
        answer = new int[countStore.size()];
        for(int i=0;i<answer.length;i++) {
            answer[i] = countStore.get(i);
        }
        return answer;
    }
}
