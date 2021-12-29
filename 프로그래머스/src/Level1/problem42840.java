package Level1;

import java.util.*;

public class problem42840 {
    public static void main(String[] args) {
        problem42840 problem42840 = new problem42840();
        int[] answer = problem42840.solution(new int[]{1,2,3,4,5});
    }

    public int[] solution(int[] answers) {

        // 1번: 1 2 3 4 5 반복 [size = 5]
        // 2번: 2 1 2 3 2 4 2 5 반복 [size = 8]
        // 3번: 3 3 1 1 2 2 4 4 5 5 반복 [size = 10]

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        List<Integer> index = new ArrayList<>();
        int[] answer = {};
        int[] count = new int[3];
        int one_size = one.length;
        int two_size = two.length;
        int three_size = three.length;
        int max = 0;

        if (answers.length == 0) {
            return answer;
        }

        for(int i=0;i<answers.length;i++) {

            count[0] = one[i%one_size] == answers[i] ? count[0]+1 :count[0];
            count[1] = two[i%two_size] == answers[i] ? count[1]+1 : count[1];
            count[2] = three[i%three_size] == answers[i] ? count[2]+1: count[2];
        }

        if (count[0] == count[1] && count[1] == count[2]) {
            answer = new int[3];
            answer[0] = 1;
            answer[1] = 2;
            answer[2] = 3;
            return answer;
        }

        max = -1;

        for(int i=0;i<count.length;i++) {
            if (max < count[i]) {
                max = count[i];
            }
        }


        for(int i=0;i<count.length;i++) {
            if (max == count[i]) {
                index.add(i+1);
            }
        }

        for(int i=0;i<index.size();i++) {
        }

        answer = new int[index.size()];

        for(int i=0;i<index.size();i++) {
            answer[i] = index.get(i);
        }



        return answer;
    }
}
