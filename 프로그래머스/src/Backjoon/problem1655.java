package Backjoon;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.*;

public class problem1655 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int answer = 0;

        PriorityQueue<Integer> left = new PriorityQueue<>(Collections.reverseOrder());
        PriorityQueue<Integer> right = new PriorityQueue<>();
        BufferedWriter bf = new BufferedWriter(new OutputStreamWriter(System.out));

        for(int i=0;i<n;i++) {
            int pick = sc.nextInt();
            if (i == 0) {
                left.add(pick);
                answer = left.peek();
            }
            else {
                if (left.size() > right.size()) right.add(pick);
                else if (left.size() < right.size()) left.add(pick);
                else {
                    if (left.peek() > pick) left.add(pick);
                    else right.add(pick);
                }

                while (true) {
                    if (left.peek() <= right.peek()) break;
                    right.add(left.poll());
                    left.add(right.poll());
                }

                if (left.size() == right.size()) answer = left.peek();
                else if (left.size() > right.size()) answer = left.peek();
                else if (left.size() < right.size()) answer = right.peek();
            }
            bf.write(answer+"\n");
        }
        bf.flush();
    }
}
