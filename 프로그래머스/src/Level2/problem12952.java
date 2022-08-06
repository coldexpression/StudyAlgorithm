package Level2;

import java.util.HashMap;
import java.util.HashSet;

public class problem12952 {

    static int[] move = new int[]{-1,1};
    static int answer;

    public static void main(String[] args) {
        problem12952 problem12952 = new problem12952();
        problem12952.solution(4);
    }

    public int solution(int n) {
        answer = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> pivotSet = new HashSet<>();
        HashSet<Integer> leftSet = new HashSet<>();
        HashSet<Integer> rightSet = new HashSet<>();
        dfs(0, n-1, set, pivotSet, leftSet, rightSet, map);
        System.out.println(answer);
        return answer;
    }

    public void dfs(int start, int end, HashSet<Integer> set, HashSet<Integer> pivotSet, HashSet<Integer> leftSet, HashSet<Integer> rightSet, HashMap<Integer, Integer> map) {
        HashSet<Integer> origin = new HashSet<>(set);
        HashSet<Integer> pivot = new HashSet<>(pivotSet);
        HashSet<Integer> tempLeft = new HashSet<>();
        HashSet<Integer> tempRight = new HashSet<>();
        if (start == end + 1) {
            answer++;
            System.out.println("도착!");
            System.out.println("[도착]start : " + start);
            System.out.println("[도착]origin : " + origin);
            return;
        }

        for (int value : leftSet) {
            if (!pivot.contains(value)) origin.remove(value);
            if (value - 1 >= 0) {
                tempLeft.add(value - 1);
                origin.add(value - 1);
            }
        }

        for (int value : rightSet) {
            if (!pivot.contains(value)) origin.remove(value);
            if (value + 1 <= end) {
                tempRight.add(value + 1);
                origin.add(value + 1);
            }
        }

        rightSet.clear();
        leftSet.clear();
        rightSet.addAll(tempRight);
        leftSet.addAll(tempLeft);


        if (start >= 1) {
            int value = map.get(start - 1);
            origin.add(value);
            if (value + 1 <= end) {
                origin.add(value + 1);
                rightSet.add(value + 1);
            }
            if (value - 1 >= 0) {
                origin.add(value - 1);
                leftSet.add(value - 1);
            }
        }


        for (int i = 0; i <= end; i++) {
            if (origin.contains(i)) continue;
            else {
                System.out.println("몇 번째?? : " + start);
                System.out.println("현재 퀸 위치 : " + i);
                System.out.println("MAP !! : " + map);
                System.out.println("origin >>  " + origin);

                pivot.add(i);
                map.put(start, i);
                dfs(start + 1, end, origin, pivot, new HashSet<>(leftSet), new HashSet<>(rightSet), new HashMap<>(map));
                map.remove(start);
                pivot.remove(i);
            }
        }

    }

}
