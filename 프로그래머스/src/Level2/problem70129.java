package Level2;

import java.util.*;

public class problem70129 {

    public static void main(String[] args) {
        problem70129 problem70129 = new problem70129();
        problem70129.solution("110010101001");
    }

    public int[] solution(String s) {
        int[] answer = {0, 0};
        int removeZero = 0;
        while(!s.equals("1")) {
            StringBuilder sb = new StringBuilder();
            for(int i=0;i<s.length();i++)
                if (s.charAt(i) == '1') sb.append("1");
            removeZero = s.length() - sb.toString().length() != 0 ? s.length() - sb.toString().length() : s.length();
            answer[1] = removeZero == s.length() ? answer[1] : answer[1] + removeZero;
            s = trans(sb.toString().length());

            answer[0]++;

        }
        return answer;
    }

    private String trans(int n) {
        Stack<Integer> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        int rest = -1;
        while(n != 0) {
            rest = n % 2;
            stack.push(rest);
            n = n / 2;
        }

        while(!stack.isEmpty()) sb.append(stack.pop());
        return sb.toString();
    }
}
