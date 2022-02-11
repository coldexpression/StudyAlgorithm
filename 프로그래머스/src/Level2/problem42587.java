package Level2;

import java.util.*;

public class problem42587 {

    public static void main(String[] args) {
        problem42587 problem42587 = new problem42587();
        problem42587.solution(new int[]{1, 1, 9, 1, 1, 1}, 0);
    }

    public int solution(int[] priorities, int location) {
        int answer = 0;
        int count = 0;
        int waitNum = 1;
        Map<Integer, Integer> store = new HashMap<>();
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        Stack<Integer> stack = new Stack<>();
        for(int num: priorities) queue.add(num);
        while(!queue.isEmpty()) {
             stack.add(queue.poll());
        }



        while(true) {
            if (priorities[count] == stack.peek()) {
                store.put(count, waitNum);
                stack.pop();
                waitNum++;
            }

            if (store.size() == priorities.length) break;

            count++;

            if (count >= priorities.length) {
                count = 0;
            }
        }

        answer = store.get(location);
        System.out.println(answer);

        return answer;
    }
}
