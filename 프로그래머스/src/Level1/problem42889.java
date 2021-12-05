package Level1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class problem42889 {

    public static void main(String[] args) {

        problem42889 problem42889 = new problem42889();
        int[] result = problem42889.solution(5, new int[]{4, 4, 4, 4, 4});
    }

    // store 1 - 0.1 , 2 - 0.5, 3 - 0.3

    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int members = 0;
        int fail = 0;
        int count = 0;
        double result = 0;
        List<Integer> index_store = new ArrayList<>();
        Map<Integer, Double> store = new HashMap<>();
        for(int i=1; i<=N; i++) {
            fail = 0;
            members = 0;
            for(int level: stages) {
                if (i<=level) {
                    members++;
                    fail = i == level ? fail+1 : fail;
                }
                result = members == 0 ? 0.0 : (double)fail/members;
                store.put(i,result);
//                System.out.println("현재 스테이지: " + i + " // " + "비교 스테이지: " + level + " 결과: " + (double)fail/members);
            }
            if(index_store.size() == 0) {
                index_store.add(i);
            } else {
                for(int j=1;j<=store.size();j++) {
                    if (i != j && store.get(i) <= store.get(j)) {
                        count++;
                    }
                }
                index_store.add(count, i);
                count = 0;
            }
        }
        for (int i=0;i<index_store.size();i++) {
            answer[i] = index_store.get(i);
        }
        for(int num: answer) {
            System.out.println(num);
        }
        return answer;
    }
}
