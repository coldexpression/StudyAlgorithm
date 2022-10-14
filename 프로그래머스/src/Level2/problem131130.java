package Level2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class problem131130 {

    public static void main(String[] args) {
        problem131130 problem131130 = new problem131130();
        problem131130.solution(new int[]{8,6,3,7,2,5,1,4});
    }

    public int solution(int[] cards) {
        int answer = 1;
        int group = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        boolean[] visited = new boolean[cards.length];
        for(int i=0;i<cards.length;i++) {
            if (!visited[i]) {
                visited[i] = true;
                group++;
                int start = i;
                int count = 1;
                while(true) {
                    int index = cards[start] - 1;

                    if (visited[index]) break;
                    count++;
                    visited[index] = true;
                    start = index;
                }
                queue.add(count);
            }
        }

        if (group == 1) return 0;

        for(int i=0;i<2;i++) {
            if (queue.isEmpty()) break;
            answer *= queue.poll();
        }
        return answer;
    }
}
