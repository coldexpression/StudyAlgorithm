package Backjoon;

import java.util.*;

public class problem11286 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                if (Math.abs(o1) == Math.abs(o2)) {
                    return o1 - o2;
                }
                return Math.abs(o1) - Math.abs(o2);
            }
        });
        int n = sc.nextInt();
        for(int i=0;i<n;i++) {
            int input = sc.nextInt();
            if (input != 0) queue.add(input);
            else {
                if (queue.isEmpty()) {
                    System.out.println(0);
                } else {
                    System.out.println(queue.poll());
                }
            }
        }
    }
}
