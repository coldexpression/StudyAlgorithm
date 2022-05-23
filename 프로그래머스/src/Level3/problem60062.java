package Level3;

import java.util.*;

public class problem60062 {

    static int weakSize;
    static int answer;

    public static void main(String[] args) {
        problem60062 problem60062 = new problem60062();
//        problem60062.solution(12, new int[]{1,5,6,10},new int[]{1,2,3,4});
//        problem60062.solution(200, new int[]{0,100},new int[]{1,1});
        problem60062.solution(200, new int[]{0,10,50,80,120,160},new int[]{1,10, 5, 40, 30});
//        problem60062.solution(12, new int[]{1,3,4,9,10},new int[]{3,5,7});
//        problem60062.solution(12, new int[]{10,0}, new int[]{1,2});
    }

    public int solution(int n, int[] weak, int[] dist) {
        HashSet<Integer> weakSet = new HashSet<>();
        PriorityQueue<Integer> useDist = new PriorityQueue<>(Collections.reverseOrder());
        answer = Integer.MAX_VALUE;

        for (int index : weak) weakSet.add(index);
        for (int index : dist) useDist.add(index);

        weakSize = weak.length;
        find(weakSet, n, 0, useDist);
        answer = answer == Integer.MAX_VALUE ? -1 : answer;
        return answer;
    }

    public void find(HashSet<Integer> weakSet, int n, int count, PriorityQueue<Integer> useDist) {
        int right = -1;
        int circle = 0;
        int distance = 0;
        HashSet<Integer> tempRightSet;
        HashSet<Integer> tempWeakSet;

        if (answer == 1 || answer <= count) return;

        if (weakSet.isEmpty()) {
            answer = Math.min(answer, count);
            return;
        }

        for (int ele : weakSet) {
            if (useDist.isEmpty()) return;
            if (answer > count + 1) {
                tempWeakSet = new HashSet<>(weakSet);
                distance = useDist.poll();
                right = ele - distance;

                if (right < 0) {
                    right += n;
                    circle = right <= ele ? 1 : 0;
                }

                if (circle == 1) {
                    answer = 1;
                    return;
                }
                tempWeakSet = checker(ele, right, n, tempWeakSet);
                // tempWeakSet.removeAll(tempRightSet);
                find(tempWeakSet, n, count + 1, useDist);
                useDist.add(distance);
            } else return;
        }
    }

    public HashSet<Integer> checker(int start, int end, int size, HashSet<Integer> weakSet) {
        HashSet<Integer> set = new HashSet<>();

        if (start > end) {
            for (int ele : weakSet) {
                if ((start >= ele && ele >= end)) {
                } else {
                    set.add(ele);
                }
            }
        }

        if (start <= end) {
            for (int ele : weakSet) {
                if ((start >= ele && ele >= 0) || (end <= ele && ele < size)) {
                } else {
                    set.add(ele);
                }
            }
        }
        return set;
    }
}
