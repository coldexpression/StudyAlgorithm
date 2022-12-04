package Level2;

import java.sql.SQLOutput;

public class problem140107 {

    public static void main(String[] args) {
        problem140107 problem140107 = new problem140107();
        problem140107.solution(3, 4);
    }

    public long solution(int k, int d) {
        long answer = 0;

        for(int i=0;i<=d;i+=k) {
            long xx = (long)Math.pow(i, 2);
            long dd = (long)Math.pow(d, 2);
            int maxY = (int) Math.sqrt(dd - xx);
            answer += (maxY / k) + 1;
        }

        System.out.println(answer);

        return answer;
    }
}
