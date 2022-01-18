package Level2;


import java.util.Stack;

public class problem12973 {

    public static void main(String[] args) {
        problem12973 problem12973 = new problem12973();
        problem12973.solution("baabaa");
    }

    public int solution(String s) {
        int answer = -1;
        Stack<Character> stack = new Stack<>();
        char[] words = s.toCharArray();
        for(char word: words) {
            if (stack.isEmpty() || stack.peek() != word) stack.push(word);
            else if (stack.peek() == word) stack.pop();
        }

        answer = stack.size() == 0 ? 1 : 0;
        return answer;
    }
}
