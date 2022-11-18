package Level2;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class problem135807 {

    public static void main(String[] args) {

    }

    public int solution(int[] arrayA, int[] arrayB) {
        int answer = 0;
        int answerA = 0;
        int answerB = 0;
        int middleA = 0;
        int middleB = 0;
        PriorityQueue<Integer> aQueue = new PriorityQueue<>();
        PriorityQueue<Integer> bQueue = new PriorityQueue<>();

        Arrays.sort(arrayA);
        Arrays.sort(arrayB);

        int startA = arrayA[0];
        for(int i=1;i<Math.sqrt(startA);i++) {
            if (startA % i == 0) {
                aQueue.add(i);
                aQueue.add(startA / i);
            }
        }

        int startB = arrayB[0];
        for(int i=1;i<Math.sqrt(startB);i++) {
            if (startB % i == 0) {
                bQueue.add(i);
                bQueue.add(startB / i);
            }
        }

        System.out.println(aQueue);
        System.out.println(bQueue);


        while(!aQueue.isEmpty()) {
            int st = aQueue.poll();
            boolean check = false;

            for(int j=0;j<arrayA.length;j++) {
                if (arrayA[j] % st != 0 || arrayB[j] % st == 0) {
                    check = true;
                    break;
                }
            }

            middleA = check ? middleA : Math.max(middleA, st);
        }

        while(!bQueue.isEmpty()) {
            int st = bQueue.poll();
            boolean check = false;

            for(int j=0;j<arrayB.length;j++) {
                if (arrayA[j] % st == 0 || arrayB[j] % st != 0) {
                    check = true;
                    break;
                }
            }

            middleB = check ? middleB : Math.max(middleB, st);
        }

        answer = Math.max(middleA, middleB);

        return answer;
    }
}
