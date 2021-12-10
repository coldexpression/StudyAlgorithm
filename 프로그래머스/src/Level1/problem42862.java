package Level1;

import java.util.ArrayList;
import java.util.List;

public class problem42862 {

    public static void main(String[] args) {
        problem42862 problem42862 = new problem42862();
        int solution = problem42862.solution(5, new int[]{4,1,2}, new int[]{3,5});

    }

    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        int temp = 0;
        int cnt = 0;
        int count = 0;
        int new_lost_index = 0;
        int new_reserve_index = 0;
        int min = 0;
        int[] new_lost = {};
        int[] new_reserve = {};
        List<Integer> store = new ArrayList<>();

        for (int i=0; i<reserve.length; i++) {
            for (int j=0; j<lost.length; j++) {
               if (reserve[i] == lost[j]) {
                   reserve[i] = 0;
                   lost[j] = 0;
                   count++;
                   break;
               }
            }
        }

        new_lost = new int[lost.length-count];
        new_reserve = new int[reserve.length-count];

        for (int i=0;i<reserve.length;i++) {
            if (new_reserve_index == new_reserve.length) break;
            if (reserve[i] != 0) {
                new_reserve[new_reserve_index] = reserve[i];
                new_reserve_index++;
            }
        }

        for (int i=0;i<lost.length;i++) {
            if (new_lost_index == new_lost.length) break;
            if (lost[i] != 0) {
                new_lost[new_lost_index] = lost[i];
                new_lost_index++;
            }
        }


        for (int i=0;i<new_lost.length-1;i++) {
            min = new_lost[i];
            for (int j=i;j<new_lost.length;j++) {
                if (min > new_lost[j]) {
                    temp = new_lost[j];
                    new_lost[j] = min;
                    min = temp;
                }
            }
            new_lost[i] = min;
        }

        for (int i=0;i<new_reserve.length-1;i++) {
            min = new_reserve[i];
            for (int j=i;j<new_reserve.length;j++) {
                if (min > new_reserve[j]) {
                    temp = new_reserve[j];
                    new_reserve[j] = min;
                    min = temp;
                }
            }
            new_reserve[i] = min;
        }


        for (int i=0;i<new_reserve.length;i++) {
            for (int j=0;j<new_lost.length;j++) {
                if (!store.contains(new_lost[j])) {
                    if (new_reserve[i] == 1 && new_lost[j] == 2) {
                        cnt++;
                        store.add(new_lost[j]);
                    } else if (new_reserve[i] == n && new_lost[j] == n - 1) {
                        cnt++;
                        store.add(new_lost[j]);
                    } else if ((new_lost[j] == new_reserve[i] - 1 || new_lost[j] == new_reserve[i] + 1) && new_lost[j] != new_reserve[i]) {
                        cnt++;
                        store.add(new_lost[j]);
                        break;
                    }
                }
            }
        }



        answer = n - new_lost.length + cnt;


        return answer;
    }
}
