package Backjoon;

import java.util.*;

public class problem1655 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();

        int[] ele = new int[n];

        for(int i=0;i<n;i++) ele[i] = sc.nextInt();

        int middle = ele[0];
        System.out.println(middle);
        left.add(middle);

        for(int i=1;i<n;i++) {
            int pick = ele[i];
            left.add(pick);

            if (Math.abs(left.size() - right.size()) >= 2) right.add(left.poll());
            else if (!left.isEmpty() && !right.isEmpty() && left.peek() > right.peek()) {
                right.add(left.poll());
                left.add(right.poll());
            }

            if ((i+1) % 2 == 0) middle = left.peek();
            else {
                if (left.size() > right.size()) middle = left.peek();
                else middle = right.peek();
            }
            System.out.println(middle);
        }
    }
}
