package Level1;

import java.util.Arrays;

public class problem12932 {

    public static void main(String[] args) {
        problem12932 problem12932 = new problem12932();
        problem12932.solution(01);
    }

    public long[] solution(long n) {
        long[] answer = {};
        int count = 0;
        int powNum = String.valueOf(n).length() - 1;
        int[] store = new int[String.valueOf(n).length()];
        while(powNum != -1) {
            store[count] = (int)(n / Math.pow(10, powNum));
            n = (long)(n % Math.pow(10, powNum));
            powNum--;
            count++;
        }

        System.out.println();
        answer = new long[store.length];
        for (int i=0;i<store.length;i++) {
            answer[store.length-1-i] = store[i];
        }


        return answer;
    }
}
