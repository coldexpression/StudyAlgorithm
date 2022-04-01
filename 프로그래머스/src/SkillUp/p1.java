package SkillUp;

import java.util.*;
import java.util.regex.Pattern;

public class p1 {

    public static void main(String[] args) {
        p1 p1 = new p1();
//        p1.solution(new int[]{93,30,55},new int[]{1,30,5});
        p1.solution(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1});
    }

    public int[] solution(int[] progresses, int[] speeds) {
        int[] answer = {};
        int sum = 0;
        List<Integer> waitList = new ArrayList<>();
        List<Integer> resultList = new ArrayList<>();
        for(int i=0;i<progresses.length;i++) {
            int restTime = 100 - progresses[i];
            int useDay = restTime % speeds[i] == 0 ? restTime / speeds[i] : (restTime / speeds[i]) + 1;
            waitList.add(useDay);
        }
        System.out.println(waitList);
        for(int i=0;i<waitList.size();i++) {
            int count = 1;
            int pivot = waitList.get(i);
            if (sum == progresses.length) break;
            System.out.println(pivot);
            for(int j=i+1;j<waitList.size();j++) {
                if (pivot >= waitList.get(j)) count++;
                else {
                    i = j - 1;
                    break;
                }
            }
            sum += count;
            resultList.add(count);
        }
        System.out.println(resultList);
        answer = resultList.stream().mapToInt(i -> i).toArray();
        return answer;
    }
}
