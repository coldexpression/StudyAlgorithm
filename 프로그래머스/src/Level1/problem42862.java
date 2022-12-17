package Level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class problem42862 {

    public static void main(String[] args) {
        problem42862 problem42862 = new problem42862();
        int solution = problem42862.solution(5, new int[]{4,1,2}, new int[]{3,5});

    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        HashSet<Integer> lostSet = new HashSet<>();
        HashSet<Integer> reserveSet = new HashSet<>();
        int[] pass = new int[n+1];
        List<Integer> list = new ArrayList<>();

        Arrays.stream(lost).forEach(ele -> lostSet.add(ele));
        Arrays.stream(reserve).forEach(ele -> reserveSet.add(ele));

        reserveSet.stream().filter(ele -> lostSet.contains(ele))
                .forEach(ele -> list.add(ele));

        list.forEach(ele -> lostSet.remove(ele));
        list.forEach(ele -> reserveSet.remove(ele));

        int idx = 0;
        for (int stu : lostSet) {
            if (stu == 1) pass[stu+1]++;
            else if (stu == n) pass[stu-1]++;
            else {
                pass[stu+1]++;
                pass[stu-1]++;
            }
        }

        for (int stu : reserveSet) {
            if (pass[stu] != 0) {
                answer++;
                pass[stu] = 0;
            }
        }

        return answer;
    }
}
