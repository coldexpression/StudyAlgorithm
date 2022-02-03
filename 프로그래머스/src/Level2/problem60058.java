package Level2;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class problem60058 {


    public static void main(String[] args) {
        problem60058 problem60058 = new problem60058();
        problem60058.solution("(()())()");
    }

    public String solution(String p) {
        String answer = "";
        answer = translate(p);
        System.out.println("답 >> " + answer);
        return answer;
    }

    static String translate(String word) {
        if (word.equals("")) return "";
        int endPoint = findEndPoint(word);
        System.out.println("endPoint >> "+ endPoint);
        String u = word.substring(0,endPoint);
        String v = word.substring(endPoint);
        System.out.println("u >> " + u);
        System.out.println("v >> " + v);
        if (check(u) == 0) {
            return u.concat(translate(v));
        } else {
            System.out.println("스택 안비어있습니다.");
            String temp = "";
            temp = temp.concat("(");
            temp = temp.concat(translate(v));
            temp = temp.concat(")");
            System.out.println("여기 까지 temp >> " + temp);
            u = u.substring(1, u.length()-1);
            System.out.println(u);
            char[] temp2 = u.toCharArray();
            u = "";
            for(int i=0;i<temp2.length;i++) {
                temp2[i] = temp2[i] == '(' ? ')' : '(';
                u += temp2[i];
            }
            temp = temp.concat(u);
            System.out.println("프로세싱 >> " + temp);
            return temp;
        }
    }

    static int findEndPoint(String word) {
        int rightCount = 0;
        int leftCount = 0;
        char[] w = word.toCharArray();
        for(int i=0;i<w.length;i++) {
            if (w[i] == '(') leftCount++;
            else if (w[i] == ')') rightCount++;
            if (rightCount > 0 && rightCount == leftCount) return i+1;
        }
        return -1;
    }

    static int check(String word) {
        Stack<Character> stack = new Stack<>();
        char[] temp = word.toCharArray();
        for(int i=0;i<temp.length;i++) {
            if (stack.isEmpty()) stack.push(temp[i]);
            else {
                if (stack.peek() == '(' && temp[i] == ')')
                    stack.pop();
                else stack.push(temp[i]);
            }
        }
        System.out.println(stack);
        System.out.println("스택 비어있냐? >> " + stack.isEmpty());
        return stack.isEmpty() ? 0 : 1;
    }
}
