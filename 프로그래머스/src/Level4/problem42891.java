package Level4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.PriorityQueue;

public class problem42891 {

    public static void main(String[] args) {
        problem42891 problem42891 = new problem42891();
        problem42891.solution(new int[]{3,1,2}, 5);
    }

    public class Food {
        private int index;
        private int time;

        public Food(int index, int time) {
            this.index = index;
            this.time = time;
        }
    }

    public int solution(int[] food_times, long k) {
        int answer = 0;
        int max = -1;
        int size = food_times.length;
        int index = 0;

        PriorityQueue<Food> queue = new PriorityQueue<>(new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.time - o2.time;
            }
        });

        for (int food_time : food_times) {
            max = Math.max(max, food_time);
            queue.add(new Food(index++, food_time));
        }

        if (max >= k) return -1;

        long total = 0;
        long prev = 0;

        while(total + (queue.peek().time - prev) * size <= k) {
            int pick = queue.poll().time;
            total += (pick - prev) * size;
            size--;
            prev = pick;
        }

        ArrayList<Food> list = new ArrayList<>();

        while(!queue.isEmpty()) list.add(queue.poll());

        Collections.sort(list, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.index - o2.index;
            }
        });

        answer = list.get((int)(k-total)%size).index + 1;

        System.out.println(answer);
        return answer;
    }
}
