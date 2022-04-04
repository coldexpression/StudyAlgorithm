package Level3;

import java.util.*;

public class problem12927 {

    public static void main(String[] args) {
        problem12927 problem12927 = new problem12927();
        problem12927.solution(4, new int[]{4,3,3});
    }

    public long solution(int n, int[] works) {
        long answer = 0;
       PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        for (int work : works) {
            queue.add(work);
            answer += Math.pow(work, 2);
        }

        System.out.println(queue);
        while(!queue.isEmpty()) {
            if (n == 0) break;
            int pick = queue.poll();
            answer -= Math.pow(pick, 2);
            if (pick - 1 > 0) {
                pick--;
                queue.add(pick);
                answer += Math.pow(pick, 2);
            }
            n--;
        }
        System.out.println(answer);
        return answer;
    }
}
