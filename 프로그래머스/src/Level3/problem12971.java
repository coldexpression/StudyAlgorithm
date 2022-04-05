package Level3;

import java.util.*;

public class problem12971 {

    public static void main(String[] args) {
        problem12971 problem12971 = new problem12971();
//        problem12971.solution(new int[]{14,6,5,11,3,9,2,10});
        problem12971.solution(new int[]{1,3,2,5,4});
    }

    public int solution(int sticker[]) {
        int answer = 0;
        int min = Integer.MAX_VALUE;
        int minIndex = 0;
        int n = sticker.length - 1;
        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        for (int i : sticker) {
            list.add(i);
        }

        for(int i=0;i<list.size();i++) {
            int left = 0;
            int right = 0;
            if (i-1 < 0) {
                left = list.get(list.size()-1);
                right = list.get(i+1);
            }
            else if (i + 1 > list.size() -1) {
                left = list.get(i-1);
                right = list.get(0);
            }
            else {
                left = list.get(i-1);
                right = list.get(i+1);
            }
            scoreMap.put(i, left+right);
        }
        System.out.println(scoreMap);

        while(!scoreMap.isEmpty()) {
            int left = 0;
            int right = 0;
            int frontIndex = 0;
            int rearIndex = 0;
            min = Integer.MAX_VALUE;
            for (int i: scoreMap.keySet()) {
                if (scoreMap.get(i) <= min) {
                    min = scoreMap.get(i);
                    minIndex = i;
                }
            }
            System.out.println("추가된 스티커 : " + sticker[minIndex]);
            answer += sticker[minIndex];
            left = minIndex + 1 > n ? (minIndex + 1) - n - 1 : minIndex + 1;
            right = minIndex - 1 < 0 ? (minIndex - 1) + n + 1 : minIndex - 1;

            scoreMap.remove(minIndex);
            if (scoreMap.getOrDefault(left, Integer.MAX_VALUE) != Integer.MAX_VALUE) scoreMap.remove(left);
            if (scoreMap.getOrDefault(right, Integer.MAX_VALUE) != Integer.MAX_VALUE) scoreMap.remove(right);

            frontIndex = left + 1 > n ? (left + 1) - n - 1 : left + 1;
            rearIndex = right - 1 < 0 ? (right - 1) + n + 1 : right - 1;

            if(scoreMap.getOrDefault(frontIndex, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
                scoreMap.put(frontIndex, scoreMap.get(frontIndex) - sticker[left]);
            }
            if(scoreMap.getOrDefault(rearIndex, Integer.MAX_VALUE) != Integer.MAX_VALUE) {
                scoreMap.put(rearIndex, scoreMap.get(rearIndex) - sticker[right]);
            }

            System.out.println(scoreMap);
        }


        System.out.println(answer);
        return answer;
    }
}
