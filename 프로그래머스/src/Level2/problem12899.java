package Level2;

import java.util.ArrayList;
import java.util.List;

public class problem12899 {

    public static void main(String[] args) {
        problem12899 problem12899 = new problem12899();
        System.out.println(problem12899.solution(500000000));
    }


    // 1 => 1
    // 2 => 2
    // 3 => 4
    // 4 => 11
    // 5 => 12
    // 6 => 14
    // 7 => 21
    // 8 => 22
    // 9 => 24
    // 10 => 41
    // 11 => 42
    // 12 => 44
    // 13 => 111
    // 14 => 112
    // 15 => 114 16 => 121 17 => 122 18 => 124 19 => 141 20=> 142 21 => 144 22 => 211 23=> 212 24=> 214 25=>221 26=>222 27=>224 28=> 241 29 => 242 30 => 244 31 => 411 39=> 444 40=> 1111 120=> 4444 121=> 11111
    // 412 414 421 422 424 441 442 444
    // 2자리 : 9개 3*3 [나누기: 1 ~ 4]
    // 3자리 : 27개 3*3*3 [나누기: 4 ~ 13]
    // 4자리 : 81개 3*3*3*3
    // 27 > 9 > 3 > 1
    public String solution(int n) {
        List<String> store = new ArrayList<>();
        String answer = "";
        int count = 4;
        store.add("-1");
        store.add("1");
        store.add("2");
        store.add("4");

        if (n <= 3) {
            answer += store.get(n);
            return answer;
        }

        while(n >= count) {
            int a = count / 3;
            int b = count % 3;
            answer = "";
            if (b != 0) {
                if (!store.get(a).isEmpty()) {
                    answer += store.get(a) + store.get(b);
                }
            } else {
                if (!store.get(a).isEmpty()) {
                    answer += store.get(a-1) + store.get(3);
                }
            }
            store.add(answer);
            count++;
        }



        return answer;
    }
}
