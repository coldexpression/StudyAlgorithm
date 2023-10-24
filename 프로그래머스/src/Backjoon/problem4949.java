package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class problem4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String input = "";
        while(true) {
            input = bf.readLine();
            if (input.equals(".")) break;
            input = input.replaceAll(" ", "");
            char[] words = input.toCharArray();

            Stack<Character> stack = new Stack<>();
            for (char word : words) {
                if (word == '(' || word == ')' || word == '[' || word == ']') {
                    if (stack.isEmpty()) {
                        stack.push(word);
                        continue;
                    }

                    char peek = stack.peek();
                    if (peek == '(' && word == ')') stack.pop();
                    else if (peek == '[' && word == ']') stack.pop();
                    else stack.push(word);
                }
            }
            sb.append(stack.isEmpty() ? "yes" : "no").append("\n");
        }
        System.out.print(sb.toString());
    }
}
