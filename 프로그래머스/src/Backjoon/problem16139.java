package Backjoon;

import java.util.*;

public class problem16139 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<Character, PriorityQueue<Integer>> map = new HashMap<>();

        String S = sc.next();
        for(int i=0;i<S.length();i++) {
            map.put(S.charAt(i), new PriorityQueue<>());
        }

        for(int i=0;i<S.length();i++) {
            map.get(S.charAt(i)).add(i);
        }

        int q = sc.nextInt();

        for(int i=0;i<q;i++) {
            int count = 0;
            char pickWord = sc.next().charAt(0);
            int start = sc.nextInt();
            int end = sc.nextInt();
            PriorityQueue<Integer> queue = new PriorityQueue<>(map.getOrDefault(pickWord, new PriorityQueue<>()));
            System.out.println(queue);
            while(!queue.isEmpty()) {
                int index = queue.poll();
                if (index > end) {
                    break;
                } else if (index >= start && index <= end) {
                    count++;
                }
            }
            System.out.println(count);
        }
    }
}
