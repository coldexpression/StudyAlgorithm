package Level3;

import java.util.*;

public class problem43238 {

    public static void main(String[] args) {

    }
    public long solution(int n, int[] times) {
        long answer = 0;
        long start = 0;
        long end = (long) times[times.length - 1] * n;
        Arrays.sort(times);
        while(start <= end) {
            long middle = (start+end) / 2;
            long sum = 0;
            for (int time : times) {
                sum += middle / time;
            }
            if (sum < n) {
                start = middle + 1;
            } else {
                end = middle - 1;
                answer = middle;
            }
        }
        return answer;
    }
}
