package Codility.lesson4;
import java.util.*;

public class MissingInteger {

    public int solution(int[] A) {
        int answer = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        HashSet<Integer> set = new HashSet<>();
        int max = 0;
        for(int ele: A) {
            if (ele > 0) set.add(ele);
        }

        Iterator<Integer> iter = set.iterator();

        while(iter.hasNext()) {
            int ele = iter.next();
            queue.add(ele);
            max = Math.max(max, ele);
        }

        if (queue.isEmpty() || queue.peek() != 1) return 1;
        if (max == queue.size()) return max+1;


        int comp = queue.poll();

        while(!queue.isEmpty()) {
            int pick = queue.poll();
            if (comp != pick) {
                if (comp + 1 == pick) {
                    comp = pick;
                } else {
                    answer = comp + 1;
                    return answer;
                }
            }
        }

        answer = comp + 1;

        // write your code in Java SE 8
        return answer;
    }
}
