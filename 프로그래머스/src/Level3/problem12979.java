package Level3;

import java.util.*;

public class problem12979 {
    public static void main(String[] args) {
        problem12979 problem12979 = new problem12979();
//        problem12979.solution(11, new int[]{4,11}, 1);
        problem12979.solution(16, new int[]{2,6,8}, 1);
    }

    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int windowSize = w*2+1;
        int prevPos = 0;
        int a, b, range = 0;
        List<int[]> list = new ArrayList<>();
        for(int position: stations) {
            int start = position - w <= 0 ? 1 : position - w;
            int end = position + w > n ? n : position + w;
            if (start != 1 && start - prevPos - 1 >= 0) {
                range = start - prevPos - 1;
                a = range / windowSize;
                b = range % windowSize;
                answer = b == 0 ? answer + a : answer + a + 1;
            }
            prevPos = end;
        }

        if (prevPos != n) {
            range = n - prevPos;
            a = range / windowSize;
            b = range % windowSize;
            answer = b == 0 ? answer + a : answer + a + 1;
        }
//        for(int position: stations) {
//            int start = position - w;
//            int end = position + w;
//            System.out.println(start);
//            System.out.println(end);
//            if (start < 1 && end <= n) list.add(new int[]{1, end});
//            else if (end > n) list.add(new int[]{start, n});
//            else list.add(new int[]{start, end});
//        }
//
//        for (int[] ints : list) {
//            System.out.println("["+ints[0]+","+ints[1]+"]");
//        }
//
//
//        for(int i=0;i<list.size();i++) {
//            int[] pos = list.get(i);
//            int range = 0;
//            int a, b = 0;
//            if (i == 0) range = pos[0] - 1;
//            else range = pos[0] - prevPos - 1;
//            if (range != -1) {
//                a = range / windowSize;
//                b = range % windowSize;
//                answer = b == 0 ? answer + a : answer + a + 1;
//            }
//            prevPos = pos[1];
//        }
//
//        if (prevPos != n) {
//            int range = n - prevPos;
//            int a = range / windowSize;
//            int b = range % windowSize;
//            answer = b == 0 ? answer + a : answer + a + 1;
//        }

        System.out.println(answer);
        return answer;
    }
}
