package Level2;

import java.util.*;

public class problem150369 {

    public static void main(String[] args) {
        problem150369 problem150369 = new problem150369();
    }

    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;

        Stack<Integer> goStack = new Stack<>();
        Stack<Integer> backStack = new Stack<>();
        int score = 0;


        for(int el : deliveries) {
            goStack.push(el);
            score += el;
        }
        for(int el : pickups) {
            backStack.push(el);
            score += el;
        }

        if (score == 0) return 0;

        while(true) {
            answer += Math.max(goStack.size(), backStack.size())*2;

            if (goStack.isEmpty() && backStack.isEmpty()) break;

            if (!goStack.isEmpty()) goStack = stackCalc(goStack, cap);

            if (!backStack.isEmpty()) backStack = stackCalc(backStack, cap);

        }

        return answer;
    }

    static Stack<Integer> stackCalc(Stack<Integer> stack, int cap) {

        while(!stack.isEmpty()) {
            if (cap - stack.peek() >= 0) {
                cap -= stack.pop();
            } else {
                int ele = stack.pop();
                stack.push(ele - cap);
                cap = 0;
            }

            if (cap == 0) break;
        }

        while(!stack.isEmpty()) {
            if (stack.peek() == 0) stack.pop();
            else break;
        }


        return stack;
    }
}
