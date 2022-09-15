package Level3;

import java.util.*;

public class problem12938 {

    public static void main(String[] args) {
        problem12938 problem12938 = new problem12938();
        problem12938.solution(3, 10);
    }

    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        int count = 0;
        if (n > s) return new int[]{-1};

        while(true) {
            int a = s / n;
            answer[count++] = a;
            n--;
            s = s - a;
            if (n == 0) break;
        }

        Arrays.sort(answer);
        return answer;
    }
}
