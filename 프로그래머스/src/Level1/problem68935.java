package Level1;

import java.util.ArrayList;
import java.util.List;

public class problem68935 {

    public static void main(String[] args) {
        problem68935 problem68935 = new problem68935();
        problem68935.solution(45);
    }

    public int solution(int n) {
        int answer = 0;
        int reminder = 0;
        int quotient = 0;
        List<Integer> store = new ArrayList<>();

        while(n != 0) {
            reminder = n % 3 ;
            quotient = n / 3 ;
            n = quotient;
            store.add(reminder);
        }


        for (int i=0;i<store.size();i++) {
            answer += store.get(store.size()-1 -i) * Math.pow(3, i);
        }



        return answer;
    }
}
