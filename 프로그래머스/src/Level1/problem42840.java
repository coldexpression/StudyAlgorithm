package Level1;

import java.util.*;

public class problem42840 {
    public static void main(String[] args) {
        problem42840 problem42840 = new problem42840();
        int[] answer = problem42840.solution(new int[]{3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5});
    }

    public int[] solution(int[] answers) {

        // 1번: 1 2 3 4 5 반복 [size = 5]
        // 2번: 2 1 2 3 2 4 2 5 반복 [size = 8]
        // 3번: 3 3 1 1 2 2 4 4 5 5 반복 [size = 10]

        int[] one = {1,2,3,4,5};
        int[] two = {2,1,2,3,2,4,2,5};
        int[] three = {3,3,1,1,2,2,4,4,5,5};
        List<Integer> index = new ArrayList<>();
        List<Integer> values = new ArrayList<>();
        int[] answer = {};
        int one_size = one.length;
        int two_size = two.length;
        int three_size = three.length;
        int one_data = 0;
        int two_data = 0;
        int three_data = 0;
        int one_count = 0;
        int two_count = 0;
        int three_count = 0;
        int cnt= 0;
        int max = 0;
        int max_index= 0;

        if (answers.length == 0) {
            return answer;
        }
        for(int i=0;i<answers.length;i++) {

            System.out.println(i%one_size);
            System.out.println(i%two_size);
            System.out.println(i%three_size);

            one_count = one[i%one_size] == answers[i] ? one_count+1 : one_count;
            two_count = two[i%two_size] == answers[i] ? two_count+1 : two_count;
            three_count = three[i%three_size] == answers[i] ? three_count+1: three_count;
        }


        if (one_count != 0) {
            index.add(1);
            values.add(one_count);
        }

        if (two_count != 0) {
            index.add(2);
            values.add(two_count);
        }

        if (three_count != 0) {
            index.add(3);
            values.add(three_count);
        }

        if (index.size() != 0) {
            answer = new int[index.size()];
        } else {
            return answer;
        }


        while(index.size() != 0) {
            max = values.get(0);
            max_index = 0;
            for (int i=1;i<index.size();i++) {
                if (max < values.get(i)) {
                    max = values.get(i);
                    max_index = i;
                }
            }
            answer[cnt] = index.get(max_index);
            index.remove(max_index);
            values.remove(max_index);
            cnt++;
        }


        return answer;
    }
}
