package Level1;

import java.util.ArrayList;
import java.util.List;

public class problem12921 {

    public static void main(String[] args) {
        problem12921 problem12921 = new problem12921();
        problem12921.solution(10);
    }

    public int solution(int n) {
        int answer = 0;
        int check = 0;
        List<Integer> store = new ArrayList<>();
        store.add(2);
        store.add(3);
        store.add(5);
        store.add(7);
        for(int i=2;i<=n;i++) {
            check = 1;
            answer = i == 2 || i == 3 || i == 5 || i == 7 ? answer + 1 : answer;
            if (i != 2 && i != 3 && i != 5 && i != 7) {
                for(int j=0;j<store.size();j++) {
//                    System.out.println("i : " + i + " storeGET : " + store.get(j));
                    if (i % store.get(j) == 0) {
                        check = 0;
                        break;
                    }
                    check = 1;
                }
                if (check == 1) {
                    store.add(i);
                    answer++;
                }
            }
        }
//        System.out.println(answer);
        return answer;
    }
}
