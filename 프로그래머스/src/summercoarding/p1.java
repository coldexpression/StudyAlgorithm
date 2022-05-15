package summercoarding;

import java.util.*;

public class p1 {

    public static void main(String[] args) {

    }

    public int solution(int[][] atmos) {
        int answer = 0;
        int count = 0;

        for (int[] ele : atmos) {
            int dust = ele[0];
            int miniDust = ele[1];

            if (dust >= 81 && dust <= 150 || miniDust >= 36 && miniDust <= 75) {
                if (count == 0) answer++;

                count++;

            } else if (dust >= 151 && miniDust >= 76) {
                if (count != 0) count = 0;
                else answer++;
            } else if (count > 0) {
                count++;
            }

            if (count == 3) count = 0;

        }

        return answer;
    }
}
