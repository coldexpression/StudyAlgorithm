package Level3;

import java.util.*;

public class problem64062 {

    public static void main(String[] args) {
        problem64062 problem64062 = new problem64062();
        problem64062.solution(new int[]{2,2,3,3,2,1,4,2,5,1}, 3);
    }

    public int solution(int[] stones, int k) {
        HashMap<Long, List<Integer>> map = new HashMap<>();
        List<Integer> tempList = new ArrayList<>();
        int answer = Integer.MAX_VALUE;
        long windowSum = 0;
        long minNum = 0;
        int minIndex = 0;
        int listMax = 0;
        int initListMax = 0;
        int initIndex = 0;
        // 0 ~ k 까지 합을 윈도우에 저장
        for(int i=0;i<k;i++) {
            windowSum += stones[i];
            if (initListMax < stones[i]) {
                initListMax = stones[i];
                initIndex = i;
            }
        }
        minNum = windowSum;
        tempList.add(initIndex);
        map.put(minNum, tempList);


        // 윈도우 내에서 최소값을 가지는 값을 탐색
        for(int i=1;i<=stones.length-k;i++) {
            List<Integer> list = new ArrayList<>();
            windowSum -= stones[i-1];
            windowSum += stones[i+k-1];
            if (minNum >= windowSum) {
                minNum = windowSum;
                minIndex = i;
                if (map.getOrDefault(minNum, new ArrayList<>()).size() != 0) {
                    list = map.get(minNum);
                    list.add(minIndex);
                    map.put(minNum, list);
                } else {
                    list.add(minIndex);
                    map.put(minNum, list);
                }
            }
        }

        System.out.println("minNum : " + minNum);
        System.out.println("minIndex : " + minIndex);

        for(int i=0;i<map.get(minNum).size();i++) {
            listMax = 0;
            System.out.println(map.get(minNum));
            for(int j=map.get(minNum).get(i);j<map.get(minNum).get(i)+k;j++) {
                listMax = Math.max(listMax, stones[j]);
            }
            System.out.println("기준 합 : " + minNum);
            System.out.println("listMax : " + listMax);
            answer = Math.min(answer, listMax);
        }


        System.out.println(answer);

        return answer;
    }
}
