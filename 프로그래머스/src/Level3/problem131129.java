package Level3;

import java.util.HashMap;

public class problem131129 {
    public static void main(String[] args) {
        problem131129 problem131129 = new problem131129();
        problem131129.solution(2023);
    }

    public int[] solution(int target) {
        HashMap<Integer, int[]> map = new HashMap<>();
        int[] answer = new int[2];
        for(int i=1;i<=60;i++) {
            if (i <= 20) {
                map.put(i, new int[]{1, 1});
            } else if (i <= 40) {
                if (i % 3 == 0) map.put(i, new int[]{1, 0});
                else map.put(i, new int[]{2, 2});
            } else if (i <= 49) {
                if (i % 3 == 0) map.put(i, new int[]{1, 0});
                else map.put(i, new int[]{2, 1});
            } else if (i <= 59) {
                if (i % 3 == 0) map.put(i, new int[]{1, 0});
                map.put(i, new int[]{2, 2});
            } else {
                map.put(i, new int[]{1, 0});
            }
        }

        int mok = target / 60;
        int rest = target % 60;

        int[] ints = map.get(rest);

        answer[0] = mok + ints[0];
        answer[1] = ints[1];

        System.out.println("["+answer[0]+","+answer[1]+"]");
        return answer;
    }
}
