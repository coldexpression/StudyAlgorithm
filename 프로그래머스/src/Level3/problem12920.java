package Level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class problem12920 {

    public static void main(String[] args) {
        problem12920 problem12920 = new problem12920();
        problem12920.solution(6, new int[]{1,2,3});
    }

    public int solution(int n, int[] cores) {
        int answer = 0;
        int left = 0;
        int right = cores[0]*n;
        int mid = 0;
        int m = 0;
        int time = 0;

        while(left <= right) {
            mid = (left+right) / 2;

            int count = checkCount(mid, cores);

            if (count >= n) {
                m = count;
                time = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }


        m -= n;

        for(int i=cores.length-1;i>=0;i--) {
            int rest = time % cores[i];

            if (rest == 0) {
                if (m == 0) {
                    answer = i + 1;
                    break;
                }
                m--;
            }
        }

        System.out.println("answer : " + answer);

        return answer;
    }

    public int checkCount(int time, int[] cores) {
        int count = cores.length;

        if (time == 0) return cores.length;

        for(int i=0;i<cores.length;i++) {
            count += (time/cores[i]);
        }

        return count;
    }
}
