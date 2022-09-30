package Level2;

import java.util.*;

public class problem12923 {

    public static void main(String[] args) {
        problem12923 problem12923 = new problem12923();
        problem12923.solution(1, 10);
    }

    public long[] solution(long begin, long end) {
        long[] answer = {};
        Stack<Long> stack = new Stack<>();

        for (long ele = end;ele >= begin;ele--) {
            if (ele != 1) {
                long num = 1;
                int fin = (int)Math.sqrt(ele);
                for(int i=2;i<=fin;i++) {
                    if (ele % i == 0 && ele / i != ele && ele / i <= 10000000) {
                        num = ele / i;
                        break;
                    }
                }
                stack.push(num);
            }
        }

        if (begin == 1) stack.push(0L);
        answer = new long[stack.size()];

        int index = 0;
        while(!stack.isEmpty()) {
            answer[index++] = stack.pop();
        }

        return answer;
    }

}
