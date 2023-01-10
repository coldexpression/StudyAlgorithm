package Backjoon;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

public class problem11279 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        PriorityQueue<Integer> queue = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });

        int N = sc.nextInt();
        for(int i=0;i<N;i++) {
            int input = sc.nextInt();

            if (input == 0) {
                if (queue.isEmpty()) System.out.println(0);
                else System.out.println(queue.poll());
            } else queue.add(input);
        }
    }
}
