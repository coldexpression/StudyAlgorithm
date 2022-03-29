package Level3;

import java.util.*;

public class problem42628 {

    public static void main(String[] args) {
        problem42628 problem42628 = new problem42628();
        problem42628.solution(new String[]{"I 16","D 1"});
//        problem42628.solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});
//        problem42628.solution(new String[]{"I 7","I 5","I -5","D -1"});
    }

    public int[] solution(String[] operations) {
        int[] answer = {};
        boolean check = false;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        ArrayDeque<Integer> deque = new ArrayDeque<>();
//        Arrays.sort(operations, Collections.reverseOrder());
        for(String word: operations) {
            String op = word.split(" ")[0];
            String num = word.split(" ")[1];
            if (op.equals("I")) {
                queue.add(Integer.parseInt(num));
            } else if(op.equals("D")) {
                while(!queue.isEmpty()) deque.add(queue.poll());
                if (num.equals("1")) deque.pollFirst();
                else if (num.equals("-1")) deque.pollLast();

                while(!deque.isEmpty()) queue.add(deque.poll());
            }

        }

        while(!queue.isEmpty()) deque.add(queue.poll());
        if (deque.isEmpty()) answer = new int[]{0,0};
        else answer = new int[]{deque.peekFirst(), deque.peekLast()};
        for (int i : answer) {
            System.out.print(i + " ");
        }
        return answer;
    }
}
