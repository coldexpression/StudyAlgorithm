package Level3;

import java.util.*;

public class problem12971 {

    public static void main(String[] args) {
        problem12971 problem12971 = new problem12971();
//        problem12971.solution(new int[]{14,6,5,11,3,9,2,10});
//        problem12971.solution(new int[]{1,3,2,5,4});
//        problem12971.solution(new int[]{1,2,4,3});
        problem12971.solution(new int[]{5,1,16,17,16});
    }

    public int solution(int sticker[]) {
        int answer = 0;
        int front = 0;
        int rear = 0;
        int a1 = 0;
        int index = 0;
        HashSet<Integer> currentIndex = new HashSet<>();
        int lastIndex = sticker.length - 1;
        for (int start = 0; start <= lastIndex; start++) {
            index = 0;
            a1 = 0;
            if (sticker.length % 2 == 0 && start == 2) {
                break;
            }
            System.out.println("start >> " + start);
            for (int i = start; i <= lastIndex + start; i = i + 2) {
                index = i > lastIndex ? i - (lastIndex + 1)  : i;
                System.out.println("i >> " + i);
                front = index + 1 > lastIndex ? (lastIndex + 1) - lastIndex - 1 : index + 1;
                rear = index - 1 < 0 ? (lastIndex + 1) + index - 1 : index - 1;
                if (!currentIndex.contains(index)) {
                    a1 += sticker[index];
                    currentIndex.add(front);
                    currentIndex.add(rear);
                    currentIndex.add(index);
                }
            }
            System.out.println(a1);
            answer = Math.max(answer, a1);
            currentIndex.clear();
        }

        System.out.println(answer);
        return answer;
    }
}
