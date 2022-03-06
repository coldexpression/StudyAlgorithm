package Level2;

import java.util.*;

public class problem76502 {

    Stack<Character> stack = new Stack<>();

    public static void main(String[] args) {

    }

    public int solution(String s) {
        int answer = 0;
        String board = "";
        List<Character> list = new LinkedList<>();
        for(char c: s.toCharArray()) list.add(c);

        int count = 0;
        while(count != s.length()) {
            for(int i=0;i<list.size();i++) stacker(list.get(i));
            if (stack.isEmpty()) answer++;

            stack.clear();
            list.add(list.get(0));
            list.remove(0);
            count++;
        }
        return answer;
    }

    private void stacker(char c) {
        char removeWord = 0;
        switch(c) {
            case ']' : removeWord = '['; break;
            case ')' : removeWord = '('; break;
            case '}' : removeWord = '{'; break;
            default : removeWord = removeWord; break;
        }
        if (!stack.isEmpty()) {
            if (stack.peek() == removeWord) stack.pop();
            else stack.push(c);
        } else stack.push(c);
    }
}
