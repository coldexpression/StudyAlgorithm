package Level2;

import java.util.HashSet;

public class problem131701 {

    public static void main(String[] args) {
        problem131701 problem131701 = new problem131701();

    }

    public int solution(int[] elements) {
        int answer = 0;
        int length = elements.length;
        HashSet<Integer> set = new HashSet<>();

        for (int element : elements) {
            set.add(element);
        }

        for(int i=0;i<length;i++) {
            int sum = 0;
            int current = i;
            boolean rotate = false;

            while(true) {
                if (current == length) {
                    current = 0;
                    rotate = true;
                }

                if (current == i && rotate) break;

                sum += elements[current];
                set.add(sum);
                current++;
            }

        }

        answer = set.size();
        return answer;
    }
}
