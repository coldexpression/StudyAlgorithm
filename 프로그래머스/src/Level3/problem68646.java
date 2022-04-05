package Level3;

import java.util.*;

public class problem68646 {

    public static void main(String[] args) {
        problem68646 problem68646 = new problem68646();
        problem68646.solution(new int[]{-16,27,65,-2,58,-92,-71,-68,-61,-33});
//        problem68646.solution(new int[]{9,-1,-5});
    }

    public int solution(int[] a) {
        int answer = 0;
        int minNum = Integer.MAX_VALUE;
        int minIndex = 0;
        int leftMin = Integer.MAX_VALUE;
        int rightMin = Integer.MAX_VALUE;
        boolean pass = false;

        // 가장 작은 수와 위치 찾기
        for(int i=0;i<a.length;i++) {
            if(minNum > a[i]) {
                minNum = a[i];
                minIndex = i;
            }
        }

//        // 가장 작은 수 기준 왼쪽에서 가장 작은 수 찾기
//        for(int i=0;i<minIndex;i++) {
//            if(leftMin > a[i]) {
//                leftMin = a[i];
//            }
//        }
//
//        // 가장 작은 수 기준 오른쪽에서 가장 큰 수 찾기
//        for(int i=minIndex+1;i<a.length;i++) {
//            if(rightMin > a[i]) {
//                rightMin = a[i];
//            }
//        }

//        leftMin = leftMin == Integer.MAX_VALUE ? minNum : leftMin;
//        rightMin = rightMin == Integer.MAX_VALUE ? minNum : rightMin;

        leftMin = a[0];
        rightMin = a[a.length-1];

        System.out.println("minNum : " + minNum);
        System.out.println("minIndex : " + minIndex);
        System.out.println("leftMin : " + leftMin);
        System.out.println("rightMin : " + rightMin);

        // 첫 번째 풍선은 무조건 남는다.
        answer++;

        // 두 번째 풍선부터 마지막 풍선까지 검사
        for(int i=1;i<minIndex;i++) {
            System.out.println("i >> " + i);
            if (leftMin >= a[i]) {
                answer++;
            }
            leftMin = Math.min(leftMin, a[i]);
        }

        answer++;

        for(int i=a.length-2;i>=minIndex;i--) {
            if (rightMin >= a[i]) {
                answer++;
            }
            rightMin = Math.min(rightMin, a[i]);
        }

        System.out.println(answer);
        return answer;
    }
}
