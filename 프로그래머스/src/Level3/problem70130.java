package Level3;

import java.util.*;

public class problem70130 {

    public static void main(String[] args) {
        problem70130 problem70130 = new problem70130();
        problem70130.solution(new int[]{1,2,3,4,5});
    }

    public int solution(int[] a) {
        int answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });

        for(int i=0;i<a.length;i++) {
            map.put(a[i], map.getOrDefault(a[i], 0) + 1);
        }

        for (int key : map.keySet()) {
            int value = map.get(key);
            if (value > 1) {
                queue.add(new int[]{key, value});
            }
        }

        while(!queue.isEmpty()) {
            int pick = queue.poll()[0];
            int count = 0;
            int prev = -1;

            for(int i=0;i<a.length;i++) {
                if (prev == -1) {
                    prev = a[i];
                } else if (prev != -1 && prev != pick && pick == a[i]) {
                    System.out.println("이전 : " + prev);
                    System.out.println("선택 : " + a[i]);
                    prev = -1;
                    count++;
                } else if (prev == pick && pick != a[i]) {
                    System.out.println("이전 : " + prev);
                    System.out.println("선택 : " + a[i]);
                    prev = -1;
                    count++;
                }
            }

            if (count != 0) {
                answer = count * 2;
                break;
            }
        }

        System.out.println(answer);

        return answer;
    }
}
