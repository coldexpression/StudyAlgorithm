package Level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class problem42626 {

    static int MAX_NUM = 1000001;

    public static void main(String[] args) {
        problem42626 problem42626 = new problem42626();
        problem42626.solution(new int[]{1, 2, 3}, 11);
    }

    // [1,2,3,4,5,6] 7
    // [0,5,3,4,5,6] +
    // [0,3,4,5,5,6]
    // [0,0,11,5,5,6] +
    // [0,0,5,5,6,11]
    // [0,0,0,15,6,11] +
    // [0,0,0,6,11,15]
    // [0,0,0,0,28,15] +
    // [0,0,0,0,15,28]
    public int solution(int[] scoville, int k) {
        int answer = 0;
        int index = 0;
        int n1;
        int n2;
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for(int num: scoville) queue.add(num);

        if (k == 0) return 0;

        while(!queue.isEmpty()) {
            n1 = queue.poll();
            if (n1 >= k) break;
            if (queue.peek() == null) return -1;
            n2 = queue.poll();
            System.out.println("n1 : " + n1);
            System.out.println("n2 : " + n2);
            if (n1 < k) {
                int result = scovilleCalc(n1, n2);
                queue.add(result);
                answer++;
            } else {
                break;
            }
        }


//        for(int i=0;i<queue.size();i++) {
//            System.out.print(queue);
//        }
//        int num1 = 0;
//        int num2 = 0;
//        List<Integer> store = new ArrayList<>();
//        for(int num: scoville) store.add(num);
//
//        while(num1 <= k) {
//            int num1Index = findMinIndex(store, MAX_NUM, -1);
//            num1 = store.get(num1Index);
//            int num2Index = findMinIndex(store, MAX_NUM, num1Index);
//            num2 = store.get(num2Index);
//
//
//            if (num1 < k) {
//                store.add(scovilleCalc(num1, num2));
//                store.remove(num1Index);
//                store.remove(num1Index > num2Index ? num2Index : num2Index - 1);
//                answer++;
//            }
//        }


//        for(int i=0;i<scoville.length;i++) {
//            Arrays.sort(scoville);
//            int n1 = scoville[i];
//            int n2 = scoville[i+1];
//            if (n1 < k) {
//                scoville[i] = 0;
//                scoville[i+1] = scovilleCalc(n1, n2);
////                for(int num: scoville) System.out.print(num + " ");
////                System.out.println();
//                answer++;
//            } else if (n1 >= k) {
//                answer = -1;
//                break;
//            }
//        }
        answer = answer == 0 ? -1 : answer;
        System.out.println(answer);
        return answer;
    }

    static int scovilleCalc(int n1, int n2) {
        int answer = n1 + (n2 * 2);
        System.out.println("연산 : " + answer);
        return answer;
    }

    static int findMinIndex(List<Integer> store, int pivot, int index) {
        int min = pivot;
        int minIndex = 0;
        for(int i=0;i<store.size();i++) {
            if (i != index && min > store.get(i)) {
                min = store.get(i);
                minIndex = i;
                System.out.println("들어온 min 값 : " + min);
                System.out.println("들어온 minIndex 값 : " + minIndex);
            }
        }
        return minIndex;
    }
}
