package Level3;

import java.util.*;

public class problem12987 {

    public static void main(String[] args) {
        problem12987 problem12987 = new problem12987();
        problem12987.solution(new int[]{5,1,3,7}, new int[]{2,2,6,8});
//        problem12987.solution(new int[]{100,100,100,1,1,2,100,5}, new int[]{5,101,101,2,3,5,10,4});
    }

    public int solution(int[] A, int[] B) {
        int answer = 0;
        int start = 0;
        int end = 0;
        List<Integer> aList = new ArrayList<>();
        List<Integer> bList = new ArrayList<>();
        for(int ele: A) aList.add(ele);
        for(int ele: B) bList.add(ele);
        Collections.sort(bList);
        Collections.sort(aList);

        for(int i=0;i<aList.size();i++) {
            for(int j=start;j<bList.size();j++) {
                if (aList.get(i) > bList.get(j)) {
                    answer++;
                    start = j + 1;
                    break;
                }
            }
        }


//        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        PriorityQueue<Integer> queue = new PriorityQueue<>();
//        for (int j : B) queue.add(j);
//        while(!queue.isEmpty()) deque.add(queue.poll());
//
//        for(int ele: A) {
//            if (deque.isEmpty()) break;
//            if (ele <= deque.peekFirst()) {
//                answer++;
//                deque.pollFirst();
//            }
//            else if (ele > deque.peekFirst() && ele < deque.peekLast()) {
//                answer++;
//                deque.pollLast();
//            } else if (ele > deque.peekFirst() && ele > deque.peekLast()) {
//                deque.pollFirst();
//            }
//        }
        System.out.println(answer);
        return answer;
    }
}
