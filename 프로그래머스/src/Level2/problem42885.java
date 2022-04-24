package Level2;

import java.util.*;
import java.util.stream.*;

public class problem42885 {

    public static void main(String[] args) {
        problem42885 problem42885 = new problem42885();
        problem42885.solution(new int[]{70, 50, 80, 50}, 100);
    }

    public int solution(int[] people, int limit) {
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        int answer = 0;

        int pickNum = 0;
        Arrays.sort(people);
        for(int i=0;i<people.length;i++) deque.add(people[i]);

        while(!deque.isEmpty()) {
            pickNum = deque.pollLast();
            if (!deque.isEmpty() && pickNum + deque.peekFirst() <= limit) deque.pollFirst();
            answer++;
        }

        return answer;
    }
}
