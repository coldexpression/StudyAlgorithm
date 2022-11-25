package Level2;

import java.util.Collections;
import java.util.HashMap;
import java.util.PriorityQueue;

public class problem138476 {

    public static void main(String[] args) {
        problem138476 problem138476 = new problem138476();
        problem138476.solution(6, new int[]{1,3,2,5,4,5,2,3});
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i : tangerine) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }

        queue.addAll(map.values());

        while(!queue.isEmpty()) {
            int num = queue.poll();

            if (k - num >= 0) {
                k -= num;
                answer++;
            } else {
                answer++;
                k = 0;
            }

            if (k == 0 || queue.isEmpty()) break;
        }

        return answer;
    }
}
