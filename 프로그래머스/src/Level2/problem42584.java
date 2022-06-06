package Level2;

import java.util.*;

public class problem42584 {

    public static void main(String[] args) {

    }

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        int startIndex = 1;
        Queue<Integer> pricesQueue = new LinkedList<>();
        Queue<Integer> stageQueue;
        int count = 0;
        for (int ele : prices) {
            pricesQueue.add(ele);
        }

        while(!pricesQueue.isEmpty()) {
            int pickNum = pricesQueue.poll();
            int seconds = 0;
            for(int i=startIndex;i<prices.length;i++) {
                int compareNum = prices[i];
                seconds++;
                if (pickNum > compareNum) break;
            }
            startIndex++;
            answer[count++] = seconds;
        }


        return answer;
    }
}
