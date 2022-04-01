package SkillUp;

import java.util.*;
import java.util.regex.Pattern;

public class p1 {

    public static void main(String[] args) {
        p1 p1 = new p1();
        p1.solution(new int[]{2,6,8,14});
//        p1.solution(new int[]{1,2,3});
    }

    public int solution(int[] arr) {
        int answer = 0;
        Arrays.sort(arr);
        for(int i=0;i<arr.length-1;i++) {
            int originNum = arr[i];
            int pivotNum = arr[i];
            int originSubNum = arr[i+1];
            int count = 1;
            int subCount = 2;
            System.out.println("기준 원소 : " + originNum);
            System.out.println("비교 원소 : " + originSubNum );
            while(pivotNum != arr[i+1]) {
                if (pivotNum > arr[i+1]) {
                    arr[i+1] = originSubNum * subCount;
//                    System.out.println("현재 비교 원소 : " + arr[i+1]);
                    subCount++;
                    pivotNum = originNum;
                    count = 1;
                }
                pivotNum = originNum*count;
                count++;
            }
            System.out.println(arr[i+1]);
        }
        System.out.println(arr[arr.length-1]);
        return answer;
    }
}
