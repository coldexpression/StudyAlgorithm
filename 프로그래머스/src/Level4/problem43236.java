package Level4;

import java.util.*;

public class problem43236 {

    public static void main(String[] args) {
        problem43236 problem43236 = new problem43236();
        problem43236.solution(25, new int[]{2,14,11,21,17}, 2);
//        problem43236.solution(10, new int[]{3,5,7}, 2);
    }

    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        int left = 0;
        int right = distance;
        int mid = 0;
        Arrays.sort(rocks);

        while(left <= right) {
            int prev = 0;
            int count = 0;
            mid = (left+right) / 2;
            System.out.println("left : " + left);
            System.out.println("right : " + right);
            System.out.println("mid : " + mid);

            for(int i=0;i<rocks.length;i++) {

                if (rocks[i] - prev < mid) {
                    count++;
                } else {
                    prev = rocks[i];
                }
            }

            if (distance - rocks[rocks.length-1] < mid) count++;


            if (count > n) {
                right = mid - 1;
            } else {
                answer = mid;
                left = mid + 1;
            }

            System.out.println("count : " + count);
        }

        System.out.println(answer);
        return answer;
    }
}
