package SkillUp;

import java.util.*;

public class p1 {


    public static void main(String[] args) {
        p1 p1 = new p1();
        p1.solution(new int[]{1, 2, 3, 9, 10, 12}, 500);
    }

    public int solution(int[] scoville, int K) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i : scoville) {
            queue.add(i);
        }

        while(queue.size() >= 2) {
            if (queue.peek() >= K) break;
            int p1 = queue.poll();
            int p2 = queue.poll();
            int num = p1 + (p2*2);
            queue.add(num);
            answer++;
        }
        if (!queue.isEmpty()) {
            answer = queue.poll() >= K ? answer : -1;
        }
        System.out.println(queue);
        System.out.println(answer);
        return answer;
    }

}
