package Level3;

import java.util.*;

public class problem12927 {

    public static void main(String[] args) {
        problem12927 problem12927 = new problem12927();
        problem12927.solution(99, new int[]{2,15,22,55,55});
    }

    public long solution(int n, int[] works) {
        long answer = 0;
        int length = works.length;
        int minusNum = n / length;
        int endIndex = n % length;
        int pickNum = 0;
        List<Integer> list = new ArrayList<>();
        List<Integer> filterList = new ArrayList<>();
        for(int i=0;i<works.length;i++) list.add(works[i]);
        Collections.sort(list, Collections.reverseOrder());
        System.out.println(list);

        for(int i=0;i<list.size();i++) {
            pickNum = list.get(i);
            pickNum = pickNum - minusNum;
            if (pickNum < 0) {
                endIndex += Math.abs(pickNum);
                pickNum = 0;
            } else if (endIndex != 0 && pickNum != 0) {
                pickNum--;
                endIndex--;
            }
            filterList.add(pickNum);
            answer += Math.pow(pickNum, 2);
        }

        if (endIndex != 0) {
            for(int i=0;i<filterList.size();i++) {
                int pick = filterList.get(i);
                if (pick - endIndex < 0) {
                    answer -= Math.pow(pick, 2);
                    endIndex -= pick;
                } else if (pick - endIndex > 0) {
                    answer -= Math.pow(pick, 2);
                    answer += Math.pow(pick-endIndex, 2);
                    break;
                }
            }
        }

        System.out.println(answer);
        return answer;
    }
}
