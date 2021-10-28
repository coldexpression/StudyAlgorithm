package Level2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class defaulSquare {
    public static void main(String[] args) {
        defaulSquare defaulSquare = new defaulSquare();
        long solution = defaulSquare.solution(4,3);
        System.out.println(solution);
    }

    public long solution(int w, int h) {
        long answer = 1;
        long count = 0;
//        Map<Integer, Double> cor = new HashMap<Integer, Double>();
        double express = h / (double)w;

        for (int i=0; i<=w;i++) {
//            cor.put(i, express * (double) i);
//            System.out.println(cor);
            if (w < h) {
                if (i == 0 || i == w) {
                    count++;
                } else if ((int) (express * (double) i) > express * (double) i) {
                    count++;
                } else if ((int) (express * (double) i) <= express * (double) i) {
                    count = count + 2;
                }
//                System.out.println("cast 후 >> " + (int) (express * (double) i));
//                System.out.println("cast 전 >> " + express * (double) i);
//                cor.clear();
//                System.out.println("================");
//                System.out.println("count 갯수: " + count);
//                System.out.println("================");
            } else if (w == h) {
                count = w;
            } else if (w > h) {
                if ( !(i == 0 || i == w)) {
                    count += 2;
                }
            }
        }

//        System.out.println(cor);
        answer = w*h - count;
        return answer;
    }
}
