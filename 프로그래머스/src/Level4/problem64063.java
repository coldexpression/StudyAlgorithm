package Level4;

import java.util.HashSet;
import java.util.PriorityQueue;

public class problem64063 {

    public static void main(String[] args) {
        problem64063 problem64063 = new problem64063();
//        problem64063.solution(100, new long[]{3,3,4,5,6,7,3,100,51,1,1,52,1,1});
        problem64063.solution(20, new long[]{1,2,3,4,5,6,7,8,9,10,1,2,3,4,5,6,7,8,9,10});

    }

    public long[] solution(long k, long[] room_number) {
        long[] answer = new long[room_number.length];
        long max = k;
        long midMax = 0;
        HashSet<Long> set = new HashSet<>();

        for(int i=0;i<room_number.length;i++) {
            long ele = room_number[i];
            System.out.println("현재 ele : " + ele);
            System.out.println("현재 max : " + max);

            if (!set.contains(ele)) {
                set.add(ele);
                answer[i] = ele;
                midMax = Math.max(midMax, ele);
            } else {
                long left = ele;
                long right = max;
                PriorityQueue<Long> queue = new PriorityQueue<>();

                while(true) {
                    long divider = (left+right)/2;
                     System.out.println("**divider : " + divider);

                    if (!set.contains(divider)) {
                        queue.add(divider);
                    }

                    if (ele > divider) {
                        left = divider;
                    } else if (ele < divider){
                        right = divider;
                    } else {
                        max = Math.max(max, ele);
                        break;
                    }
                }

                System.out.println("미드 맥스 ! : " + midMax);
                if (!queue.isEmpty()) {
                    long pick = queue.poll();
                    System.out.println("선택 !! : " + pick);
                    for (long j = ele; j <= pick; j++) {
                        if (!set.contains(j)) {
                            answer[i] = j;
                            set.add(j);
                            midMax = Math.max(midMax, j);
                            break;
                        }
                    }
                } else {
                    answer[i] = midMax + 1;
                    set.add(midMax+1);
                    midMax++;
                }
            }

            System.out.println("answer["+i+"] = " + answer[i]);
        }

        for(int i=0;i<answer.length;i++)
            System.out.print(answer[i] + " ");

        System.out.println();
        return answer;
    }
}
