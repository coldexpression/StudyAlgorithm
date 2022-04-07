package Level3;

import java.util.*;

public class problem64062 {

    static boolean check;
    public static void main(String[] args) {
        problem64062 problem64062 = new problem64062();
        problem64062.solution(new int[]{2, 4, 5, 3, 2, 1, 4, 2, 5, 1}, 3);
    }

    public int solution(int[] stones, int k) {
        int answer = 0;
        int start = 1;
        int end = 200000000;
        int middle = 0;

        while(start <= end) {
            middle = (start+end) / 2;
            if (!isCheck(stones,k,middle)) {
                end = middle-1;
            } else {
                start = middle + 1;
                answer = Math.max(answer ,middle);
            }
        }

        System.out.println(answer);
        return answer;
    }

    private boolean isCheck(int[] stones, int k, int middle) {
        int count = 0;
        for(int i=0;i<stones.length;i++) {
            if (stones[i] - middle < 0) {
                count++;
            } else {
                count = 0;
            }

            if (count >= k) return false;
        }
        return true;
    }
}
