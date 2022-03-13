package Level2;

import java.util.*;

public class problem12909 {

    public static void main(String[] args) {

    }

    boolean solution(String s) {
        boolean answer = true;
        int left = 0;
        int right = 0;
        char c = 0;
        Stack<Character> stack = new Stack<>();

        for(int i=0;i<s.length();i++) {
            if (s.charAt(i) == '(') left++;
            else right++;
        }

        if (left != right) return false;


        if (s.charAt(0) == '(' && s.charAt(s.length()-1) == ')') {
            for(int i=0;i<s.length();i++) {
                c = s.charAt(i);
                if (stack.isEmpty()) stack.push(c);
                else {
                    if ((stack.peek() == '(' && c == ')')) stack.pop();
                    else stack.push(c);
                }
            }

        } else return false;

        return stack.isEmpty();
    }
}
