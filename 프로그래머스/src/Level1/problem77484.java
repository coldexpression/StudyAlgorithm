package Level1;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

public class problem77484 {
    public static void main(String[] args) {

        problem77484 problem77484 = new problem77484();

        int [] lottos = {44, 1, 0, 0, 31, 25};
        int [] win_nums = {31,10,45,1,6,19};
        int[] result = problem77484.solution(lottos, win_nums);
    }

    public int[] solution(int[] lottos, int[] win_nums) {
        PriorityQueue<Integer> lottosQueue = new PriorityQueue<>();
        PriorityQueue<Integer> win_numsQueue = new PriorityQueue<>();
        int[] answer = new int[2];
        int zeroCount = 0;
        int totalCount = 0;
        int max = 0;
        int min = 0;

        for (int i : lottos) {
            lottosQueue.add(i);
        }

        for (int win_num : win_nums) {
            win_numsQueue.add(win_num);
        }

        while(true) {
            if (lottosQueue.peek() != 0) break;
            lottosQueue.poll();
            zeroCount++;
        }

        while(true) {
            if (win_numsQueue.isEmpty() || lottosQueue.isEmpty()) break;
            int winNum = win_numsQueue.poll();
            int number = lottosQueue.poll();
            totalCount = winNum == number ? totalCount + 1 : totalCount;
        }
        max = Math.min(totalCount + zeroCount, 6);
        min = totalCount - zeroCount < 2 ? 1 : totalCount - zeroCount;


        answer[0] = 7 - max;
        answer[1] = 7 - min;
        return answer;
    }

//    public int[] solution(int[] lottos, int[] win_nums) {
//        int[] answer = new int[2];
//        int count = 0;
//        int zero_count = 0;
//        int worst = 0;
//        int best = 0;
//        for (int number : lottos) {
//            if (number != 0) {
//                for (int lotto_num : win_nums) {
//                    if (number == lotto_num) {
//                        count++;
//                    }
//                }
//            } else if (number == 0) {
//                zero_count++;
//            }
//        }
//        best = count == 0 && zero_count == 0 ? 6 : 7 - (count + zero_count);
//        worst = count <= 1 ?  6 : 7-count;
//        answer[0] = best;
//        answer[1] = worst;
//        return answer;
//    }
}
