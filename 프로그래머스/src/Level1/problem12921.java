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
        boolean check;
        for(int i=2;i<=n;i++) {
            check = false;
            for(int j=2;j<=Math.sqrt(n);j++) {
                if (i % j == 0) {
                    check = true;
                    break;
                }
            }
            answer = check ? answer : answer + 1;
        }
        return answer;
    }
}
