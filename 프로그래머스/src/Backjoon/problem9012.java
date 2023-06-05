package Backjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class problem9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(bf.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        for(int i=0;i<n;i++) {
            Stack<Character> stack = new Stack<>();
            String input = bf.readLine();
            stack.push(input.charAt(0));
            for(int j=1;j<input.length();j++) {
                char word = input.charAt(j);
                if (word == '(') stack.push('(');
                else {
                    if (!stack.isEmpty() && stack.peek() == '(') stack.pop();
                    else stack.push(')');
                }
            }
            sb.append(stack.isEmpty() ? "YES" : "NO").append("\n");
        }
        System.out.println(sb);
    }
}
