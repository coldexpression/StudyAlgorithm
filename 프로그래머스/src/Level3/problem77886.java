package Level3;

import java.util.*;

public class problem77886 {

    public static void main(String[] args) {
        problem77886 problem77886 = new problem77886();
        problem77886.solution(new String[]{"1110","100111100","0111111010"});
//        problem77886.solution(new String[]{"1111111110"});
//        problem77886.solution(new String[]{"1011110"});
    }

    public String[] solution(String[] s) {
        String[] answer = new String[s.length];
        int count = 0;

        for (String word : s) {
            int zero = 0;
            if (word.length() <= 3) {
                answer[count++] = word;
            } else {
                Stack<Character> stack = new Stack<>();
//                stack.push(word.charAt(0));
//                stack.push(word.charAt(1));
//                stack.push(word.charAt(2));

                for (int i = 0; i < word.length(); i++) {
                    stack.push(word.charAt(i));
                    if (stack.size() >= 3 && stack.peek() == '0') {
                        char[] temp = new char[3];
                        for (int j = 0; j < 3; j++) {
                            temp[2 - j] = stack.pop();
                        }
                        StringBuilder sb = new StringBuilder();
                        for(int j=0;j<temp.length;j++) sb.append(temp[j]);

                        if (sb.toString().equals("110")) {
                            zero++;
                        } else {
                            for (int j = 0; j < 3; j++) stack.push(temp[j]);
                        }
                    }
                }
                StringBuilder sb = new StringBuilder();
                while(!stack.isEmpty()) {
                    sb.insert(0, stack.pop());
                }

                for(int i=0;i<zero;i++) {
                    int idx = sb.lastIndexOf("0");

                    if (idx == -1) {
                        sb.insert(0, "110");
                    } else {
                        sb.insert(idx+1, "110");
                    }
                }
                answer[count++] = sb.toString();
            }
        }
        return answer;
    }

}
