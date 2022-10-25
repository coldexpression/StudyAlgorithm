package Level2;

import java.util.HashSet;
import java.util.Stack;

public class problem131704 {

    public static void main(String[] args) {
        problem131704 problem131704 = new problem131704();
        problem131704.solution(new int[]{4,3,1,2,5});
    }

    public int solution(int[] order) {
        int answer = 0;
        int max = 0;
        int minus = 1;
        HashSet<Integer> pass = new HashSet<>();
        Stack<Integer> stack = new Stack<>();

        pass.add(order[0]);

        for(int i=1;i<order[0];i++) stack.push(i);

        max = order[0];

        for(int i=1;i<order.length;i++) {
            System.out.println("order : " + order[i]);
            System.out.println("max : " + max);
            System.out.println("pass : " + pass);
            if (order[i] > max) {
                pass.add(order[i]);
                for(int j=max+1;j<order[i];j++) {
                    if (!pass.contains(j)) stack.push(j);
                }
                max = order[i];
            } else {
                if (!stack.isEmpty() && stack.peek() == order[i]) pass.add(stack.pop());
                else break;
            }
        }
        System.out.println(pass);
        answer = pass.size();
        System.out.println(answer);

        return answer;
    }
}
