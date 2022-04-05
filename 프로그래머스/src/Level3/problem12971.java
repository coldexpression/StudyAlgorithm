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
        int n = sticker.length;
        int[] dp1 = new int[n];
        int[] dp2 = new int[n];

        // 첫 번째 스티커를 무조건 사용하는 경우 + 마지막 스티커는 사용하지 않는다.
        dp1[0] = sticker[0];
        dp1[1] = dp1[0];
        for(int i=2;i<n;i++) {
            dp1[i] = Math.max(dp1[i-2] + sticker[i], dp1[i-1]);
        }

        // 첫 번째 스티커를 사용하지 않는 경우 + 마지막 스티커는 사용한다.
        dp2[0] = 0;
        dp2[1] = sticker[1];
        for(int i=2;i<n;i++) {
            dp2[i] = Math.max(dp2[i-2] + sticker[i], dp2[i-1]);
        }
        answer = Math.max(dp1[n-2], dp2[n-1]);
        System.out.println(answer);
        return answer;
    }
}
